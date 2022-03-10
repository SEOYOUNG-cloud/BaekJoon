# 6096 십(+)자 뒤집기
# 2차원 배열 입력받는법 : 4번째라인
# for _ in range를 하면 인덱스 없이 만들 수 있음
d = [list(map(int, input().split())) for _ in range(19)]
n = int(input())
for i in range(n):
    x,y = map(int, input().split())
    for j in range(19):
        if d[x-1][j] == 0:
            d[x-1][j] = 1
        else:
            d[x-1][j] = 0
        if d[j][y-1] == 1:
            d[j][y-1] = 0
        else:
            d[j][y-1] = 1
for i in range(19):
    for j in range(19):
        print(d[i][j], end = ' ')
    print()
        
# 6097
h,w = map(int, input().split())
arr = [[0] * w for _ in range(h)]
n = int(input())
for i in range(n):
    l, d, x, y = map(int, input().split())
    if d == 0:
        for j in range(l):
            arr[x - 1][y - 1 + j] = 1
    else:
        for j in range(l):
            arr[x - 1 + j][y - 1] = 1
            
for i in range(h):
    for j in range(w):
        print(arr[i][j], end = ' ')
    print()

# 6098
arr = [list(map(int, input().split())) for _ in range(10)]
x,y = 1,1
while True:
    if arr[x][y] == 0:
        arr[x][y] = 9
    elif arr[x][y] == 2:
        arr[x][y] = 9
        break
    if arr[x][y + 1] == 1 and arr[x + 1][y] == 1:
        break
    if arr[x][y + 1] != 1:  # 오른쪽 갈 수 있으면 y+1
        y = y + 1
    elif arr[x + 1][y] != 1: # 오른쪽 못가고 아래 갈 수 있으면 x + 1
        x = x + 1        
for i in range(10):
    for j in range(10):
        print(arr[i][j], end = ' ')
    print()

    
    

    
    