for test_case in range(1, 11):
    n = int(input())
    mapp = [list(map(int, input().split())) for _ in range(100)]
    dig1, dig2 = 0, 0
    for i in range(100):
        dig1 += mapp[i][i]

    for i in range(100):
            dig2 += mapp[i][99-i]


    max_col = 0
    max_row = 0

    for i in range(100):
        col = 0
        row = 0
        for j in range(99, -1, -1):
            col += mapp[j][i]
            row += mapp[i][j]

        max_col = max(max_col, col)
        max_row = max(max_row, row)

    print(f'#{test_case} {max(dig1, dig2, max_col, max_row)}')