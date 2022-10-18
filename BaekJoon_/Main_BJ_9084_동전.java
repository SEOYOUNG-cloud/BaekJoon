package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_9084_동전 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] coin = new int[N+1];
			st = new StringTokenizer(br.readLine());
			
			for(int i=1; i<=N; i++)
				coin[i] = Integer.parseInt(st.nextToken());
			
			int M = Integer.parseInt(br.readLine());
			
			// 입력끝 //
			
			int[][] dp = new int[N+1][M+1];
			int first = coin[1];
			for(int i=0; i<=M/first; i++) {
				dp[1][first*i] = 1;
			}
			
			for(int i=1; i<=N; i++)
				dp[i][0] = 1;
					
			for(int i=2; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					if(j - coin[i] < 0) dp[i][j] = dp[i-1][j];
					else {
						dp[i][j] = dp[i-1][j] + dp[i][j-coin[i]];
					}
				}
			}
			
//			for(int i=1; i<=N; i++)
//				System.out.println(Arrays.toString(dp[i]));
			
			System.out.println(dp[N][M]);
			
			
		}

	}

}
