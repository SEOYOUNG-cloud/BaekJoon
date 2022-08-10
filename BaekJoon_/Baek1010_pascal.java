package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1010_pascal {
	static int dp[][] = new int[31][31]; // 최대 30이므로 31로 놨음

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(Pascal(M,N)).append('\n');
			
		}
		System.out.println(sb);

	}
	public static int Pascal(int n, int m) {
		if(dp[n][m] > 0)
			return dp[n][m];
		
		if(m == 0 || n == m) return dp[n][m] = 1;
		return dp[n][m] = Pascal(n-1, m-1) + Pascal(n-1, m);
		
	}

}
