for test_case in range(1, int(input()) + 1):
    answer = 0
    N = list(map(int, input().split()))
    for i in N:
        if i % 2 == 1:
            answer += i

    print(f'#{test_case} {answer}')