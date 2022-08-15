package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek9184 {
	static int dp[][][] = new int[21][21][21];

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			if(x == -1 && y == -1 && z == -1) {
				System.out.println(sb);
				return;
			}
			
			sb.append("w(" + x+ ", " + y + ", " + z+") = ").append(w(x,y,z)).append('\n');
		}
	}
	private static int w(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0) return 1;
		
		if(a > 20 || b > 20 || c > 20) return w(20,20,20);
		
		if(dp[a][b][c] != 0) return dp[a][b][c];
		
		if(a<b && b<c) return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		
		else {
			return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		}
	}

}
