for test_case in range(1, int(input()) + 1):
    n = list(map(int, input().split()))
    answer = round(sum(n) / 10)

    print(f'#{test_case} {answer}')