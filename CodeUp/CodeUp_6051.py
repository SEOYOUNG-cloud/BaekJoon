# 6051
a,b = map(int, input().split())
print(a != b)

# 6052
n = int(input())
print(bool(n))

# 6053 정수로 입력받은 bool 값 반대로 출력하기
# 0만 False, 나머지는 true 이다.
a = bool(int(input()))
print(not a)

# 6054 모두 true일 때만 true 출력
a, b = map(int, input().split())
print(bool(a) and bool(b))

# 6055 하나라도 t면 T
a, b = map(int, input().split())
print(bool(a) or bool(b))

# 6056 xor : 다를때만 t
a,b = map(int, input().split())
a = bool(a)
b = bool(b)
print((a and (not b) or ((not a) and b)))

# 6057 다를 때만 f
a,b = map(int, input().split())
a = bool(a)
b = bool(b)
print(not (a and (not b) or ((not a) and b)))

# 6058 f f 일때만 T
a,b = map(int, input().split())
a = bool(a)
b = bool(b)
print(not (a or b))

# 6059
a = int(input())
print(~a)

# 6060
a,b = map(int, input().split())
print(a & b)
