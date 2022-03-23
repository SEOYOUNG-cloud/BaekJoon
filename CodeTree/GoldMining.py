n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

def get_area(k):
    return k * k + (k+1) * (k+1)

def get_gold(row, col, k):
    gold_mining = 0
    for i in range(n):
        for j in range(n):
            if abs(i - row) + abs(j - col) <= k:
                gold_mining += grid[i][j]

    return gold_mining


max_gold = 0

for i in range(n):
    for j in range(n):
        for k in range(2 * (n-1) + 1):
            gold = get_gold(i, j, k)

            if gold * m >= get_area(k):
                max_gold = max(max_gold, gold)
print(max_gold)