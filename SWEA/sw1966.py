for test_case in range(1, int(input()) + 1):
    n = int(input())
    num = list(map(int, input().split()))
    num.sort()

    print(f'#{test_case} {" ".join(map(str, num))}')