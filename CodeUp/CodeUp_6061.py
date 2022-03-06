# 6061 비트 연산자 or
a,b = map(int, input().split())
print(a | b)

# 6062 비트 연산자 xor
a,b = map(int, input().split())
print(a ^ b)

# 6063 더 큰 수 출력하기
a,b = map(int, input().split())
print(a if (a>=b) else b)

# 6064 a,b,c중 가장 작은 값 출력
a,b,c = map(int, input().split())
print(min(a,b,c))
# 또는
print((a if a < b else b) if ((a if a < b else b) < c) else c)

# 6065
a,b,c = map(int, input().split())
if a % 2 == 0:
    print(a)
if b % 2 == 0:
    print(b)
if c % 2 == 0:
    print(c)

# 6066
a,b,c = map(int, input().split())
if a % 2 == 0:
    print("even")
else:
    print("odd")
if b % 2 == 0:
    print("even")
else:
    print("odd")
if c % 2 == 0:
    print("even")
else:
    print("odd")

# 6067
a = int(input())
if a < 0:
    if a % 2 == 0:
        print('A')
    else:
        print('B')
else:
    if a % 2 == 0:
        print('C')
    else:
        print('D')

# 6068
n = int(input())
if n >= 90:
    print('A')
elif n >= 70:
    print('B')
elif n >= 40:
    print('C')
else:
    print('D')

# 6069
n = input()
if n == 'A':
    print('best!!!')
elif n == 'B':
    print('good!!')
elif n == 'C':
    print('run!')
elif n == 'D':
    print('slowly~')
else:
    print('what?')

# 6070
n = int(input())
if n // 3 == 1:
    print('spring')
elif n // 3 == 2:
    print('summer')
elif n // 3 == 3:
    print('fall')
else:
    print('winter')