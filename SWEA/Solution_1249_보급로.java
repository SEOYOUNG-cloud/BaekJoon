package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1249_보급로_박서영 {
	
	static class Node implements Comparable<Node>{
		int x, y, weight;

		public Node(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}
	
	static int N;
	static int[][] map, newMap;

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		System.setIn(new FileInputStream("res/input_보급로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				char in[] = br.readLine().toCharArray();
				for(int j=0; j<N; j++) {
					map[i][j] = in[j]-'0';
				}
			}
			newMap = new int[N][N];
			for(int i=0; i<N; i++)
				Arrays.fill(newMap[i], 9*N*N);
			
			newMap[0][0] = 0;
			
			
			/// 입력 끝 ///
			bfs(new Node(0, 0, 0));
			sb.append("#").append(tc).append(" ").append(newMap[N-1][N-1]).append('\n');
			
		}
		System.out.println(sb.toString());

	}
	static int[] dx = {0,1, 0, -1};
	static int[] dy = {1,0, -1, 0};
	
	private static void bfs(Node start) {
		PriorityQueue<Node> queue = new PriorityQueue<>(); // 다익스트라
		queue.add(start);
		
		while(!queue.isEmpty()) {
			
			Node out = queue.poll();
			int i = out.x;
			int j = out.y;
			
			if(i==N-1 && j==N-1) break;
			
			for(int d=0; d<4; d++) {
				int nx = i + dx[d];
				int ny = j + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(newMap[nx][ny] <= newMap[i][j] + map[nx][ny]) continue;
				newMap[nx][ny] = newMap[i][j] + map[nx][ny];
					
				queue.add(new Node(nx, ny, newMap[nx][ny]));
			}
		}
		
		
	}

}
