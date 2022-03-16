def solution(a, b):
    answer = 0
    for i in range(len(a)):
        answer += a[i] * b[i]

    return answer

# 아름다운 코드..1
def solution(a, b):

    return sum([x*y for x, y in zip(a,b)])
# lamda 함수를 잘 활용하자. 그리고 zip()도 2가지 리스트를 써야할 때 좋을듯.

# 아름다운 코드..2 ㄹㅇ 한줄 람다함수!!
solution = lambda x, y: sum(a*b for a, b in zip(x, y))