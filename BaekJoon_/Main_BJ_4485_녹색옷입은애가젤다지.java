package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_4485_녹색옷입은애가젤다지 {
	
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
			return cnt - o.cnt;
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1;;tc++) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			/////////
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0, 0, map[0][0]));
			boolean[][] visited = new boolean[N][N];
			
			while(!pq.isEmpty()) {
				Node now = pq.poll();
				
				if(now.x == N-1 && now.y == N-1) {
					sb.append("Problem").append(" ").append(tc).append(": ").append(now.cnt).append('\n');
					break;
				}
				
				for(int d=0; d<4; d++) {
					int nx = now.x + dx[d];
					int ny = now.y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						pq.offer(new Node(nx, ny, now.cnt + map[nx][ny]));
					}
				}
			}
		}
		
		System.out.println(sb.toString());

	}

}
