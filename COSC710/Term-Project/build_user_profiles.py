"""
build_user_profiles.py

This script builds a user profile for each of the top 500 most voted users. It
gathers their ideas and comments, combines them into a single document per user,
uses TF-IDF vectorization and saves the results into a matrix.

Author:        E. Taylor
Date Created:  April 30, 2025
Date Modified: May 13, 2025
Dependencies:  joblib, numpy, pandas, pathlib, sklearn
"""

import joblib
import numpy as np
import pandas as pd

from pathlib import Path
from sklearn.feature_extraction.text import TfidfVectorizer

OUTPUT_DIR = Path("outputs")
MATRIX_DIR = Path("matrix")
MATRIX_DIR.mkdir(exist_ok=True)

def load_text_data(suggestions_path, comments_path, top_users_path):
    """
    Loads suggestions, comments, and top user lists from CSVs.
    Returns filtered DataFrames for suggestions and comments,
    restricted to only the top 500 users.
    """
    suggestions = pd.read_csv(suggestions_path)
    comments = pd.read_csv(comments_path)
    top_users = pd.read_csv(top_users_path)
    top_user_ids = set(top_users["author"])
    suggestions = suggestions[suggestions["author"].isin(top_user_ids)]
    comments = comments[comments["author"].isin(top_user_ids)]
    return suggestions, comments, list(top_user_ids)

def build_user_documents(suggestions, comments, user_ids):
    """
    Combines each user's suggestions and comments into a single string.
    Returns a dict: {user_id: combined_text}
    """
    user_docs = {}

    for user in user_ids:
        idea_texts = suggestions[suggestions["author"] == user]["body"].dropna().tolist()
        comment_texts = comments[comments["author"] == user]["body"].dropna().tolist()
        all_text = idea_texts + comment_texts
        user_docs[user] = " ".join(all_text)

    return user_docs

def main():
    print("[INFO] Building user profiles from suggestions and comments.")

    suggestions_path = OUTPUT_DIR / "suggestions.csv"
    comments_path = OUTPUT_DIR / "comments.csv"
    top_users_path = OUTPUT_DIR / "top_500_users.csv"

    suggestions, comments, user_ids = load_text_data(suggestions_path, comments_path, top_users_path)
    user_docs = build_user_documents(suggestions, comments, user_ids)

    # Filter out users with empty or whitespace-only text
    user_texts = []
    filtered_user_ids = []

    for user in user_ids:
        doc = user_docs[user].strip()
        if doc:
            user_texts.append(doc)
            filtered_user_ids.append(user)

    if not user_texts:
        print("[ERROR] No valid user documents found.")
        return

    # Create TF-IDF vectors
    vectorizer = TfidfVectorizer(max_features=5000, stop_words='english')
    tfidf_matrix = vectorizer.fit_transform(user_texts)

    # Save outputs
    np.save(MATRIX_DIR / "user_tfidf_matrix.npy", tfidf_matrix.toarray())
    pd.DataFrame({"author": filtered_user_ids}).to_csv(MATRIX_DIR / "user_id_index.csv", index=False)
    joblib.dump(vectorizer, MATRIX_DIR / "tfidf_vectorizer.pkl")

    print("[INFO] TF-IDF matrix, user index, and vectorizer saved to /matrix")

if __name__ == "__main__":
    main()