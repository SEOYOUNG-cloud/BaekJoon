package test;

import java.util.Scanner;

public class SWEA1979 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = scan.nextInt();
			int K = scan.nextInt();
			int[][] map = new int[N][N];
			int answer = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					map[i][j] = scan.nextInt();
			}
	
			//가로
			for(int i = 0; i < N; i++) {
				int count = 0;
				for(int j = 0; j < N; j++)
					if(map[i][j] == 1) {
						count += 1;
					} else {
						if (count == K)
							answer += 1;
						count = 0;
					}
				if(count == K) {
					answer += 1;
				}
			}
			
			//세로
			for(int i = 0; i < N; i++) {
				int count = 0;
				for(int j = 0; j < N; j++)
					if(map[j][i] == 1) {
						count += 1;
					} else {
						if (count == K)
							answer += 1;
						count = 0;
					}
				if(count == K) {
					answer += 1;
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
		
	}

}
