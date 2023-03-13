package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_11051_이항계수2 {
	static long div = 10007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		memo = new long[N+1][K+1];
		System.out.println(ehung(N,K));
	}
	static long[][] memo;
	
	private static long ehung(int n, int k) {
		if(k == 0 || n == k) return memo[n][k] = 1;
		if(memo[n][k] != 0) return memo[n][k];
		
		return memo[n][k] = (ehung(n-1, k) + ehung(n-1, k-1))%div;
	}

}

