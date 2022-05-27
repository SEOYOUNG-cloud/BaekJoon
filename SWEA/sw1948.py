month = [1,2,3,4,5,6,7,8,9,10,11,12]
date = [31,28,31,30,31,30,31,31,30,31,30,31]
for test_case in range(1, int(input()) + 1):
    m1,d1,m2,d2 = map(int, input().split())
    total = 0

    for m in range(m1, m2):
        total += date[month.index(m)]
    total += d2 - d1 + 1

    print(f'#{test_case} {total}')