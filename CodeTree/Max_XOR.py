# xor 결과 최대 만들기

import functools

n,m = map(int, input().split())
number = list(map(int, input().split()))
number_idx = [False for _ in range(n)] # 여기가 True인 인덱스가 idx면 number[idx]가 만든 숫자

def calc():
    selected_number = [number[i] for i in range(n) if number_idx[i]]
    # number_idx 배열이 True인 인덱스가 있는 number[idx]의 숫자가 선택된 숫자..응

    # 초기값은 0이고 functools 모듈의 reduce함수를 사용하면 selected_number에 있는
    # 숫자들을 모두 lambda함수에 있는 계산 갈김
    return functools.reduce(
        lambda acc, cur : acc ^ cur,
        selected_number,
        0
    )

ans = 0

def choose(curr_idx, cnt):
    global ans

    if cnt == m:  # 자리수 다 만들어짐
        ans = max(ans, calc())
        return
    if curr_idx == n: # 인덱스가 제일 뒤 인덱스 +1에 도달함(n-1까지라서 그냥 return)
        return

    choose(curr_idx+1, cnt)

    number_idx[curr_idx] = True  # curr_idx에 있는 인덱스가 들어간 숫자 인덱스 응
    choose(curr_idx + 1, cnt + 1) # 숫자랑 인덱스에 +1씩
    number_idx[curr_idx] = False
    

    

choose(0,0)
print(ans)