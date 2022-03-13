def solution(lottos, win_nums):
    rank = [6,6,5,4,3,2,1]
    total_low = 0
    
    for i in win_nums:
        if i in lottos:
            total_low += 1
            
    total_high = total_low + lottos.count(0)
    return rank[total_high], rank[total_low]