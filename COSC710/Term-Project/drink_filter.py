# File: zero_shot_drink_filter.py

"""
Filters suggestions using a zero-shot classification model from HuggingFace.
Detects whether a suggestion title is a "drink idea" without manual labeling.

Output: outputs/filtered_drinks.csv
"""

import pandas as pd
from pathlib import Path
from transformers import pipeline

# Setup
OUTPUT_DIR = Path("outputs")
OUTPUT_FILE = OUTPUT_DIR / "filtered_drinks.csv"
CATEGORIES = ["drink idea", "not a drink"]
CONFIDENCE_THRESHOLD = 0.85


def main():
    print("🔍 Loading suggestions...")
    df = pd.read_csv(OUTPUT_DIR / "suggestions.csv")
    df = df.dropna(subset=["title", "body"])

    # Only from known beverage-related categories
    valid_cats = {"Frappuccino+Beverages", "Coffee+&+Espresso+Drinks", "Tea+&+Other+Drinks"}
    df = df[df["category"].isin(valid_cats)].copy()

    # Load HuggingFace model
    print("🤖 Loading zero-shot classifier (facebook/bart-large-mnli)...")
    classifier = pipeline("zero-shot-classification", model="facebook/bart-large-mnli")

    results = []

    print("🚀 Classifying suggestion titles...")
    for _, row in df.iterrows():
        title = row["title"]
        result = classifier(title, candidate_labels=CATEGORIES)

        label = result["labels"][0]
        score = result["scores"][0]

        if label == "drink idea" and score >= CONFIDENCE_THRESHOLD:
            row_dict = row.to_dict()
            row_dict["score"] = score
            results.append(row_dict)

    # Save filtered results
    filtered_df = pd.DataFrame(results)
    filtered_df.to_csv(OUTPUT_FILE, index=False)
    print(f"✅ Saved {len(filtered_df)} drink suggestions to {OUTPUT_FILE}")


if __name__ == "__main__":
    main()