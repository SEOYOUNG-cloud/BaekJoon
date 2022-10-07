package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2579_계단오르기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		int answer = 0;
		if(N <= 2) {
			for(int i : map)
				answer += i;
			
			System.out.println(answer);
			return;
		}
		
//		System.out.println(Arrays.toString(map));
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = map[1];
		dp[2] = map[1] + map[2];
		
		for(int i=3; i<=N-2; i++) {
			int a = dp[i-2] + map[i];
			int b = dp[i-3] + map[i-1] + map[i];
			
			dp[i] = Math.max(a, b);
		}
		
		int a = dp[N-3] + map[N-1] + map[N];
		int b = dp[N-2] + map[N];
		int max = Math.max(a, b);
		
		System.out.println(max);
		

	}

}
