package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2156_포도주시식 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int wine[] = new int[n+1];
		int dp[] = new int[n+1];

		for(int i=1; i<=n; i++)
			wine[i] = Integer.parseInt(br.readLine());

//		System.out.println(Arrays.toString(wine));
		int answer = 0;
		if(n<=2) {
			for(int i : wine)
				answer += i;
			System.out.println(answer);
			return;
		}

		dp[0] = 0;
		dp[1] = wine[1];
		dp[2] = wine[1] + wine[2];

		for(int i=3; i<=n; i++) {
			// - - x
			int a = dp[i-1];

			// - x o
			int b = dp[i-2] + wine[i];

			// x o o
			int c = dp[i-3] + wine[i-1] + wine[i];

			dp[i] = Math.max(a, Math.max(b, c));
		}

//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);

	}

}
