package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_17779_게리맨더링2 {
	
	static int N;
	static int[][] people; // 인구수
	static int total = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N+1][N+1];
		
		StringTokenizer st;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int in = Integer.parseInt(st.nextToken());
				total += in;
				people[i][j] = in;
			}
		}
		
		// 1. select d1, d2, x, y
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				// x,y 정했음 
				int x=i;
				int y=j;
				for(int dir1=1; dir1<=N; dir1++) {
					for(int dir2=1; dir2<=N; dir2++) {
						if (x + dir1 + dir2 >= N) continue;
                        if (y - dir1 < 0 || y + dir2 >= N) continue;
						// 2. district division
						// 3. count person
						div(x,y,dir1,dir2);
					}
				}
			}
		}
		System.out.println(answer);
	}
	static int answer = Integer.MAX_VALUE;

	private static void div(int x, int y, int d1, int d2) {
		boolean[][] border = new boolean[N+1][N+1];
		int count[] = new int[6];
		count[5] = total;
		
		// 5번 선거구 
		for(int i=0; i<=d1; i++) {
			border[x+i][y-i] = true;
			border[x+d2+i][y+d2-i] = true;
			
		}
		for(int j=0; j<=d2; j++) {
			border[x+j][y+j] = true;
			border[x+d1+j][y-d1+j] = true;
		}
		
		// 1번 선거구 
		for(int i=1; i<x+d1; i++) {
			for(int j=1; j<=y; j++) {
				if(border[i][j]) break;
				count[1] += people[i][j];
			}
		}
		
		// 2번 선거구 
		for(int i=1; i<=x+d2; i++) {
			for(int j=N; j>y; j--) {
				if(border[i][j]) break;
				count[2] += people[i][j];
			}
		}
		
		// 3번 선거구 
		for(int i=x+d1; i<=N; i++) {
			for(int j=1; j<y-d1+d2; j++) {
				if(border[i][j]) break;
				count[3] += people[i][j];
			}
		}
		
		// 4번 선거구
		for(int i=x+d2+1; i<=N; i++) {
			for(int j=N; j>=y-d1+d2; j--) {
				if(border[i][j]) break;
				count[4] += people[i][j];
			}
		}
		
		
		for(int i=1; i<=4; i++) {
			count[5] -= count[i];
		}
		
		Arrays.sort(count);
		
		answer = Math.min(count[5] - count[1], answer);
		
	}

}
