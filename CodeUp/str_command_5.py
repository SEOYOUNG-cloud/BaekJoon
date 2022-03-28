# 정수 명령 처리 5
n = int(input())
list_dy = []

for _ in range(n):
    command = input()
    if command == 'size':
        print(len(list_dy))
    elif command == 'pop_back':
        list_dy.pop()
    elif command.startswith('push_back'):
        pb = command.split(' ')
        list_dy.append(pb[1])
    elif command.startswith('get'):
        get_k = command.split(' ')
        print(list_dy[int(get_k[1]) - 1])