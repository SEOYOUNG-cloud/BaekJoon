def solution(numbers):
    answer = []
    answer_set = set()
    
    for i in range(len(numbers)):
        for j in range(len(numbers)):
            if i == j:
                continue
            else:
                answer_set.add(numbers[i] + numbers[j])
                
    return sorted(list(answer_set))