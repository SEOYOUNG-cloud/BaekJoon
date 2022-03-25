n = int(input())

def beautiful(num):
    stack = []
    count = 0
    for i in num:
        if not stack: # 리스트가 비었으면
            stack.append(i)
            count = 1
        else:
            if stack[-1] == i and i != 1: # 다음 들어오는거랑 같으면
                if count == stack[-1]:
                    count = 1
                else:
                    count += 1
                stack.append(i)
            else:
                if count != stack[-1]:
                    return False
                count = 1
                stack.append(i)

    if count == stack[-1]:
        return True
    else:
        return False

number = []
answer = 0
def rec(curr_num):
    global answer
    if curr_num == n + 1:
        if beautiful(number):  
            answer += 1
        return
    
    for i in range(1, 5):
        number.append(i)
        rec(curr_num + 1)
        number.pop()
    return

rec(1)
print(answer)