package Baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_3055_탈출_박서영 {

	static int R,C;
	static char map[][];
	static boolean visited[][];
	static int S_x, S_y, D_x, D_y;
	static Queue<int[]> water = new ArrayDeque<>();
	static String answer = "KAKTUS";
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				char ch = str.charAt(j);
				map[i][j] = ch;
				
				if(ch == 'D') {
					D_x = i;
					D_y = j;
				} else if(ch == 'S') {
					S_x = i;
					S_y = j;
				} else if(ch == '*') {
					water.add(new int[] {i,j});
				}
			}
		}
		map[S_x][S_y] = '.';
		visited = new boolean[R][C];
		visited[S_x][S_y] = true;
		
		// 입력 끝 //

		bfs(S_x, S_y);

		System.out.println(answer);
		br.close();

	}
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	private static void bfs(int x, int y) {
		int cnt = 0;
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int size = queue.size();

			cnt += 1;			
			
			while(size-->0) {
				int[] q = queue.poll();
				int i = q[0];
				int j = q[1];
				if(map[i][j] != '.') continue;
			
				for(int d=0; d<4; d++) {
					int nx = i+dx[d];
					int ny = j+dy[d];
					
					if(nx == D_x && ny == D_y) {
						answer = String.valueOf(cnt);
						return;
					}
					if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] != '.' || visited[nx][ny]) continue;
					
					queue.offer(new int[] {nx,ny});
					visited[nx][ny] = true;
				}
			}
			spread_water();
		}
		
	}
	
	private static void spread_water() { 
		int size = water.size();
		while(size -- >0) {
			int[] q = water.poll();
			int x = q[0];
			int y = q[1];
			
			for(int d=0; d<4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') {
					
					map[nx][ny] = '*';
					water.add(new int[] {nx,ny});
				}
			}
		}	
	}
	

}
