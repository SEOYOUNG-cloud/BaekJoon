package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node7569{
	private int x, y, z;
		
	public Node7569(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public int getX() {return this.x;}
	public int getY() {return this.y;}
	public int getZ() {return this.z;}
}

public class Baek7569 { // BFS
	public static int M, N, H, ans = 0;
	public static int map[][][];
	public static int dx[] = {1, -1, 0, 0, 0, 0};
	public static int dy[] = {0, 0, 1, -1, 0 ,0};
	public static int dz[] = {0, 0, 0, 0, 1, -1};
	public static Queue<Node7569> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[N][M][H];
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int k = 0; k < M; k++) {
					map[j][k][i] = Integer.parseInt(st.nextToken());
					if(map[j][k][i] == 1) queue.offer(new Node7569(j, k, i));
				}		
			}
		}
		
		System.out.println(tomato_bfs());
			
		
	}
	
	public static int tomato_bfs() {
		while(!queue.isEmpty()) {
			Node7569 t = queue.poll();
			int x = t.getX();
			int y = t.getY();
			int z = t.getZ();
			
			for(int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				
				if(nx <= -1 || nx >= N || ny <= -1 || ny >= M || nz <= -1 || nz >= H || map[nx][ny][nz] == -1) continue;
				if(map[nx][ny][nz] == 0) {
					map[nx][ny][nz] = map[x][y][z] + 1;
					queue.offer(new Node7569(nx, ny, nz));
				}
			}
		}
		
		for(int i = 0; i < H; i++) 
			for(int j = 0; j < N; j++) 
				for(int k = 0; k < M; k++) {
					if(map[j][k][i] == 0) return -1;
					ans = Math.max(ans, map[j][k][i]);
				}		
			
		return ans - 1;
	}
	
}
