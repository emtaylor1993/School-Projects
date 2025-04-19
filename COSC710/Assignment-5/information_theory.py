"""
This script implements fundamental information theory metrics that
are often used in data science and machine learning applications.

Author:        E. Taylor
Date Created:  April 19, 2025
Date Modified: April 19, 2025
Dependencies:  numpy, math, sklearn, collections
"""

import numpy as np
import math

from sklearn.metrics import mutual_info_score
from collections import Counter

def entropy(labels):
    """
    Compute the entropy H(x) of a list of labels.
    """
    total = len(labels)
    counts = Counter(labels)
    return -sum((count / total) * math.log2(count / total) for count in counts.values())

def mutual_information(x, y):
    """
    Compute the mutual information I(x, y).
    """
    return mutual_info_score(x, y)

def normalized_mutual_information(x, y):
    """
    Compute the normalized mutual information NMI(x, y).
    """
    h_x = entropy(x)
    h_y = entropy(y)
    mi = mutual_information(x, y)
    return mi / ((h_x + h_y) / 2) if (h_x + h_y) > 0 else 0

def variation_of_information(x, y):
    """
    Compute the variaion of information VI(x, y).
    """
    h_x = entropy(x)
    h_y = entropy(y)
    mi = mutual_information(x, y)
    return h_x + h_y - 2 * mi

if __name__ == "__main__":
    x = [1, 1, 0, 0, 1, 0, 1]
    y = [0, 0, 0, 1, 1, 1, 1]

    print("Entropy H(x):", entropy(x))
    print("Mutual Information I(x,y):", mutual_information(x, y))
    print("Normalized Mutual Information:", normalized_mutual_information(x, y))
    print("Variation of Information:", variation_of_information(x, y))