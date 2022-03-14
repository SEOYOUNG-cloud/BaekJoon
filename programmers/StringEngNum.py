def solution(s):
    eng = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    
    for i in range(10):
        if eng[i] in s:
            s = s.replace(eng[i], str(i))
            
    return int(s)