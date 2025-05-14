"""
recommend_drinks.py

This script recommends 3 new drink ideas for each top user by comparing their
user profiles with drink suggestions.

Author:        E. Taylor
Date Created:  April 30, 2025
Date Modified: May 13, 2025
Dependencies:  joblib, numpy, pandas, pathlib, sklearn
"""

import joblib
import numpy as np
import pandas as pd

from pathlib import Path
from sklearn.metrics.pairwise import cosine_similarity

OUTPUT_DIR = Path("outputs")
MATRIX_DIR = Path("matrix")

def load_data():
    """
    Loads all of the necessary data for generating drink recommendations using the suggestions
    and manually labeled drink whitelist, the TF-IDF vectors and their IDs, and the shared 
    vectorizer user for both of the drinks and users.
    """
    suggestions = pd.read_csv(OUTPUT_DIR / "suggestions.csv")
    whitelist = pd.read_csv(OUTPUT_DIR / "drink_whitelist.csv")

    # Filter for approved drinks
    approved_titles = set(
        whitelist[whitelist["is_drink"] == 1]["title"].str.strip()
    )
    drink_df = suggestions[suggestions["title"].isin(approved_titles)].copy()
    drink_df["title"] = drink_df["title"].fillna("").str.strip()
    drink_df["body"] = drink_df["body"].fillna("").str.strip()

    # Load user TF-IDF profile
    tfidf_users = np.load(MATRIX_DIR / "user_tfidf_matrix.npy")
    user_ids = pd.read_csv(MATRIX_DIR / "user_id_index.csv")["author"].tolist()
    vectorizer = joblib.load(MATRIX_DIR / "tfidf_vectorizer.pkl")

    return drink_df, tfidf_users, user_ids, vectorizer

def main():
    print("[INFO] Generating drink recommendations using manual whitelist.")

    drink_df, tfidf_users, user_ids, vectorizer = load_data()

    if drink_df.empty:
        print("[ERROR] No valid drinks found in whitelist.")
        return

    drink_titles = drink_df["title"].tolist()
    drink_bodies = drink_df["body"].tolist()

    # Vectorize drink suggestion bodies
    tfidf_drinks = vectorizer.transform(drink_bodies)

    # Compute similarity between users and drink suggestions
    sim_matrix = cosine_similarity(tfidf_users, tfidf_drinks)

    recommendations = []

    for i, user in enumerate(user_ids):
        top_idxs = np.argsort(sim_matrix[i])[::-1][:3]
        top_drinks = [drink_titles[j] for j in top_idxs]
        recommendations.append({
            "user": user,
            "drink_1": top_drinks[0],
            "drink_2": top_drinks[1],
            "drink_3": top_drinks[2]
        })

    pd.DataFrame(recommendations).to_csv(OUTPUT_DIR / "drink_recommendations.csv", index=False)
    print("[INFO] Saved drink_recommendations.csv")

if __name__ == "__main__":
    main()
