for test_case in range(1, int(input()) + 1):
    h1, m1, h2, m2 = map(int, input().split())
    h, m = 0, 0
    m = m1 + m2
    if m > 60:
        m -= 60
        h += 1

    h += (h1 + h2)
    if h > 12:
        h -= 12

    print(f'#{test_case} {h} {m}')