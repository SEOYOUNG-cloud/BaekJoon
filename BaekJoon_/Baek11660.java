package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11660_구간합구하기5_박서영 {
	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		// 가로마다 더한 map 입력받기
		for(int i = 1; i <= N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <=N; j++)
				map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
		}
	
		for(int tc = 0; tc < M; tc++) {
			int total = 0;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int row = x1; row <= x2; row++) {
				total += map[row][y2] - map[row][y1-1];
			}
			
			sb.append(total+"\n");
		}
		
		System.out.println(sb.toString());
		

	}

}
