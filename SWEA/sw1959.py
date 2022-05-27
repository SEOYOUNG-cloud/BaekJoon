def check(A, B):
    total_max = -9999999999
    for i in range(len(A) - len(B) + 1):
        total = 0
        for j in range(len(B)):
            total += A[i+j] * B[j]
        if total_max < total:
            total_max = total
    return total_max


for test_case in range(1, int(input()) + 1):
    n, m = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    if n > m: # A가 긴애
        answer = check(A, B)
    else:
        answer = check(B, A)

    print(f'#{test_case} {answer}')
