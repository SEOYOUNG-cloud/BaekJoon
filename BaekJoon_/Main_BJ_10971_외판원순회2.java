package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10971_외판원순회2_박서영 {

	static int map[][];
	static boolean visited[];
	static int N;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//입력끝///
		for(int i=1; i<=N; i++) {
			visited[i] = true;
			dfs(i, i ,1 , 0);
			visited[i] = false;
		}
		System.out.println(answer);

	}
	private static void dfs(int start, int num, int cnt, int money) {
		if(cnt == N) {
			if(map[num][start] == 0) return;
			money += map[num][start];
			answer = Math.min(answer, money);
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(visited[i] || map[num][i] == 0) continue;
			if(money + map[num][i] > answer) continue;
			
			visited[i] = true;
			dfs(start, i, cnt+1, money + map[num][i]);
			visited[i] = false;
		}
	}

}
