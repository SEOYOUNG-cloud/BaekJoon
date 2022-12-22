package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_2447_별찍기10_2번째 {
	
	static int N;
	static char[][] answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = new char[N][N];
		
		star(0,0,N,false);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				sb.append(answer[i][j]);
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	private static void star(int x, int y, int n, boolean blank){
		// 빈 칸 채우는 코드
		if(blank) {
			for(int i=x; i<x+n; i++)
				for(int j=y; j<y+n; j++)
					answer[i][j] = ' ';
			return;
		}
		
		if(n == 1) {
			answer[x][y] = '*';
			return;
		}
		
		int temp = n/3;
		int cnt = 0;
		for(int i=x; i<x+n; i+=temp) {
			for(int j=y; j<y+n; j+=temp) {
				if(++cnt == 5)
					star(i, j, temp, true);
				else
					star(i, j, temp, false);
			}
		}

	}

}
