for test_case in range(1, int(input()) + 1):
    n = input()
    month = [1,2,3,4,5,6,7,8,9,10,11,12]
    date = [31,28,31,30,31,30,31,31,30,31,30,31]

    if int(n[4:6]) <= 12 and int(n[4:6]) >= 1 and int(n[-2:]) <= date[month.index(int(n[4:6]))]:
        print(f'#{test_case} {n[:4]}/{n[4:6]}/{n[-2:]}')
    else:
        print(f'#{test_case} -1')