package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1010_다리놓기_박서영 {
	static int N,M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			double mom = 1;
			double son = 1;
			
			for(int i = M; i > M-N; i--)
				son *= i;
			for(int i = 1; i <= N; i++)
				mom *= i;
			
			sb.append(String.format("%.0f", son/mom)).append('\n');
		}
		System.out.println(sb);

	}

}
