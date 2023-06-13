package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_9465_스티커 {
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] score = new int[2][n+1];
			
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=n; j++) {
					score[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			/* */
			int[][] dp = new int[2][n+1];
			dp[0][1] = score[0][1];
			dp[1][1] = score[1][1];
			
			for(int i=2; i<=n; i++) {
				dp[0][i] = Math.max(dp[1][i-2], dp[1][i-1]) + score[0][i];
				dp[1][i] = Math.max(dp[0][i-2], dp[0][i-1]) + score[1][i];
			}
			
			sb.append(Math.max(dp[0][n], dp[1][n])).append('\n');
		}	
		System.out.println(sb.toString());
	}
}
