package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_2447_별찍기10 {
	
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] answer = star(N);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				sb.append(answer[i][j]);
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	static char s3[][] = {{'*','*','*'},{'*',' ','*'},{'*','*','*'}};
	private static char[][] star(int n){
		if(n==3) return s3;
		
		char[][] now = new char[n][n];
		char[][] last = star(n/3);
		
		int temp = n/3;
		for(int i=0; i<n; i+=temp) {
			for(int j=0; j<n; j+=temp) {
				if(i==temp && j==temp) {
					for(int x=0; x<temp; x++) {
						int ni = i+x;
						int nj = j;
						for(int y=0; y<temp; y++) {
							now[ni][nj++] = ' ';
						}
					}
				}
				else {
					for(int x=0; x<temp; x++) {
						int ni = i+x;
						int nj = j;
						for(int y=0; y<temp; y++) {
							now[ni][nj++] = last[x][y];
						}
					}
				}
				
			}
		}
		return now;
	}

}
