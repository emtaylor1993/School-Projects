"""
pretty_print.py

Displays a preview for the top user recommendations stored in the generated
user_recommendations.json file. It should show each user with their 3 recommended
friends and drinks.

Author:        E. Taylor
Date Created:  April 30, 2025
Date Modified: May 13, 2025
Dependencies:  json
"""

import json

# Location of the generated user_recommendations.json file.
JSON_FILE = "user_recommendations.json"

def pretty_print_recommendations(json_file, limit=5):
    """
    Loads and displays a small summary of each recommendations per user. Change the
    limit when calling the function to determine how many to display.
    """
    with open(json_file, "r", encoding="utf-8") as f:
        data = json.load(f)

    print(f"\n[INFO] Showing {min(limit, len(data))} of {len(data)} user recommendations:\n")
    for entry in data[:limit]:
        print(f"User: {entry['user']}")
        print(f"  Friends: {', '.join(entry['recommended_friends'])}")
        print(f"  Drinks:  {', '.join(entry['recommended_drinks'])}")
        print("-" * 100)

if __name__ == "__main__":
    pretty_print_recommendations(JSON_FILE, limit=10)