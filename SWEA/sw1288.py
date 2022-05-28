for test_case in range(1, int(input()) + 1):
    n = int(input())
    count = set()
    i = 1
    while len(count) != 10:
        count.update(list(map(int, str(n * i))))
        i+=1

    print(f'#{test_case} {n * (i - 1)}')
