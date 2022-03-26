n,m = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]

for i in range(m):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)

def dfs(n):
    global answer
    for i in graph[n]:
        if not visited[i]:
            answer += 1
            visited[i] = True
            dfs(i)
answer = 0
visited[1] = True
dfs(1)
print(answer)
            