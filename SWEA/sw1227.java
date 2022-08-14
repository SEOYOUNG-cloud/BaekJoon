package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int x;
	int y;
	public Node(int x, int y){
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
public class sw1227 {
	static int map[][];
	static int start_x, start_y;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static boolean answer = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_1227.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			int T = Integer.parseInt(br.readLine());
			map = new int[100][100];
			
			// map 입력받기 
			for(int i=0; i<100; i++) {
				String str = br.readLine();
				for(int j=0; j<100; j++) {
					map[i][j] = str.charAt(j) - '0';
					if(map[i][j] == 2) {
						start_x = i;
						start_y = j;
					}
				}
			}
			/////입력 끝

//			if(bfs()) System.out.println("#" + tc + " 1");
//			else {
//				System.out.println("#" + tc + " 0");
//			}
			answer=false;
			dfs(start_x, start_y);
			if(answer) System.out.println("#" + tc + " 1");
			else {
				System.out.println("#" + tc + " 0");
			}
		}
	}
	public static boolean bfs() {
		map[start_x][start_y] = 1;
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(start_x, start_y));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.getX();
			int y = node.getY();
			
			for(int d=0; d<4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100) continue;
				if(map[nx][ny] == 3) {
					return true;
				}
				else if(map[nx][ny] == 0) {
					map[nx][ny] = 1;
					queue.add(new Node(nx, ny));
				}
				
			}
		}
		return false;
	}
	public static void dfs(int x, int y) {
		map[x][y] = 1;
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100) continue;
			if(map[nx][ny] == 3) {
				answer=true;
				return;
			}
			else if(map[nx][ny] == 0) {
				dfs(nx, ny);
			}
		}
	}

}
