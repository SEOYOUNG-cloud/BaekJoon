
# 6071 0이 입력되면 입력 중단하기
n = int(input())
while n!= 0:
    print(n)
    n = int(input())

# 6072
n = int(input())
while n != 0:
    print(n)
    n -= 1    

# 6073
n = int(input())
while n > 0:
    print(n-1)
    n -= 1

# 6074 f 입력하면 a b c d e f
n = ord(input()) # 문자의 정수값
t = ord('a')
while t <= n:
    print(chr(t), end=' ') # 숫자의 문자값
    t += 1 

# 6075
n = int(input())
t = 0
while t <= n:
    print(t)
    t += 1

# 6076
n = int(input())
for i in range(n+1):
    print(i)

# 6077
n = int(input())
total = 0
for i in range(n+1):
    if i % 2 == 0:
        total += i
print(total)

# 6078
while True:
    n = input()
    if(n == 'q'):
        print('q')
        break
    else:
        print(n)
        continue

# 6079
n = int(input())
total = 0
for i in range(n):
    total += i
    if(total >= n):
        print(i)
        break
    else:
        continue

# 6080
n, m = map(int, input().split())
for i in range(1, n+1):
    for j in range(1, m+1):
        print(i,j)
