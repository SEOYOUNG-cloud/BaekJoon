money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
for test_case in range(1, int(input()) + 1):
    answer = []
    n = int(input())

    for i in range(8):
        need = n // money[i]
        n -= money[i] * need
        answer.append(need)

    print(f'#{test_case}')
    print(f'{" ".join(map(str, answer))}')