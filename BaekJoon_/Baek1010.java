package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baek1010 { // 조합 + dp
	public static int dp[][] = new int[30][30];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(bridge(M, N)).append('\n');
		}
		
		System.out.println(sb);
		
	}

	public static int bridge(int m, int n) {
		if(dp[m][n] > 0) return dp[m][n]; // 재활용
		if(m == n || n == 0) return dp[m][n] = 1;
		return dp[m][n] = bridge(m - 1, n - 1) + bridge(m - 1, n);
		// n+1 C r+1 = n C r + n C r+1
		
			
	}
}
