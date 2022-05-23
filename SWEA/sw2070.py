for test_case in range(1, int(input()) + 1):
    a, b = map(int, input().split())
    if a < b:
        print(f'#{test_case}', '<')
    elif a == b:
        print(f'#{test_case} =')
    else:
        print(f'#{test_case} >')
