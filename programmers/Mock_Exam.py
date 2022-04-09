# 모의고사
def solution(answers):
    
    answer = []
    math1 = [1, 2, 3, 4, 5]
    math2 = [2, 1, 2, 3, 2, 4, 2, 5]
    math3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    m1 = 0
    m2 = 0
    m3 = 0
    
    for i in range(len(answers)):
        if math1[i % 5] == answers[i]:
            m1 += 1
        if math2[i % 8] == answers[i]:
            m2 += 1
        if math3[i % 10] == answers[i]:
            m3 += 1
    
    ans_max = max(m1,m2,m3)
    if ans_max == m1:
        answer.append(1)
    if ans_max == m2:
        answer.append(2)
    if ans_max == m3:
        answer.append(3)
        
    return answer