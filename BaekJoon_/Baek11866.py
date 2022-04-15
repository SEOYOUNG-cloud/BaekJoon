n,k = map(int, input().split())

people = [i for i in range(1, n + 1)]
answer = []

while len(people) != 0:
    for _ in range(k-1):
        people.append(people[0])
        people.pop(0)
        
    answer.append(people.pop(0))
    
# print('<{0}>'.format(', '.join(map(str, answer))))
print('<', end='')
print(', '.join(map(str, answer)), end='')
print('>')