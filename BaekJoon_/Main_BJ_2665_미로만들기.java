package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_2665_미로만들기 {
	
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
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			String in = br.readLine();
			for(int j=0; j<n; j++) {
				int inn = in.charAt(j) - '0';
				if(inn == 0) map[i][j] = 1;
				else map[i][j] = 0;
				
			}
		}
		
		//////////
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, 0));
		
		boolean[][] visited = new boolean[n][n];
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.x == n-1 && now.y == n-1) {
				System.out.println(now.cnt);
				break;
			}
			for(int d=0; d<4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					pq.offer(new Node(nx, ny, now.cnt + map[nx][ny]));
				}
			}
		}
		
	}

}
