import json

JSON_FILE = "user_recommendations.json"

def pretty_print_recommendations(json_file, limit=5):
    with open(json_file, "r", encoding="utf-8") as f:
        data = json.load(f)

    print(f"\n📋 Showing {min(limit, len(data))} of {len(data)} user recommendations:\n")
    for entry in data[:limit]:
        print(f"👤 User: {entry['user']}")
        print(f"  👥 Friends: {', '.join(entry['recommended_friends'])}")
        print(f"  ☕ Drinks:  {', '.join(entry['recommended_drinks'])}")
        print("-" * 50)

if __name__ == "__main__":
    pretty_print_recommendations(JSON_FILE, limit=10)