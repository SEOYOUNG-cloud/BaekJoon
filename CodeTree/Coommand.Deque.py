from collections import deque
dq = deque()

n = int(input())

for _ in range(n):
    command = input()
    if command.startswith('push_back'):
        dq.append(int(command.split()[1]))
    elif command.startswith('push_front'):
        dq.appendleft(int(command.split()[1]))
    elif command.startswith('pop_front'):
        print(dq.popleft())
    elif command.startswith('pop_back'):
        print(dq.pop())
    elif command == 'size':
        print(len(dq))
    elif command == 'empty':
        if dq:
            print('0')
        else:
            print('1')
    elif command == 'front':
        print(dq[0])
    elif command == 'back':
        print(dq[-1])