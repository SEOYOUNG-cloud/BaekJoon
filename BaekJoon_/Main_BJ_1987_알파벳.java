package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Bj_1987_알파벳_박서영 {

	static boolean isVisited[] = new boolean[26];
	static char map[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int R,C,answer=1, count=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++)
				map[i][j] = str.charAt(j);
		}
		
//		System.out.println(Arrays.deepToString(map));
		dfs(0,0);
		System.out.println(answer);
		
	}
	private static void dfs(int x, int y) {
		count += 1;
		
		isVisited[map[x][y] - 65] = true;
//		System.out.println(Arrays.toString(isVisited));
		
		for(int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			if(isVisited[map[nx][ny] - 65]) continue;
			
			isVisited[map[nx][ny] - 65] = true;
			dfs(nx, ny);
			isVisited[map[nx][ny] - 65] = false;
			count -= 1;
		}
		
		answer = Math.max(answer, count);
	}

}
