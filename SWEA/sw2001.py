for test_case in range(1, int(input()) + 1):
    n, m = map(int, input().split())
    bug_list = [list(map(int, input().split())) for _ in range(n)]

    max_total=0
    for x in range(n-m+1):
        for y in range(n-m+1):
            total = 0
            for i in range(x, x + m ):
                for j in range(y, y + m):
                    total += bug_list[i][j]

            if max_total < total:
                max_total = total

    print(f'#{test_case} {max_total}')