# 완주하지 못한 선수

# 효율성 떨어짐
def solution(participant, completion):
    for i in completion:
        participant.remove(i);
    return ''.join(participant)

# O
def solution(participant, completion):
    no_dict = dict()
    
    for i in participant:
        if i not in no_dict:
            no_dict[i] = 1
        else:
            no_dict[i] += 1
            
    for i in completion:
        if i in no_dict:
            no_dict[i] -= 1
    
    
    return ''.join(x for x in no_dict if no_dict[x] > 0)
