score = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']

for test_case in range(1, int(input()) + 1):
    n, k = map(int, input().split())
    students = []
    for i in range(1, n+1):
        student = list(map(int, input().split()))
        students.append(round(student[0] * 0.35 + student[1] * 0.45 + student[2] * 0.20, 2))

    K_score = students[k - 1]

    students.sort(reverse=True)
    for i in range(n):
        if students[i] == K_score:
            K_idx = students.index(K_score)

    print(f'#{test_case} {score[K_idx // (n//10)]}')



