dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
for test_case in range(1, int(input()) + 1):
    n = int(input())
    answer = [[0] * n for _ in range(n)]
    answer[0][0] = 1

    t = 2
    x, y = 0, 0
    idx = 0
    while t <= n**2:
        nx = x + dx[idx]
        ny = y + dy[idx]
        if nx < 0 or nx >= n or ny < 0 or ny >= n or answer[nx][ny] != 0:
            idx = (idx + 1) % 4
            continue
        answer[nx][ny] = t
        x = nx
        y = ny
        t += 1

    print(f'#{test_case}')
    for i in range(n):
        for j in range(n):
            print(answer[i][j], end=' ')
        print()



