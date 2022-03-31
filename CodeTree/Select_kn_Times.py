# 특정 조건에 맞게 k개 중에 1개를 n번 뽑기

k,n = map(int, input().split())
answer = []

def print_answer():
    for ans in answer:
        print(ans, end=' ')
    print()

def choose(curr_num):
    if curr_num == n+1:
        print_answer()
        return

    for i in range(1, k+1):
        if curr_num >= 3 and i == answer[-1] and i == answer[-2]:
            continue
        answer.append(i)
        choose(curr_num + 1)
        answer.pop()

choose(1)