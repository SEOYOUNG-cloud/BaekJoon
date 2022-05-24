for test_case in range(1, int(input()) + 1):
    n = list(input())
    for i in range(1, len(n) + 1):
        if n[0] == n[i] and ''.join(n[:i]) == ''.join(n[i:i+i]):
            print(f'#{test_case} {i}')
            break
        else:
            continue
