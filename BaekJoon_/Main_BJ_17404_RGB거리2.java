package BaekJoon;
import java.util.*;
import java.io.*;

public class Main_BJ_17404_RGB거리2 {

	static int[][] dp;
	static int[][] map;
	static int N;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[3][N];
		StringTokenizer st;

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[j][i] = Integer.parseInt(st.nextToken());
			}
		}


		// 1. 첫 번째 집이 빨간색일 경우
		dp = new int[3][N];

		dp[0][0] = map[0][0];
		dp[1][0] = map[0][0];
		dp[2][0] = map[0][0];


		calc1();
		dp[0][1] = Integer.MAX_VALUE;

		calc2();

		int answer = Math.min(dp[1][N-1], dp[2][N-1]);

		// 2. 첫 번째 집이 초록일 경우
		dp = new int[3][N];

		dp[0][0] = map[1][0];
		dp[1][0] = map[1][0];
		dp[2][0] = map[1][0];

		calc1();
		dp[1][1] = Integer.MAX_VALUE;

		calc2();

		answer = Math.min(Math.min(dp[0][N-1], dp[2][N-1]), answer);


		// 3. 첫 번째 집이 파랑일 경우
		dp = new int[3][N];

		dp[0][0] = map[2][0];
		dp[1][0] = map[2][0];
		dp[2][0] = map[2][0];

		calc1();

		dp[2][1] = Integer.MAX_VALUE;

		calc2();

		answer = Math.min(Math.min(dp[0][N-1], dp[1][N-1]), answer);

		System.out.println(answer);

	}

	private static void calc1() {
		dp[0][1] = dp[0][0] + map[0][1];
		dp[1][1] = dp[1][0] + map[1][1];
		dp[2][1] = dp[2][0] + map[2][1];


	}


	private static void calc2() {
		for(int i=2; i<N; i++) {
			dp[0][i] = dp[1][i-1] > dp[2][i-1] ? dp[2][i-1] + map[0][i] : dp[1][i-1] + map[0][i];
			dp[1][i] = dp[0][i-1] > dp[2][i-1] ? dp[2][i-1] + map[1][i] : dp[0][i-1] + map[1][i];
			dp[2][i] = dp[0][i-1] > dp[1][i-1] ? dp[1][i-1] + map[2][i] : dp[0][i-1] + map[2][i];
		}
	}

}
