"""
This script parse the SQL INSERT statements from the sb_ideaforce files and saves them
as CSVs to the outputs/ directory.

Author:        E. Taylor
Date Created:  April 30, 2025
Date Modified: April 30, 2025
Dependencies:  re, pandas, pathlib
"""

import re
import csv
import pandas as pd
from io import StringIO
from pathlib import Path

OUTPUT_DIR = Path("outputs")
SQL_DIR = Path("sb_ideaforce")
OUTPUT_DIR.mkdir(exist_ok=True)

def extract_insert_rows(file_path, table_name, expected_columns):
    """
    Extracts and parses all rows for a specific SQL table.
    Handles multiline strings, quotes, and commas via csv.reader.
    Returns a list of row lists.
    """
    with open(file_path, encoding="utf-8") as f:
        sql = f.read()

    # Extract all `INSERT INTO `table_name` VALUES (...), (...);`
    insert_blocks = re.findall(
        rf"INSERT INTO `{table_name}` VALUES\s*(.+?);", sql, re.DOTALL
    )

    all_rows = []

    for block in insert_blocks:
        # Normalize newlines and quotes for CSV compatibility
        cleaned_block = block.replace("),(", ")\n(")  # split each row to a new line
        cleaned_block = cleaned_block.replace("\\'", "''")  # escape internal quotes

        # Wrap in fake CSV so we can parse safely
        fake_csv = StringIO(cleaned_block)
        reader = csv.reader(fake_csv, delimiter=',', quotechar="'", skipinitialspace=True)

        for row in reader:
            if len(row) == expected_columns:
                all_rows.append([col.strip() for col in row])
            else:
                continue  # skip malformed rows

    return all_rows


def parse_and_export():
    print("[INFO] Parsing SQL Files.")

    suggestions = extract_insert_rows(
        file_path=SQL_DIR / "set_local_sbf_suggestion.sql",
        table_name="sbf_suggestion",
        expected_columns=8
    )
    
    if suggestions:
        pd.DataFrame(suggestions, columns=[
            "suggestionId", "body", "author", "link", "title", "category", "votes", "timestamp"
        ]).to_csv(OUTPUT_DIR / "suggestions.csv", index=False)
        print(f"[INFO] Parsed {len(suggestions)} Suggestions.")
    else:
        print("[ERROR] No valid suggestions parsed.")

    comments = extract_insert_rows(
        file_path=SQL_DIR / "set_local_sbf_comment.sql",
        table_name="sbf_comment",
        expected_columns=6
    )
    
    if comments:
        pd.DataFrame(comments, columns=[
            "commentId", "suggestionId", "body", "author", "link", "timestamp"
        ]).to_csv(OUTPUT_DIR / "comments.csv", index=False)
        print(f"[INFO] Parsed {len(comments)} Comments.")
    else:
        print("[ERROR] No valid comments parsed.")


if __name__ == "__main__":
    parse_and_export()