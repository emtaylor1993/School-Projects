"""
This script recommends 3 similar users as friends for each of the top 500 users
based on their built user profile. 

Author:        E. Taylor
Date Created:  April 30, 2025
Date Modified: May 13, 2025
Dependencies:  numpy, pandas, pathlib, sklearn
"""

import numpy as np
import pandas as pd

from pathlib import Path
from sklearn.metrics.pairwise import cosine_similarity

MATRIX_DIR = Path("matrix")
OUTPUT_DIR = Path("outputs")

def load_profiles():
    """
    Loads the TF-IDF matrix and the corresponding user IDs.
    Returns: (matrix: ndarray, user_ids: list[str])
    """
    matrix = np.load(MATRIX_DIR / "user_tfidf_matrix.npy")
    user_ids = pd.read_csv(MATRIX_DIR / "user_id_index.csv")["author"].tolist()
    return matrix, user_ids

def recommend_friends(matrix, user_ids, top_k=3):
    """
    Computes cosine similarity and returns top_k similar users per user.
    """
    sim_matrix = cosine_similarity(matrix)
    recommendations = []

    for i, user in enumerate(user_ids):
        # Pair user with all other similarity scores (exclude self)
        sim_scores = [(j, score) for j, score in enumerate(sim_matrix[i]) if j != i]
        top_matches = sorted(sim_scores, key=lambda x: x[1], reverse=True)[:top_k]
        friends = [user_ids[j] for j, _ in top_matches]

        recommendations.append({
            "user": user,
            "friend_1": friends[0],
            "friend_2": friends[1],
            "friend_3": friends[2]
        })

    return recommendations

def main():
    print("[INFO] Generating friend recommendations.")
    matrix, user_ids = load_profiles()
    recs = recommend_friends(matrix, user_ids)
    df = pd.DataFrame(recs)
    df.to_csv(OUTPUT_DIR / "friend_recommendations.csv", index=False)
    print(f"[INFO] Saved friend_recommendations.csv ({len(df)} users).")

if __name__ == "__main__":
    main()