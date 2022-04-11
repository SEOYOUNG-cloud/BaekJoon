def solution(nums):
    pone = []
    
    pone.append(nums[0])
    for i in nums:
        if i not in pone:
            pone.append(i)
        if len(pone) >= len(nums)//2:
            break
            
    return len(pone)