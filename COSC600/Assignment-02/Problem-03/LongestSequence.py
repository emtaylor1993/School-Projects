# 
# COSC600 Assignment 2, Problem #3 - Longest Sequence Problem
# @author Emmanuel Taylor
#   
# Description:
#   This program will find the longest increasing sequence of adjacent numbers 
#   in a 15x15 2D array with valuse from 0 to 1000.
#  
#   Packages Used:
#       random
#
#   Functions Called:
#       longest_sequence, generate_array, print_array, display_results
#
import random

ARRAY_SIZE = 15

"""
Function Name: longest_sequence
@param  array
@return longest_sequence

Inside the Function:
    1. Iterate through the array and create a sequence for each number's position.
    2. For each sequence in the stack, traverse the array in all 8 directions and
       keep track of the longest sequence of increasing numbers.
    3. Return the longest sequence after traversing the array.
"""
def longest_sequence(array):
    stack = []
    longest_sequence = []
    
    # Traversing the array and keeping track of each longest sequence.
    for row in range(len(array)):
        for col in range(len(array)):
            
            # Add the initial position to the stack.
            curr_sequence = [(array[row][col], (row, col))]
            stack.append(curr_sequence)
            
            # Iterate through the stack and check neighbors of each current position.
            while stack:
                last_sequence = stack.pop()
                last_number, (x, y) = last_sequence[-1]
                
                # Replace the longest sequence if a greater one is found.
                if (len(last_sequence) > len(longest_sequence)):
                    longest_sequence = last_sequence
                
                # Check each neighbor and traverse the array in that direction.
                for new_x, new_y in [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]:
                    next_x, next_y = x + new_x, y + new_y
                    
                    if (0 <= next_x < len(array) and 0 <= next_y < len(array)):
                        next_number = array[next_x][next_y]
                        
                        if next_number > last_number and (next_number, (next_x, next_y)) not in last_sequence:
                            next_sequence = last_sequence + [(next_number, (next_x, next_y))]
                            stack.append(next_sequence)
    
    return longest_sequence

"""
Function Name: generate_array
@ return array

Inside the Function:
    1. Generate an ARRAY_SIZE x ARRAY_SIZE 2D array of random integers from 0 to 1000.
"""
def generate_array():
    array = [[random.randint(0, 1000) for _ in range(ARRAY_SIZE)] for _ in range(ARRAY_SIZE)]
    return array


"""
Function Name: print_array
@param array 

Inside the Function:
    1. Display a given 2D array of random integers with even spacing.    
"""
def print_array(array):
    for i in range(len(array)):
        for j in range(len(array)):
            print(str(array[i][j]) + "\t", end="")
        print()
        
        
"""
Function Name: display_results
@param sequence

Inside the Function Name:
    1. For each number and set of positions in the sequence, display them line by line.
"""
def display_results(sequence):
    for num, (x, y) in sequence:
        print(f"{num} \t({x}, {y})")
    print(f"\nThe length of the sequence is: {len(sequence)}")
    

array = generate_array()
homework_array = [
    [97, 47, 56, 36],
    [35, 57, 41, 13],
    [89, 36, 98, 75],
    [25, 45, 26, 17]
]

generated_array_longest_sequence = longest_sequence(array)
test_longest_sequence = longest_sequence(homework_array)

print("##################### LONGEST SEQUENCE PROBLEM #####################\n")
print_array(array)
print("")
display_results(generated_array_longest_sequence)
print("\n")
print("------------- Testing Algorithm on Dataset From Homework -------------\n")
print_array(homework_array)
print("")
display_results(test_longest_sequence)
