for test_case in range(1, 11):
    n = int(input())
    building = list(map(int, input().split()))

    answer = 0
    for i in range(2, n-2):
        for j in range(1, building[i] + 1):
            if building[i-2] < j and building[i-1] < j and building[i+1] < j and building[i+2] < j:
                answer += 1

    print(f'#{test_case} {answer}')