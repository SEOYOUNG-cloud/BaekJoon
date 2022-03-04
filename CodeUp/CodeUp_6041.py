# 6041
a,b = input().split()
print(int(a) % int(b))

# 6042
a = float(input())
print(format(a, ".2f"))

# 6043
f1, f2 = input().split()
print(format(float(f1) / float(f2), ".3f"))

# 6044 int화 하는거 a,b = map(int, input().split()) 으로 받아도 됨
a,b = input().split()
a = int(a)
b = int(b)
print(a+b)
print(a-b)
print(a*b)
print(a//b)
print(a%b)
print(format(a/b, ".2f"))

# 6045
a,b,c = input().split()
a = int(a)
b = int(b)
c = int(c)
total = a+b+c
print(total, format(total/3, ".2f"))

# 6046 2배
a = int(input())
print(a<<1)

# 6047 a * 2^b
a,b = map(int, input().split())
print(a<<b)

# 6048
a,b = map(int, input().split())
print(a<b)

# 6049
a,b = map(int, input().split())
print(a==b)

# 6050
a,b = map(int, input().split())
print(a <= b)
