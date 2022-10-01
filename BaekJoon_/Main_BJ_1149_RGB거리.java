package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1149_RGB거리_박서영 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/// 입력 끝 ///
		
		int[][] dp = new int[N][3];
		for(int i=0; i<N; i++)
			Arrays.fill(dp[i], 1000*N);
		dp[0] = map[0];

		//  빨 초 파
		//1
		//2
		//...
		//N

		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					if(j==k) continue;
					dp[i][j] = Math.min(dp[i-1][k] + map[i][j], dp[i][j]);
				}
			}
		}

//		int answer = Integer.MAX_VALUE;
//		for(int i=0; i<3; i++)
//			answer = Math.min(answer, dp[N-1][i]);
//		
//		System.out.println(answer);
		
		Arrays.sort(dp[N-1]);
        System.out.println(dp[N-1][0]);

	}

}
