package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek16236 {


	static class Fish implements Comparable<Fish>{
		int x,y,size;

		public Fish(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.x != o.x) return this.x - o.x;
			return this.y - o.y;
		}
	}
	
	static int N,baby_x,baby_y, answer=0;
	static int map[][];
	static ArrayList<Fish> fish = new ArrayList<>();
	static int baby_size = 2, grow = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int in = Integer.parseInt(st.nextToken());
				map[i][j] = in;
				
				if(in != 0 && in != 9) {
					fish.add(new Fish(i,j));
				} if(in == 9) {
					baby_x = i;
					baby_y = j;
				}
			}
		}
		// 입력 끝 //
		map[baby_x][baby_y] = 0;
		

		while(find_can_eat());
		
		System.out.println(answer);
		
		br.close();
		
	}
	static int distance[][];
	static int rx,ry;
	private static boolean find_can_eat() {
		distance = new int[N][N];
		rx = Integer.MAX_VALUE;
		ry = Integer.MAX_VALUE;
		
		if(bfs(baby_x, baby_y)) {
			map[rx][ry] = 0;
			baby_x = rx;
			baby_y = ry;
			
			grow += 1;
			if(grow >= baby_size) {
				baby_size += 1;
				grow = 0;
			}
			return true;
		}
		return false;
		
	}

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int cnt=0;
	
	private static boolean bfs(int x, int y) {
		cnt=0;
		distance[x][y] = -1;
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {	
			int size=queue.size();
			cnt+=1;
			
			ArrayList<Fish> list = new ArrayList<>();
			while(size-->0) {
				
				int[] q = queue.poll();
				int i = q[0];
				int j = q[1];
				
				for(int d=0; d<4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] > baby_size || distance[nx][ny] != 0 || map[nx][ny] > baby_size) continue;
					if(map[nx][ny] != 0 && map[nx][ny] < baby_size) {
						list.add(new Fish(nx, ny));
					}
	
					distance[nx][ny] = distance[i][j] + 1;
					queue.add(new int[] {nx,ny});
				}
			}
			if(list.size() != 0) {
				Collections.sort(list);
				answer += cnt;
				rx = list.get(0).x;
				ry = list.get(0).y;
				return true;
			}

			
		}
		
		return false;
	}

}