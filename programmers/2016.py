def solution(a, b):
    month = ['THU','FRI','SAT','SUN','MON','TUE','WED']
    day = [31,29,31,30,31,30,31,31,30,31,30,31]
    total = 0
    
    for i in range(a - 1):
        total += day[i]
    total += b
    return month[total % 7]