package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치_박서영 {
	static int map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("./input (7).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			map = new int[N+1][N+1];
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++)
					map[i][j] = map[i][j-1] + map[i-1][j] - map[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
			
			
			int max = Integer.MIN_VALUE;
			for(int i = M; i <= N; i++)
				for(int j=M; j <= N; j++) {
					int num = map[i][j] - map[i-M][j] - map[i][j-M] + map[i-M][j-M];
					if(num > max)
						max = num;
				}
			
			System.out.println("#" + tc + " " + max);
		}

	}

}
