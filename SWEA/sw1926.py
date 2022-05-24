for i in range(1, int(input()) + 1):
    ans = ''
    num = list(map(str, str(i)))
    for j in range(len(num)):
        if num[j] == '3' or num[j] == '6' or num[j] == '9':
            ans += '-'
    if ans == '':
        print(i, end=' ')
    else:
        print(ans, end=' ')

