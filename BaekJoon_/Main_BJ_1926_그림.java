package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1926_그림 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		
		int cnt = 0;
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				if(map[i][j] == 1) {
					cnt += 1;
					Queue<int[]> queue = new ArrayDeque<>();
					queue.add(new int[] {i,j});
					
					int count = 0;
					while(!queue.isEmpty()) {
						int out[] = queue.poll();
						int x = out[0];
						int y = out[1];
						
						if(map[x][y] == 0) continue;
						map[x][y] = 0;
						count += 1;
						
						for(int d=0; d<4; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];
							
							if(nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 0) continue;
							queue.offer(new int[] {nx, ny});
						}
					}
					max = Math.max(max, count);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}

}
