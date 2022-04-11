package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato {
	private int x, y;
	
	public tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}

public class Baek7576 { // BFS
	public static int M, N;
	public static int map[][];
	public static int dx[] = {1, -1, 0, 0};
	public static int dy[] = {0, 0, 1, -1};
	public static int ans = 0;
	public static Queue<tomato> queue = new LinkedList<tomato>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) 
					queue.offer(new tomato(i, j)); // 1일 때 queue에 넣음		
			}
		}
	
		System.out.println(tomato_bfs());
		
	}
	
	public static int tomato_bfs() {
		
		while(!queue.isEmpty()) {
			tomato t = queue.poll();
			int x = t.getX();
			int y = t.getY();
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx <= -1 || nx >= N || ny <= -1 || ny >= M || map[nx][ny] == -1) continue;
				
				if(map[nx][ny] == 0) {
					map[nx][ny] = map[x][y] + 1;
					queue.offer(new tomato(nx, ny));
				}
			}
		}
		
//		확인
//		for(int i = 0; i < N; i++) {
//			System.out.println();
//			for(int j = 0; j < M; j++)
//				System.out.print(map[i][j] + " ");
//		}
		
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) return -1;   // 0이 있으면 -1 출력
				ans = Math.max(ans, map[i][j]);
		}
		
		return ans - 1;
		
		
	}

}
