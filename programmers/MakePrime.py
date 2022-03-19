from itertools import combinations
import math

def is_prime_number(x):
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False # 소수x
    return True  # 소수O

arr = [1,2,7,6,4]
answer=0
for i in combinations(arr, 3):
    if is_prime_number(sum(i)):
        answer+=1


print(answer)   