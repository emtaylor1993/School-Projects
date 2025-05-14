"""
merge_recommendations.py

Combines friend and drink recommendation CSVs into one unified JSON file.
Output: outputs/user_recommendations.json

Author:        E. Taylor
Date Created:  April 30, 2025
Date Modified: May 13, 2025
Dependencies:  json, pandas, pathlib
"""

import json
import pandas as pd

from pathlib import Path

OUTPUT_DIR = Path("outputs")

def merge_recommendations(friend_csv, drink_csv, output_json):
    """
    Merges friend and drink recommendation CSVs into a single JSON file.
    """
    friends = pd.read_csv(friend_csv)
    drinks = pd.read_csv(drink_csv)

    # Merge on the 'user' column
    merged = pd.merge(friends, drinks, on="user", how="inner")

    result = []
    for _, row in merged.iterrows():
        result.append({
            "user": row["user"],
            "recommended_friends": [row["friend_1"], row["friend_2"], row["friend_3"]],
            "recommended_drinks": [row["drink_1"], row["drink_2"], row["drink_3"]],
        })

    # Save as JSON
    with open(output_json, "w", encoding="utf-8") as f:
        json.dump(result, f, indent=2)

    print(f"[INFO] Saved merged recommendations to {output_json}")

if __name__ == "__main__":
    merge_recommendations(
        friend_csv=OUTPUT_DIR / "friend_recommendations.csv",
        drink_csv=OUTPUT_DIR / "drink_recommendations.csv",
        output_json="user_recommendations.json"
    )