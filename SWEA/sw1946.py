for test_case in range(1, int(input()) + 1):
    row = []
    answer = []
    for t in range(int(input())):
        alpha, count = input().split()

        total = int(count)
        for _ in range(int(count)):
            if len(row) >= 10:
                answer.append(row)
                row = []
                row.append(alpha)
            else:
                row.append(alpha)

    if len(row) != 0:
        answer.append(row)

    print(f'#{test_case}')
    for i in range(len(answer)):
        for j in range(len(answer[i])):
            print(answer[i][j], end='')
        print()
