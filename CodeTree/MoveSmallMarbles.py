dx, dy = [0, 1, -1, 0], [1, 0, 0, -1]
mapper = {
    'R' : 0,
    'D' : 1,
    'U' : 2,
    'L' : 3
}

n, t = map(int, input().split())
r, c, d = input().split()

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

x,y = int(r) - 1, int(c) - 1
now = mapper[d]

while t > 0:
    nx, ny = x + dx[now], y + dy[now]
    if not in_range(nx, ny):
        now = 3 - now
    else:
        x, y = nx, ny
    t -= 1
print(x + 1, y + 1)