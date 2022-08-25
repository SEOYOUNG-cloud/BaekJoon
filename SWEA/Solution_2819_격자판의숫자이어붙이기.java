package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_2819_격자판의숫자이어붙이기_박서영 {

	static int map[][];
	static Set<Integer> set;
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++) {
			map = new int[4][4];
			set = new HashSet<>();
			
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
		

			// 입력  끝 //
			for(int i=0; i<4; i++)
				for(int j=0; j<4; j++)
					dfs(i, j, 0, 0);
			
			sb.append("#").append(tc).append(" ").append(set.size()).append('\n');
		}
		System.out.println(sb);
		
		br.close();
	}
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	private static void dfs(int x, int y, int cnt, int num) {
		if(cnt == 7) {
			set.add(num);
			return;
		}
		for(int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
			dfs(nx, ny, cnt+1, num*10 + map[nx][ny]);
		}
		
	}

}
