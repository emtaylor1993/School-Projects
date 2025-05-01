"""
This script processes the suggestions CSV to identify the top 500 voted
users for their ideas. It will output a CSV containing these users and
vote counts.

Author:        E. Taylor
Date Created:  April 30, 2025
Date Modified: April 30, 2025
Dependencies:  pandas, pathlib
"""

import pandas as pd
from pathlib import Path

OUTPUT_DIR = Path("outputs")

def load_suggestions(path):
    """
    Loads the suggestions CSV and ensures the votes column is numeric for DF processing.
    """
    df = pd.read_csv(path)
    df["votes"] = pd.to_numeric(df["votes"], errors="coerce").fillna(0).astype(int)
    return df

def get_top_users(suggestions):
    """
    Groups suggestions by author, sums up the vote counts,
    and returns the top 500 users sorted by total votes.
    """
    vote_totals = (
        suggestions
        .groupby("author", as_index=False)
        .agg(total_votes=("votes", "sum"))
        .sort_values(by="total_votes", ascending=False)
    )
    return vote_totals.head(500)

def main():
    suggestions_file = OUTPUT_DIR / "suggestions.csv"
    output_file = OUTPUT_DIR / "top_500_users.csv"

    print("[INFO] Finding top 500 users by total votes.")
    suggestions = load_suggestions(suggestions_file)
    top_users = get_top_users(suggestions)
    top_users.to_csv(output_file, index=False)
    print("[INFO] Successfully saved top_500_users.csv")

if __name__ == "__main__":
    main()