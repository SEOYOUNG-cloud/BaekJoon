#프로그래머스 _ 시저 코드 for Python

'''
list() = 리스트에 하나씩 넣음
ord(문자) = 유니코드 정수 반환 , ord('a') = 97
chr(숫자) = 정수 유니코드 반환, chr(97) = 'a'
len(문자) = 문자열 길이
join(리스트) = , ex) ['a', 'b', 'c'] -> 'abc'로 합침 
'''

def solution(s, n):
    s = list(s)
    for i in range(len(s)):
        if s[i].isupper():
            s[i] = chr((ord(s[i]) - ord('A') + n) % 26 + ord('A'))
        elif s[i].islower():
            s[i] = chr((ord(s[i]) - ord('a') + n) % 26 + ord('a'))
    
    return "".join(s) # 문자열 합치기