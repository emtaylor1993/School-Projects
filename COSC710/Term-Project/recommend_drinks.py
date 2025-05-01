"""
This script recommends 3 new drink ideas for each top user by comparing their
user profiles with drink suggestions.

Author:        E. Taylor
Date Created:  April 30, 2025
Date Modified: April 30, 2025
Dependencies:  joblib, numpy, pandas, pathlib, sklearn
"""

import joblib
import pandas as pd
import numpy as np
import pandas as pd
from pathlib import Path
from sklearn.metrics.pairwise import cosine_similarity

OUTPUT_DIR = Path("outputs")
MATRIX_DIR = Path("matrix")

def load_data():
    """
    Loads the necessary data and recommendation models.
    """
    drinks_df = pd.read_csv(OUTPUT_DIR / "filtered_drinks.csv")
    tfidf_users = np.load(MATRIX_DIR / "user_tfidf_matrix.npy")
    user_ids = pd.read_csv(MATRIX_DIR / "user_id_index.csv")["author"].tolist()
    user_vectorizer = joblib.load(MATRIX_DIR / "tfidf_vectorizer.pkl")
    return drinks_df, tfidf_users, user_ids, user_vectorizer

def main():
    print("[INFO] Recommending drinks with filtered suggestions.")

    drinks_df, tfidf_users, user_ids, vectorizer = load_data()

    if drinks_df.empty:
        print("[ERROR] No valid drink suggestions found.")
        return

    drink_titles = drinks_df["title"].tolist()
    drink_bodies = drinks_df["body"].tolist()
    tfidf_drinks = vectorizer.transform(drink_bodies)
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
    print(f"[INFO] Saved drink_recommendations.csv ({len(recommendations)} users).")

if __name__ == "__main__":
    main()