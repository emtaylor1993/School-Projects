# File: main.py
"""
Main pipeline runner for the Starbucks Idea Recommendation System.
Executes the entire workflow from SQL parsing to final recommendations.
"""

import subprocess
import sys
from pathlib import Path

steps = [
    ("🔍 Parsing SQL files", "parse_sql.py"),
    ("📊 Getting top 500 users", "get_top_500.py"),
    ("🧠 Building user TF-IDF profiles", "build_user_profiles.py"),
    ("🧪 Filtering drink suggestions via zero-shot classification", "drink_filter.py"),
    ("🤝 Recommending friends", "recommend_friends.py"),
    ("🥤 Recommending drinks", "recommend_drinks.py"),
    ("🔗 Merging recommendations", "merge_recommendations.py"),
    ("📋 Previewing results", "pretty_print.py")
]

def run_pipeline():
    print("\n🚀 Starting full pipeline...\n")

    for label, script in steps:
        print(f"{label} ({script})")
        result = subprocess.run([sys.executable, script])

        if result.returncode != 0:
            print(f"❌ Step failed: {script}. Exiting.")
            break
        else:
            print("✅ Done\n")

    print("🎉 Pipeline complete!")

if __name__ == "__main__":
    run_pipeline()