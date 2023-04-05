package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1904_01타일 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		/* 입력 끝 */
		if(N == 1) {
			System.out.println("1");
			return;
		}
		int[] dp = new int[N+1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=N; i++) {
			dp[i] = dp[i-1] % 15746 + dp[i-2] % 15746;
		}
		
		System.out.println(dp[N] % 15746);

	}

}
