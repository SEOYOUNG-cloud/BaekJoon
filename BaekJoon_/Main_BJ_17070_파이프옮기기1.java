package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_17070_파이프옮기기1_박서영 {

	static int N, answer=0;
	static int[][] map;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		///// 입력 끝 /////
		int dp[][][] = new int[N][N][3]; // 가로 세로 대각선
		dp[0][1][0] = 1;
		
		for(int i=0; i<N; i++) {
			for(int j=2; j<N; j++) {
				if(map[i][j] == 1) continue;
				// 가로
				dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2];
				// 세로
				if(i == 0) continue;
					dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];
				// 대각선
				if(map[i][j-1] != 1 && map[i-1][j] != 1) {
					dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				}
			}
		}
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
		
		

	}

}
