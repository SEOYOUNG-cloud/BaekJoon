n = int(input())
bulk = [list(map(int, input().split())) for _ in range(n)]
answer = []
for bulk_ in bulk:
    count = 0
    for compare in bulk:
        if bulk_[0] < compare[0] and bulk_[1] < compare[1]:
            count += 1
    answer.append(count + 1)
    
print(' '.join(map(str, answer)))