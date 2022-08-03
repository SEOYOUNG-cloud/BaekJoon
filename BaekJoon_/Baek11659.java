package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11659_구간합구하기4_박서영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int num[] = new int[N+1];
		num[0] = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			num[i] = num[i-1] + Integer.parseInt(st.nextToken());
		}
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			sb.append(num[j]-num[i-1]).append('\n');
		}
		System.out.println(sb.toString());
			
	}

}
