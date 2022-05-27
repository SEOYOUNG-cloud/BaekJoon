for test_case in range(1, int(input()) + 1):
    n = int(input())
    num = [2, 3, 5, 7, 11]
    ans = [0, 0, 0, 0, 0]

    for i in range(len(ans)):
        count = 0
        while(True):
            if n % num[i] == 0:
                count += 1
                n /= num[i]
            else:
                ans[i] = count
                break

    print(f'#{test_case} {" ".join(map(str, ans))}')
