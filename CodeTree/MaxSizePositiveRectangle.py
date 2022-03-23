n,m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

def sq_check(x1, y1, x2, y2):
    for i in range(x1, x2 + 1):
        for j in range(y1, y2 + 1):
            if grid[i][j] <= 0:
                return False
    return True

ans = 0
for x in range(n):
    for y in range(m):
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                dx, dy = x + (i-1), y + (j-1)
                if dx >= n or dx < 0 or dy >= m or dy < 0:
                    continue
                if sq_check(x, y, dx, dy):
                    ans = max(ans, (abs(x - dx) + 1) * (abs(y - dy) + 1))
if ans == 0:
    print('-1')
else:
    print(ans)
