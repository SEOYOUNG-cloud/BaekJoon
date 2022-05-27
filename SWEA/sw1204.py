for test_case in range(1, int(input()) + 1):
    N = int(input())
    N_list = list(map(int, input().split()))
    N_set = list(set(N_list))
    N_set.sort()

    max_idx = 0
    max_ans = 0
    for i in N_set:
        if max_idx <= N_list.count(i):
            max_idx = N_list.count(i)
            max_ans = i

    print(f'#{test_case} {max_ans}')
