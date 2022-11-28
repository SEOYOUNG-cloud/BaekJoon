package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_17182_우주탐사선 {
	
	static int N, K;
	static int[][] map;
	static int answer = Integer.MAX_VALUE;
	static int[][] dp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		///////////
		order = new int[N-1];
		
		// Floyd-Warshell
		for(int k=0; k<N; k++)
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
		
		dfs(0,0);
		System.out.println(answer);
		
	}
	static int[] order;
	private static void dfs(int cnt, int flag) {
		if(cnt == N-1) {
			conf(order);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(i == K) continue;
			if((flag & (1<<i)) != 0) continue;
			order[cnt] = i;
			
			dfs(cnt+1, (flag | (1<<i)));
		}
	}
	private static void conf(int[] o) {
		int total = 0;
		total += map[K][o[0]];
				
		for(int i=0; i<N-2; i++) {
			total += map[o[i]][o[i+1]];
		}
		
		answer = Math.min(answer, total);
	}

}
