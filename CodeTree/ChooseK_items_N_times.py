k,n = map(int, input().split())

answer = []

def ans_print():
    for pt in answer:
        print(pt, end=' ')
    print()

def rec(curr_num):
    if curr_num == n+1:
        ans_print()
        return

    for i in range(1, k+1):
        answer.append(i)
        rec(curr_num + 1)
        answer.pop()
    return

rec(1)