def solution(numbers, hand):
    answer = ''
    num = [[3,1], [0,0], [0,1], [0,2], [1,0], [1,1], [1,2], [2,0], [2,1], [2,2]]
    R = [3,2]
    L = [3,0]
        
    for i in numbers:
        if i in [1,4,7]:
            answer += 'L'
            L = num[i]
        elif i in [3,6,9]:
            answer += 'R'
            R = num[i]
        else:
            midL = abs(num[i][0] - L[0]) + abs(num[i][1] - L[1])
            midR = abs(num[i][0] - R[0]) + abs(num[i][1] - R[1])
            if midL < midR:
                answer += 'L'
                L = num[i]
            elif midL > midR:
                answer += 'R'
                R = num[i]
            else:
                if hand == 'right':
                    answer += 'R'
                    R = num[i]
                else:
                    answer += 'L'
                    L = num[i]
                
    return (''.join(answer))