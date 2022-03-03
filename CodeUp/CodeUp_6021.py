# 6021
s = input()
for i in range(0,len(s)):
    print(s[i])

# 6022
s = input()
print(s[0:2],s[2:4],s[4:])

# 6023
s = input()
a = s.split(":")
print(a[1])

# 6024
w1, w2 = input().split(" ")
s = w1 + w2
print(s)

# 6025
a, b = input().split(" ")
print(int(a) + int(b))

# 6026
a = input()
b = input()
print(float(a) + float(b))

# 6027 _ 10진수 -> 16진수
a = input()
n = int(a) # 10진수로 바꿈
print('%x' %n) # %x -> 16진수, %o -> 8진수

# 6028
a = input()
n = int(a)
print('%X' %n)

# 6029 _ 16진수 -> 8진수
a = input()
n = int(a, 16)  # a를 16진수로 저장
print('%o' %n)

# 6030 _ 영문자 -> 10진수 유니코드 값
n = ord(input())
print(n)
