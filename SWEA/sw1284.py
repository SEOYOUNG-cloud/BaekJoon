for test_case in range(1, int(input()) + 1):
    P, Q, R, S, W = map(int, input().split())
    A, B = 0, 0
    A = P * W
    if W <= R:
        B = Q
    else:
        B = Q + (W-R) * S

    if A > B:
        print(f'#{test_case} {B}')
    else:
        print(f'#{test_case} {A}')