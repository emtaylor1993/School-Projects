# COSC710 - Social Networks Analysis Term Project

Description: The term project focuses on the friend and drink recommendation using the Starbucks Idea data (in Assignment02). For the top 500 users whose ideas received the most votes, recommend each of them 3 new friends and 3 drinks that are most related/closest to what they like or suggested in the collected data.

## Instructions:

```
1. Install dependencies: pip install -r requirements.txt
2. Convert SQL to CSV: python parse_sql.py
3. Get top 500 users: python get_top_500.py
4. Build user profiles: python build_user_profiles.py
5. Extract drink titles to label: python extract_drink_titles.py
6. Manually label real drinks from the extracted drinks CSV (once)
7. Get friend recommendations: python recommend_friends.py
8. Get drink recommendations: python recommend_drinks.py
9. Get clean visual JSON output: python merge_recommendations.py
```