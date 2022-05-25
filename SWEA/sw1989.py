for test_case in range(1, int(input()) + 1):
    n = input()
    if n == n[::-1]:
        print(f'#{test_case} 1')
    else:
        print(f'#{test_case} 0')
