for test_case in range(1, int(input())+ 1):
    n = int(input())
    answer = 0
    for odd in range(1, n + 1, 2):
        answer += odd
    for even in range(0, n + 1, 2):
        answer -= even
    print(f'#{test_case} {answer}')