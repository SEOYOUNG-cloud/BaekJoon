package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1941_소문난칠공주 {
	static char[][] map;
	static boolean[][] visited;
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static int answer = 0;
	
	static class Seat{
		int x, y;

		public Seat(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Seat [x=" + x + ", y=" + y + "]";
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		
		for(int i=0; i<5; i++)
			map[i] = br.readLine().toCharArray();
		
		/// 입력 끝 ///
		
		// 1. 25개중에 7개 뽑는다. 
		comb(0,0);
		
		// 2. bfs로 자리가 연결되어 있는지 확인 
		// 3. 연결되어 있다면 'S' 개수 세기 
		System.out.println(answer);

	}
	static int[][] seat = {{0,0},{0,1},{0,2},{0,3},{0,4},{1,0},{1,1},{1,2},{1,3},{1,4},{2,0},{2,1},{2,2},{2,3},{2,4},{3,0},{3,1},{3,2},{3,3},{3,4},{4,0},{4,1},{4,2},{4,3},{4,4}};
	static int[] order = new int[7];
	private static void comb(int cnt, int start) {
		if(cnt == 7) {
			bfs(order);
			return;
		}
		for(int i=start; i<25; i++) {
			order[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	private static void bfs(int[] o) {
		boolean visited[][] = new boolean[5][5];
		int qx=0, qy=0;
		for(int i=0; i<7; i++) {
			int idx = o[i];
			int x = seat[idx][0];
			int y = seat[idx][1];
			
			if(i == 0){
				qx = x;
				qy = y;
				continue;
			}
			visited[x][y] = true;
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		int cnt = 0;
		queue.add(new int[] {qx, qy});
		while(!queue.isEmpty()) {
			int out[] = queue.poll();
			int x = out[0];
			int y = out[1];
			cnt += 1;
			
			for(int d=0; d<4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || !visited[nx][ny]) continue;
				visited[nx][ny] = false;
				queue.add(new int[] {nx, ny});
			}
		}
		if(cnt == 7) {
			//'S' 개수 세기 
			if(conf(o)) answer += 1;
		}
		
	}
	private static boolean conf(int[] o) {
		int s = 0;
		for(int i=0; i<7; i++) {
			int idx = o[i];
			int x = seat[idx][0];
			int y = seat[idx][1];
			
			if(map[x][y] == 'S') s += 1;
		}
		if(s >= 4) return true;
		return false;
	}
}
