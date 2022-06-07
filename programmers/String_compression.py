s = "aabbaccc"
answer = len(s)

for n in range(1, len(s)//2 + 2): # 자르는 문자열 범위(최대가 절반까지), len(s) = 1일수도 있으니까 +2까지
    cnt = 1
    tmp = s[:n] # 비교할 문자
    res = ''
    
    for i in range(n, len(s) + n, n): 
        # len(s) + n을 함으로써 문자열 길이만큼 돌린 후
        # 마지막으로 한번 더 돌려서 else에 걸리게해 res에 넣어주고 끝냄
        if tmp == s[i:i+n]:
            cnt += 1
        else:
            if cnt == 1:
                res += tmp
            else:
                res += str(cnt) + tmp
            
            tmp = s[i:i+n]
            cnt = 1
        
    answer = min(answer, len(res))
print(answer)