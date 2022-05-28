# import base64
# for test_case in range(1, int(input()) + 1):
#     print(f'#{test_case} {base64.b64decode(input()).decode("UTF-8")}')

def change_2(inn): # 10진수 -> 6자리수 2진수
    a = inn
    b = []
    while a != 1:
        b.append(a % 2)
        a //= 2

    b.append(1)

    while len(b) != 6:
        b.append(0)
    return b[::-1]

def change_10(ch10): # 8자리수 2진수 -> 10진수
    ans = 0
    for i in range(8):
        if ch10[i] == 1:
            ans += 2**(7-i)
    return ans

graph_chr = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
             'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
             'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1',
             '2', '3', '4', '5', '6', '7', '8', '9', '+', '/']

for test_case in range(1, int(input()) + 1):
    n = list(input())
    temp = ''
    ans = ''
    for i in range(len(n)):
        temp += ''.join(map(str, change_2(graph_chr.index(n[i]))))

    temp = list(map(int, temp))

    for i in range((len(n) * 6) // 8):
        ans += chr(change_10(temp[8 * i : 8 * (i+1)]))

    print(f'#{test_case} {ans}')
