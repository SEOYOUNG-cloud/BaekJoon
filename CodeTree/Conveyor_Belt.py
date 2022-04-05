# 컨베이어 벨트
n, t = map(int, input().split())
belt = [list(map(int, input().split())) for _ in range(2)]


for _ in range(t):
    temp_down = belt[0][n-1]
    for i in range(n-1, 0, -1):
        belt[0][i] = belt[0][i-1]

    temp_up = belt[1][n-1]
    for j in range(n-1, 0, -1):
        belt[1][j] = belt[1][j-1]

    belt[0][0] = temp_up
    belt[1][0] = temp_down
    
for i in range(len(belt)):
    for j in range(len(belt[0])):
        print(belt[i][j], end=' ')
    print()
    