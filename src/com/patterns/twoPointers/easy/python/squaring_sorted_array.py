# Problem Statement:
# Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

# Input: [-2, -1, 0, 2, 3]
# Output: [0, 1, 4, 4, 9]

# Input: [-3, -1, 0, 1, 2]
# Output: [0 1 1 4 9]

def squaring_sorted_array(arr):

    left_pointer = 0
    right_pointer = len(arr) - 1
    squares_arr_pointer = len(arr) - 1
    squares = [0 for _ in arr]

    while left_pointer <= right_pointer:

        left_pointer_squared = arr[left_pointer] ** 2
        right_pointer_squared = arr[right_pointer] ** 2

        if left_pointer == right_pointer:
            squares[squares_arr_pointer] = left_pointer_squared
            break

        if right_pointer_squared > left_pointer_squared:
            squares[squares_arr_pointer] = right_pointer_squared
            squares_arr_pointer -= 1
            right_pointer -= 1

        elif left_pointer_squared == right_pointer_squared:
            squares[squares_arr_pointer] = right_pointer_squared
            squares_arr_pointer -= 1
            right_pointer -= 1
            squares[squares_arr_pointer] = left_pointer_squared
            squares_arr_pointer -= 1
            left_pointer += 1

        else:
            squares[squares_arr_pointer] = left_pointer_squared
            squares_arr_pointer -= 1
            left_pointer += 1

    return squares


print(squaring_sorted_array([-2, -1, 0, 2, 3]))
print(squaring_sorted_array([-3, -1, 0, 1, 2]))
