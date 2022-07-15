package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1010_java {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 조합 MCN
			double mom = 1;
			double son = 1;
			for(int i = M; i > M-N; i--)
				mom *= i;
			
			for(int i = 1; i <= N; i++) {
				son = son * i;
			}
			
			System.out.printf("%.0f\n" ,mom/son);
		}
	}
//	public static long combination(long mom, long son) {
//		for(int i = M; i > M-N; i--)
//			mom *= i;
//		
//		for(int i = 1; i <= N; i++) {
//			son = son * i;
//		}
//	}
}