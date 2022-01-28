package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class virus{
	int x, y;
		
	virus(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Baek14502 { // BFS
	public static int N, M, ans = 0;
	public static int[][] map;
	public static int[][] wall_map;
	public static int dx[] = {1, -1, 0, 0};
	public static int dy[] = {0, 0, 1, -1};
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		wall_map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		wall_map = map; // 배열을 이렇게 복사하면 한쪽이 바뀌면 다른 한쪽도 바뀜
		
		make_wall(0);
		
		System.out.println(ans);
				

	}
	
	//벽 세우기 (모든 경우의 수를 훑음)
	public static void make_wall(int index) {
		if(index == 3) { 
			spread_bfs();
			return;
		}
			
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) 
				if(wall_map[i][j] == 0) {
					wall_map[i][j] = 1;
					make_wall(index + 1);
					wall_map[i][j] = 0; // 다시 원래대로 해놓기
					
				}
	}
	
	//바이러스 퍼트리기
	public static void spread_bfs() {
		int[][] virus_map = new int[N][M];
		Queue<virus> queue = new LinkedList<>();
		
		// 벽 세운 맵 카피
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				virus_map[i][j] = wall_map[i][j];
		
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(virus_map[i][j] == 2)
					queue.offer(new virus(i, j)); // 바이러스가 있으면 queue에 넣음
		
		while(!queue.isEmpty()) {
			virus v = queue.poll(); // 꺼내서
			
			for(int i = 0; i < 4; i++) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				
				if(nx <= -1 || nx >= N || ny <= -1 || ny >= M) continue;
				
				if(virus_map[nx][ny] == 0) {
					virus_map[nx][ny] = 2;
					queue.offer(new virus(nx, ny));
				}
					
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			System.out.println();
//			for(int j =0 ; j < M; j++)
//				System.out.print(virus_map[i][j] + " ");
//		}
//		System.out.println();
		
		int count = 0;
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(virus_map[i][j] == 0)
					count++;
		
		ans = Math.max(count, ans);
		
	}

}
