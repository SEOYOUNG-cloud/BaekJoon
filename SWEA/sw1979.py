import copy
for test_case in range(1, int(input()) + 1):
    n, k = map(int, input().split())
    puzzle = [list(map(int, input().split())) for _ in range(n)]
    puzzle_width = copy.deepcopy(puzzle)
    puzzle_height = copy.deepcopy(puzzle)
    answer = 0

    # 가로
    for x in range(n):
        count = 0
        for y in range(n):
            if puzzle_width[x][y] == 1:
                count += 1
                puzzle_width[x][y] = 0
            elif puzzle_width[x][y] == 0 and count == k:
                answer += 1
                count = 0
            else: count = 0
        if count == k:
            answer += 1

    # 세로
    for y in range(n):
        count = 0
        for x in range(n):
            if puzzle_height[x][y] == 1:
                count += 1
                puzzle_height[x][y] = 0
            elif puzzle_height[x][y] == 0 and count == k:
                answer += 1
                count = 0
            else: count = 0
        if count == k:
            answer += 1

    print(f'#{test_case} {answer}')

