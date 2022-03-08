# 6086
total = 0
n = int(input())
c = 1
while True:
    total += c
    c += 1
    if n <= total:
        break
print(total)

# 6087
n = int(input())
for i in range(1, n+1):
    if i % 3 == 0:
        continue
    else:
        print(i, end=' ')

# 6088 등차수열
a,d,n = map(int, input().split())
print(a + (n - 1) * d)

# 6089 등비수열 
a,r,n = map(int, input().split())
print(a*r**(n-1))

# 6090
start, mix, add, ans = map(int, input().split())

def fibo_6(a,m,d,n):
    if n==1:
        return a
    else:
        return fibo_6(a,m,d,n-1) * m + d

print(fibo_6(start, mix, add, ans))