package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1912_연속합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] map = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			map[i] = Integer.parseInt(st.nextToken());
		
//		System.out.println(Arrays.toString(map));
		
		dp[0] = map[0];
		
		for(int i=1; i<n; i++) {
			if(dp[i-1] + map[i] > map[i]) dp[i] = dp[i-1] + map[i];
			else
				dp[i] = map[i];
		}
		
		int answer = Integer.MIN_VALUE;
		for(int i=0; i<n; i++)
			if(dp[i] > answer)
				answer = dp[i];
		
		System.out.println(answer);

	}

}
