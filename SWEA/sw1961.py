for test_case in range(1, int(input()) + 1):
    n = int(input())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    answer = []
    add_list = []
    for i in range(n):
        temp = ''
        for j in range(n-1, -1, -1):
            temp += str(matrix[j][i])
        add_list.append(temp)
    answer.append(add_list)

    add_list = []
    for i in range(n-1, -1, -1):
        temp = ''
        for j in range(n-1, -1, -1):
            temp += str(matrix[i][j])
        add_list.append(temp)
    answer.append(add_list)

    add_list = []
    for i in range(n - 1, -1, -1):
        temp = ''
        for j in range(n):
            temp += str(matrix[j][i])
        add_list.append(temp)
    answer.append(add_list)

    print(f'#{test_case}')
    for i in range(n):
        for j in range(3):
            print(answer[j][i], end=' ')
        print()
