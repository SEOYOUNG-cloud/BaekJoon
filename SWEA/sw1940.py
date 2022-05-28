for test_case in range(1, int(input()) + 1):
    n = int(input())
    now_speed = 0
    answer = 0

    for _ in range(n):
        cmd = list(map(int, input().split()))
        if cmd[0] == 0:
            answer += now_speed
        elif cmd[0] == 1:
            now_speed += cmd[1]
            answer += now_speed
        elif cmd[0] == 2:
            if now_speed - cmd[1] < 0:
                continue
            now_speed -= cmd[1]
            answer += now_speed

    print(f'#{test_case} {answer}')