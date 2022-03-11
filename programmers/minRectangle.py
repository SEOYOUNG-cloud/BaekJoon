def solution(sizes):
    answer = 0
    answer = max(max(x) for x in sizes) * max(min(x) for x in sizes)
    # max(x) for x in sizes 하면 각 사이즈[0],[1] 등에서 큰값만 뽑아냄, min도 마찬가지
    # 큰것만 뽑아낸거에서 큰거, 작은것만 뽑아낸거에서 작은거
    return answer

def solution(sizes):
    w = 0
    h = 0
    
    for i in range(len(sizes)):
        sizes[i].sort()
        w = max(w, sizes[i][0])
        h = max(h, sizes[i][1])
        
    return w * h
