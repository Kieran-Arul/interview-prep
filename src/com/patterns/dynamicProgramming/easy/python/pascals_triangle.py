# leetcode 118
# Input: numRows = 5
# Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

def DP1_generate(numRows):
    result = list()
    for i in range(numRows+1):
        row = [1] * i
        for j in range(1,len(row)-1):
            row[j] = result[i-1][j-1] + result[i-1][j]
            
        result.append(row)
        
    return result[1:]

def DP2_generate(numRows):
    result = [[1]]
    for i in range(numRows-1):
        new_tem_row = [0] + result[-1] + [0]
        new_row = []
        for j in range(len(result[-1])+1):
            new_row.append(new_tem_row[j]+new_tem_row[j+1])
        result.append(new_row)
    return result

print(DP1_generate(5),[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]])
print(DP2_generate(5),[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]])

