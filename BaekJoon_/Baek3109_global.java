package Baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek3109_global {

	static int R, C;
	static char map[][];
	static int answer = 0;
	static int dx[] = {-1,0,1};
	static int dy[] = {1,1,1};
	static boolean bol = false;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i=0; i<R; i++)
			map[i] = br.readLine().toCharArray();
		
//		System.out.println(Arrays.deepToString(map));
		// 입력 끝 //
		
		for(int i=0; i<R; i++) {
			bol=false;
			map[i][0]='x';
			dfs(i,0);
			
//			for(int j=0; j<C; j++)
//				System.out.print(map[i][j]);
//			System.out.println();
		}
		

		System.out.println(answer);
		

	}
	private static void dfs(int x, int y) {
		
		if(y == C-1) {		
			answer += 1;
			bol = true;
			return;
		}
		
		for(int d=0; d<3; d++) {
			if(bol) continue;
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx < 0 || nx >= R || ny >= C || map[nx][ny] == 'x') continue;
			map[nx][ny] = 'x';
			

			dfs(nx,ny);
			
		}
	}
}