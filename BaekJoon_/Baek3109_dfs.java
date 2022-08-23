package Baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek3109_dfs {

	static int R, C;
	static char map[][];
	static int answer = 0;
	static int dx[] = {-1,0,1};
	static int dy[] = {1,1,1};

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
			
			dfs(i,0);
			
		}

		System.out.println(answer);
		

	}
	private static boolean dfs(int x, int y) {
		if(y == C-1) {		
			answer += 1;
			return true;
		}
		
		for(int d=0; d<3; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx < 0 || nx >= R || ny >= C || map[nx][ny] == 'x') continue;
			map[nx][ny] = 'x';
			
			if(dfs(nx,ny)) return true;
		}
		return false;
	}
}