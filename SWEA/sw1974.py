for test_case in range(1, int(input()) + 1):
    puzzle = [list(map(int, input().split())) for _ in range(9)]
    answer = 1
    for i in range(9):
        row_valid = [0] * 9
        col_valid = [0] * 9

        for j in range(9):
            if row_valid[puzzle[i][j] - 1] == 1:
                answer = 0
                break
            if col_valid[puzzle[j][i] - 1] == 1:
                answer = 0
                break
            if row_valid[puzzle[i][j] - 1] == 0:
                row_valid[puzzle[i][j] - 1] = 1
            if col_valid[puzzle[j][i] - 1] == 0:
                col_valid[puzzle[j][i] - 1] = 1

        # 3 x 3
            if i % 3 == 0 and j % 3 == 0:
                sq_valid = [0] * 9
                for x in range(i, i+3):
                    for y in range(j, j+3):
                        if sq_valid[puzzle[x][y] - 1] == 1:
                            answer = 0
                            break
                        else:
                            sq_valid[puzzle[x][y] - 1] = 1

    print(f'#{test_case} {answer}')


