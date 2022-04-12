T = int(input())

for _ in range(T):
    input_1 = list(map(int, input().split()))
    input_1 = sorted(input_1, reverse=True)
    
    print(input_1[2])
    
    