n,m = map(int, input().split())
dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
visited = [[0] * m for _ in range(n)]
x,y = 0,0
now = 0

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < m

visited[x][y] = 1

for i in range(2, n * m + 1):
    nx, ny = x + dx[now], y + dy[now]
    if not in_range(nx, ny) or visited[nx][ny] != 0:
        now = (now + 1) % 4
    
    x, y = x + dx[now], y + dy[now]
    visited[x][y] = i

for i in range(n):
    for j in range(m):
        print(visited[i][j], end = ' ')
    print()

'''
출력할 때

for i in visited:
    print(' '.join(map(str, i)))
    
이렇게 해도 된다!
'''   
