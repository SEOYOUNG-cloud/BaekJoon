# 1차원 윷놀이

n,m,k = map(int, input().split())
go = list(map(int, input().split()))
chesses = [1 for _ in range(k)] # k 는 말의 수, 1은 지금 위치임

ans = 0

def calc():
    score = 0
    for chess in chesses:
        score += (chess >= m) # chess >= m이 True이면 +1 되는거임
    return score

def find_max(curr_num):
    global ans
    ans = max(ans, calc())  # 말을 안움직여도 최대가 될 수 있으므로 항상 갱신

    if curr_num == n:
        return

    for i in range(k):
        if chesses[i] >= m:
            continue
        
        chesses[i] += go[curr_num]
        find_max(curr_num + 1)
        chesses[i] -= go[curr_num]


find_max(0)
print(ans)