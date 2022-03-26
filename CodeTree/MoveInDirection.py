n = int(input())

dir = ['N', 'S', 'E', 'W']
dx = [0,0,1,-1]
dy = [1,-1,0,0]
x,y = 0,0

for i in range(n):
    in_dir, in_how_much = input().split()
    x = x + dx[dir.index(in_dir)] * int(in_how_much)
    y = y + dy[dir.index(in_dir)] * int(in_how_much)

print(x,y)
