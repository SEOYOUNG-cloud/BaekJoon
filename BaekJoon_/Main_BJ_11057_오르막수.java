import java.util.*;
import java.io.*;

public class Main_BJ_11057_오르막수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[][] dp = new long[N+1][10];
		long[] answer = new long[N+1];
		Arrays.fill(dp[1], 1);
		answer[1] = 10;

		for(int i=2; i<=N; i++){
			dp[i][0] = answer[i-1] % 10007;
			long total = dp[i][0];

			for(int j=1; j<10; j++){
				dp[i][j] = (dp[i][j-1] - dp[i-1][j-1]) % 10007;
				total += dp[i][j] ;
			}
			answer[i] = total % 10007;
		}

		System.out.println(answer[N] % 10007);

	}
}
