package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1520 { // 내리막길 DFS
	public static int M, N;
	public static int map[][];
	public static int visited[][];
	public static int dx[] = {1, -1, 0, 0};
	public static int dy[] = {0, 0, 1, -1};
	public static int count = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = -1;
			}
		}
		
		
		System.out.println(dfs(0, 0));
		
	}
	
	public static int dfs(int x, int y) {
		if(x == M-1 && y == N-1) return 1; // 제일 뒤까지 탐색했다면 +1
		if(visited[x][y] != -1) return visited[x][y]; // 이미 들렀다면(0이라면) 걍 지나가
		else {
			visited[x][y] = 0; // 방문처리
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx <= -1 || nx >= M || ny <= -1 || ny >= N) continue;
				
				if(map[nx][ny] < map[x][y]) {
					visited[x][y] += dfs(nx, ny);
				}
			}
		}
		
		return visited[x][y]; // 맨 마지막에 도달했을 때에만 +1씩 갈겨왔으므로 얘를 출력하면 된다.
	}

}
