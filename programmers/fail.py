def solution(N, stages):
    answer = {}
    people = len(stages)
    for i in range(1, N+1):
        if people != 0: # 얘를 넣어줘야 런타임에러..가 안뜨네
            total = stages.count(i)
            answer[i] = total / people
            people -= total
            
        else:
            answer[i] = 0
        
    return sorted(answer, key = lambda i: answer[i], reverse = True)