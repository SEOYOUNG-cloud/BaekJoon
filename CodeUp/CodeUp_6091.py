# 6091 최소공배수
a,b,c = map(int, input().split())
d = 1
while d % a != 0 or d % b != 0 or d % c != 0:
    d += 1
print(d)

# 6092
n = int(input())
a = list(map(int, input().split()))
d = []
for i in range(24):
    d.append(0)
for i in a:
    d[i] += 1
for i in range(1, 24):
    print(d[i], end=' ')

# 6093 리스트 역순 출력
n = int(input())
a = list(map(int, input().split()))
for i in range(n-1, -1, -1):
    print(a[i], end=' ')
    
# 6094 가장 작은 숫자 출력
n = int(input())
a = list(map(int, input().split()))
print(min(a))
