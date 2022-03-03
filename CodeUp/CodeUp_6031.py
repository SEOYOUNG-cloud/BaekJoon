# 6031 _ 10진수 -> 유니코드 문자로 출력 : chr(), 반대는 ord()
a = int(input())
print(chr(a))

# 6032 _ 부호 바꾸기
a = int(input())
print(-a)

# 6033 _ 다음 문자 출력하기 _ 10진수로 바꿔서 유니코드로 변경
a = ord(input())
print(chr(a+1))

# 6034
a, b = input().split(" ")
c = int(a) - int(b)
print(c)

# 6035
a, b = input().split(' ')
c = float(a) * float(b)
print(c)

# 6036
w, n = input().split(' ')
print(w * int(n))

# 6037
n = input()
w = input()
print(w * int(n))

# 6038
a,b = input().split(' ')
print(int(a) ** int(b))

# 6039
a,b = input().split(' ')
print(float(a) ** float(b))

# 6040
a,b = input().split(' ')
print(int(a) // int(b))
