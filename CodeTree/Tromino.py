n,m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

def cal_3_row(col, row_f, row_l):
    max = 0
    for i in range(row_f, row_l + 1):
        max += grid[col][i]
    return max

def cal_3_col(col_f, col_l, row):
    max = 0
    for i in range(col_f, col_l + 1):
        max += grid[i][row]
    return max

def cal_2(col_f, col_l, row_f, row_l):
    all_max = 0
    for i in range(col_f, col_l + 1):
        for j in range(row_f, row_l + 1):
            all_max += grid[i][j]
    max3 = 0
    for i in range(col_f, col_l + 1):
        for j in range(row_f, row_l + 1):
            max3 = max(all_max - grid[i][j], max3)

    return max3
    

ans = 0
for i in range(n):
    for j in range(m):
        if j+2 >= m:
            continue
        ans = max(cal_3_row(i, j, j+2), ans)

for i in range(n):
    for j in range(m):
        if i+2 >= n:
            continue
        ans = max(cal_3_col(i, i+2, j), ans)

for i in range(n):
    for j in range(m):
        if i + 1 >= n or j + 1 >= m:
            continue
        ans = max(cal_2(i, i+1, j, j+1), ans)

print(ans)
