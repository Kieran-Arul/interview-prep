# Leetcode Q118
# Generate Pascal's Triangle such that each row in the triangle is a list

# Example:
# Input: num_rows = 5
# Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

def dp1_generate(num_rows):
    result = list()
    for i in range(num_rows + 1):
        row = [1] * i
        for j in range(1, len(row) - 1):
            row[j] = result[i - 1][j - 1] + result[i - 1][j]

        result.append(row)

    return result[1:]


def dp2_generate(num_rows):
    result = [[1]]
    for i in range(num_rows - 1):
        new_tem_row = [0] + result[-1] + [0]
        new_row = []
        for j in range(len(result[-1]) + 1):
            new_row.append(new_tem_row[j] + new_tem_row[j + 1])
        result.append(new_row)
    return result


print(dp1_generate(5), [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]])
print(dp2_generate(5), [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]])
