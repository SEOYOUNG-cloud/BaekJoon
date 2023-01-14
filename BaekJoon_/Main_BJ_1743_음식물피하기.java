package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1743_음식물피하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][m+1]; // 음식물이 떨어진 위치 
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		}
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int answer = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(map[i][j] == 1) {
					Queue<int[]> queue = new ArrayDeque<>();
					queue.offer(new int[] {i,j});
					
					int cnt = 0;
					while(!queue.isEmpty()) {
						int out[] = queue.poll();
						int x = out[0];
						int y = out[1];
						
						if(map[x][y] == 0) continue;
						map[x][y] = 0;
						cnt += 1;
						
						for(int d=0; d<4; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];
						
							if(nx < 1 || nx >= n+1 || ny < 1 || ny >= m+1 || map[nx][ny] == 0) continue;
							queue.offer(new int[] {nx, ny});
						}
					}
//					System.out.println(cnt);
					answer = Math.max(answer, cnt);
				}
			}
		}
		System.out.println(answer);

	}

}
