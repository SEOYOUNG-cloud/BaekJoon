package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_12865_평범한배낭_탑다운 { // 13 8 14 12

	static int map[][];
	static int N,K;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][2];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken()); // 무게 w
			map[i][1] = Integer.parseInt(st.nextToken()); // 가치 v
		}
		
//		System.out.println(Arrays.deepToString(map));
		dp = new int[N+1][K+1];
		
		recur(N, K);
		
//		for(int i=0; i<=N; i++)
//			System.out.println(Arrays.toString(dp[i]));
		System.out.println(dp[N][K]);
		
	}
	static int[][] dp;
	private static int recur(int x, int w) {
		if(dp[x][w] > 0) return dp[x][w];
		if(x == 0) return 0;
		
		int n1 = 0;
		if(w - map[x][0] >= 0) { // 현재무게 - 이전무게 > 0이면 비교 가능한 대상
			n1 = recur(x-1, w-map[x][0]) + map[x][1];
		}
		
		int n2 = recur(x-1, w); // 선택 안해서 그냥 위에꺼
		
		return dp[x][w] = Math.max(n1, n2);
		
	}


}
