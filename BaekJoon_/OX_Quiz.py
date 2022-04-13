T = int(input())
for _ in range(T):
    input_ = list(input())
    answer = 0
    index = 1
    O_list = []
    for i in input_:
        stack = []
        stack.append(i)
        if(stack[-1] == 'O'):
            answer += index
            index += 1
        else:
            index = 1
            
    print(answer)