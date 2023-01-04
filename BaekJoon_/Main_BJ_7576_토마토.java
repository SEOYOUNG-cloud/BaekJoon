package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_7576_토마토 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		int tomato = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int in = Integer.parseInt(st.nextToken());
				if(in == 0) tomato ++;
				else if(in == 1) queue.offer(new int[] {i,j});
				map[i][j] = in;
			}
		}
		
		///////
		if(tomato == 0) {
			System.out.println("0");
			return;
		}
		
		int result = -1;
		int cnt = 0;
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			result += 1;
			while(size --> 0) {
				int[] out = queue.poll();
				
				for(int d=0; d<4; d++) {
					int nx = out[0] + dx[d];
					int ny = out[1] + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 0) continue;
					map[nx][ny] = 1;
					cnt += 1;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
		if(cnt == tomato)
			System.out.println(result);
		else
			System.out.println("-1");

	}

}
