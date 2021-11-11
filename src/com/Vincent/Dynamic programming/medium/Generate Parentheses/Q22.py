
# Input: n = 3
# Output: ["((()))","(()())","(())()","()(())","()()()"]

# general idea: 1: first come out is (
#               2: ( always more than )
def generateParenthesis(n):
    stack = []
    result = []
    def BackTrack(Open_num,Close_num):
        # if got the target, stop and put the stack in the result
        if Open_num == Close_num == n:
            # good to single list into whole list: for example
            # ['(',')] => ['()']
            result.append("".join(stack)) 
            # return but not end
            return
        # if ( smaller than the half, then add it, finish this whole procedure
        if Open_num < n:
            stack.append("(")
            BackTrack(Open_num+1,Close_num)
            # after did it, then delete it
            stack.pop()
        # if open is bigger than close, then append close
        if Open_num > Close_num:
            stack.append(")")
            # same as last step
            BackTrack(Open_num,Close_num+1)
            stack.pop()
        # notice this is not like normal recursion we use before, it is more like BFS search
    BackTrack(0,0)
    return result
