# 6081 16진수 구구단
n = int(input(), 16) # 16진수로 받아서 10진수로 저장
for i in range(1, 16):
    print('{0}*{1}={2}'.format('%X' %n, '%X' %i, '%X' %(n * i)))

# 6082 3 6 9 인데 29까지만
n = int(input())
for i in range(1, n+1):
    if i % 10 == 3:
        print('X',end=' ')
    elif i % 10 == 6:
        print('X',end=' ')
    elif i % 10 == 9:
        print('X',end=' ')
    else:
        print(i, end=' ')
        
# 6083
r,g,b = map(int, input().split())
total = 0
for i in range(0, r):
    for j in range(0, g):
        for k in range(0, b):
            print(i,j,k)
            total += 1
print(total)

# 6084
h, b, c, s = map(int, input().split())
print('{:.1f} MB'.format(h * b * c * (s / 8 / 1024 / 1024)))

# 6085
w, h, b = map(int, input().split())
print('{:.2f} MB'.format(w * h * (b / 8 / 1024 / 1024)))


