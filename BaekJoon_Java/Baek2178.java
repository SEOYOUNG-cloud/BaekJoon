package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	private int x;
	private int y;
	
	public Node(int x, int y) {
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

public class Baek2178 { // BFS
	public static int[][] maze = new int[100][100];
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0 ,-1, 1};
	public static int N = 0, M = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
				
		
		for(int i = 0; i < N; i++) {
			String miro = br.readLine();
			for(int j = 0; j < M; j++) 
				maze[i][j] = miro.charAt(j) - '0';	
		}
		
		System.out.println(arrive_BFS(0, 0));
			
	}
	
	public static int arrive_BFS(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll(); // queue에서 꺼낸다
			x = node.getX();
			y = node.getY();
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx <= -1 || nx >= N || ny <= -1 || ny >= M) continue;
				if(maze[nx][ny] == 0) continue;
				if(maze[nx][ny] == 1) {
					maze[nx][ny] = maze[x][y] + 1;
					queue.offer(new Node(nx, ny));
				}
			}
		}
		
		return maze[N - 1][M - 1];
		
	}
	
}
