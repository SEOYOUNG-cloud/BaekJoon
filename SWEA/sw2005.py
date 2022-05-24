for test_case in range(1, int(input()) + 1):
    n = int(input())
    result = []
    for i in range(n):
        temp = []
        for j in range(i + 1):
            if j == 0 or j == i:
                temp.append(1)
            else:
                temp.append(result[i-1][j-1] + result[i-1][j])
        result.append(temp)
    print(f'#{test_case}')
    for i in result:
        for j in i:
            print(j, end=' ')
        print()
        