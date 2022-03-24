n = int(input())

def beautiful(num):
    stack = []
    count = 0
    global answer
    for i in num:
        if i == 1:
            answer += 1
            continue
        elif not stack: # 리스트가 비었으면
            stack.append(i)
            count = 1
        else:
            if stack[-1] == i: # 다음 들어오는거랑 같으면
                count += 1
                stack.append(i)
                if count == i:
                    count = 0
            elif count != 0:
                return False

        if count == 0:
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
