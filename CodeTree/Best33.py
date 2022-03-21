n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)] # 격자 입력받기

def cal_num(row_f, row_l, col_f, col_l):
    cal_max = 0
    for i in range(row_f, row_l + 1):
        for j in range(col_f, col_l + 1):
            cal_max += grid[i][j]
    return cal_max

ans_max = 0

for i in range(n):
    for j in range(n):
        if i + 2 >= n or j + 2 >= n:
            continue
                
        ans_max = max(ans_max, cal_num(i, i+2, j, j+2))
        
print(ans_max)