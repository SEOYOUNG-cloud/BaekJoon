# 문자에 따른 명령2

x,y = 0,0
now = 3 # 북쪽에서 시작
dx, dy = [1, 0, -1, 0], [0, -1, 0 ,1]
in_dir = list(input())

for i in in_dir:
    if i == 'L':
        now = (now + 3) % 4
    elif i == 'R':
        now = (now + 1) % 4
    else:
        x, y = x + dx[now], y+dy[now]

print(x,y)