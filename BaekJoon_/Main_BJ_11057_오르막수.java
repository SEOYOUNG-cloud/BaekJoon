package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_11057_오르막수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][10];
		for(int i=1; i<=N; i++)
			dp[i][9] = 1;
		
		for(int i=1; i<=N; i++) {
			for(int j=8; j>=0; j--) {
				dp[i][j] = (dp[i][j+1] + dp[i-1][j]) % 10007;
			}
		}
		
		int answer = 0;
		for(int i=0; i<=9; i++)
			answer = (answer+dp[N][i])% 10007;
		
		System.out.println(answer);
	}
}
