# From Grokking the Coding Interview

# Problem Statement:
# Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

# Input: [-2, -1, 0, 2, 3]
# Output: [0, 1, 4, 4, 9]

# Input: [-3, -1, 0, 1, 2]
# Output: [0 1 1 4 9]

def squaring_sorted_array(arr):

    # Pointer to first element in arr
    left_pointer = 0

    # Pointer to last element in arr
    right_pointer = len(arr) - 1

    # Pointer to last element in squares array
    squares_arr_pointer = len(arr) - 1
    squares = [0 for _ in arr]

    # We also need to deal with the case when leftPointer == rightPointer because
    # otherwise we will forget about the final element in the original array
    while left_pointer <= right_pointer:

        # Get the square of each pair
        left_pointer_squared = arr[left_pointer] ** 2
        right_pointer_squared = arr[right_pointer] ** 2

        # If we are on the last element that has not been dealt with yet
        if left_pointer == right_pointer:
            squares[squares_arr_pointer] = left_pointer_squared
            break

        # If the right element is greater than the left, add the right element squared to the new array
        # Decrement the squareArrPointer because we know that since the array is sorted, nothing can be bigger
        # than what just added
        if right_pointer_squared > left_pointer_squared:
            squares[squares_arr_pointer] = right_pointer_squared
            squares_arr_pointer -= 1
            right_pointer -= 1

        # If the two numbers are equal, we need to add both of them squared to the new array
        # First we add the right element, then we need to decrement the pointer in the new array so we are at
        # the correct position to add the left element
        # We then need to change both pointers in the original array because we have dealt with both those numbers
        # at the same time
        elif left_pointer_squared == right_pointer_squared:
            squares[squares_arr_pointer] = right_pointer_squared
            squares_arr_pointer -= 1
            right_pointer -= 1
            squares[squares_arr_pointer] = left_pointer_squared
            squares_arr_pointer -= 1
            left_pointer += 1

        # If the left element is greater than the right, add the left element squared to the new array
        # Decrement the squareArrPointer because we know that since the array is sorted, nothing can be bigger
        # than what just added
        else:
            squares[squares_arr_pointer] = left_pointer_squared
            squares_arr_pointer -= 1
            left_pointer += 1

    return squares


print(squaring_sorted_array([-2, -1, 0, 2, 3]))
print(squaring_sorted_array([-3, -1, 0, 1, 2]))
