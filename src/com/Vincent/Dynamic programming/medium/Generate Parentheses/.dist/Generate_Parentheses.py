n = 3
stack = []
result = []
def BackTrack(Open_num,Close_num):
    if Open_num == Close_num == n:
        result.append("".join(stack))
        return
    if Open_num < n:
        stack.append("(")
        BackTrack(Open_num+1,Close_num)
        stack.pop()
    if Open_num > Close_num:
        stack.append(")")
        BackTrack(Open_num,Close_num+1)
        stack.pop()
BackTrack(0,0)
print(result)