"""
extract_drink_titles.py

This script attempts to scan suggestions and extract unique drink titles
from known beverage cartegories.

Author:        E. Taylor
Date Created:  May 13, 2025
Date Modified: May 13, 2025
Dependencies:  pandas, pathlib
"""

import pandas as pd

from pathlib import Path

OUTPUT_DIR = Path("outputs")
SUGGESTIONS_FILE = OUTPUT_DIR / "suggestions.csv"
WHITELIST_FILE = OUTPUT_DIR / "drink_whitelist.csv"

VALID_CATEGORIES = {
    "Frappuccino+Beverages",
    "Coffee+&+Espresso+Drinks",
    "Tea+&+Other+Drinks"
}

def extract_titles():
    """_
    Filters the suggestions of the drink recommendations to include only actual
    drink titles to avoid vague recommendations for each user.
    """
    df = pd.read_csv(SUGGESTIONS_FILE)
    df = df[df["category"].isin(VALID_CATEGORIES)]
    df = df.dropna(subset=["title"])
    df = df[["title"]].drop_duplicates().sort_values("title").reset_index(drop=True)
    df["is_drink"] = ""
    
    df.to_csv(WHITELIST_FILE, index=False)
    print("[INFO] Successfully Created Drink Whitelist.")
    
if __name__ == "__main__":
    extract_titles()