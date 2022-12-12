package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1261_알고스팟 {
	
	static class Node implements Comparable<Node>{
		int x, y, cnt;

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(cnt, o.cnt);
		}
	}

	static int N,M; // 세로, 가로 (NxM)
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String in = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = in.charAt(j) - '0';
			}
		}
		///////
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, 0));
		
		boolean[][] visited = new boolean[N][M];
		
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.x == N-1 && now.y == M-1) {
				System.out.println(now.cnt);
				return;
			}
			
			for(int d=0; d<4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					pq.offer(new Node(nx, ny, now.cnt + map[nx][ny]));
				}
			}
		}
		

	}

}
