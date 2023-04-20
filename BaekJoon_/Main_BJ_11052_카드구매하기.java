package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_11052_카드구매하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] card = new int[N+1];
		for(int i=1; i<=N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + card[j]);
			}
		}
		
		System.out.println(dp[N]);
	}

}
