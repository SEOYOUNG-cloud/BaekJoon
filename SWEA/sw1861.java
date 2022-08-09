package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방_박서영 {
	static int N;
	static int map[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input (3).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
//			total = 1;
			int max = 0;
			
			//map 입력받기
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			// 하나씩 훑어보자..
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					 if(max == bfs(i,j))
						list.add(map[i][j]);
					 else if(max < bfs(i,j)) {
						max = bfs(i,j);
						list.clear();
						list.add(map[i][j]);
					 }
			}
			
			Collections.sort(list);
			
			System.out.println("#" + tc + " "+ list.get(0) + " " + max);
	
		}
		

	}
	public static int bfs(int x, int y) {
		int total = 1;

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(x,y));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			x = node.getX();
			y = node.getY();
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int cnt = map[x][y] + 1;

				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

				if(map[nx][ny] != cnt) continue;
				
				queue.add(new Node(nx,ny));
				total+=1;
				
			}
		}
		
		return total;
	}

	static private class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}	
		
	}

}
