package BaekJoon;

import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class Main_BJ_1405_미친로봇 {
	
	static int N;
	static double[] percent = new double[4];
	static boolean[][] map = new boolean[30][30];
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		for(int i=0; i<4; i++) {
			percent[i] = (Double.parseDouble(st.nextToken())) * 0.01;
		}
		
		//////
		map[15][15] = true;
		dfs(0, 15, 15, 1.0);
		
		System.out.println(answer);
		

	}
	static double answer = 0;
	
	private static void dfs(int cnt, int x, int y, double total) {
		
		if(cnt == N) {
			answer += total;
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(!map[nx][ny] && percent[d] > 0) {
			
				map[nx][ny] = true;
				dfs(cnt+1, nx, ny, total * percent[d]);
				map[nx][ny] = false;
			}
		}
		
	}

}
