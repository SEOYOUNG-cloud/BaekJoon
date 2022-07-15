package test;

import java.util.Scanner;

public class SWEA2001 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = scan.nextInt();
			int M = scan.nextInt();
			int[][] map = new int[N][N];
			int max = Integer.MIN_VALUE;
			
			// ¸Ê ÀÔ·Â¹Þ±â
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					map[i][j] = scan.nextInt();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int total = 0;
					if(i+M > N || j+M > N) break;
					for(int x = i; x < i + M; x++) {
						for(int y = j; y < j+M; y++) {
							total += map[x][y];
						}
					}
					if(total > max)
						max = total;
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}

	}

}
