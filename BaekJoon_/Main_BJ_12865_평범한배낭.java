package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_12865_평범한배낭 { // 13 8 14 12

	static int map[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N+1][2];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.deepToString(map));
		int[][] dp = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				dp[i][j] = dp[i-1][j];
				if(j-map[i][0] >= 0) { // 무게를 뺀게 0보다 크다면(범위에서 벗어나지 않는다면)
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-map[i][0]]+map[i][1]);
					
				}
			}
		}
		
		for(int i=0; i<=N; i++)
			System.out.println(Arrays.toString(dp[i]));
		
		System.out.println(dp[N][K]);
		
	}


}
