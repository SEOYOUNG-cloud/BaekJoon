n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]
dxs, dys = [0, 1, 0, -1], [1, 0, -1, 0]

def is_range(x,y):
    return 0 <= x and x < n and 0 <= y and y < n

answer = 0
for i in range(n):
    for j in range(n):
        count = 0
        for dx, dy in zip(dxs, dys):
            nx, ny = i + dx, j + dy
            if is_range(nx, ny) and grid[nx][ny] == 1:
                count += 1

        if count >= 3:
            answer += 1
print(answer)
