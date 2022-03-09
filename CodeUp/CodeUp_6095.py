# 6095
n = int(input())
d = [[0 for j in range(20)] for i in range(20)] # 19 x 19 바둑판 만들기

while n > 0:
    i, j = map(int, input().split())
    d[i - 1][j - 1] = 1
    n -= 1
    
for i in range(0, 19):
    for j in range(0, 19):
        print(d[i][j], end = ' ')
    print()
