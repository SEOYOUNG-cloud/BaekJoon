package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_15650_N과M2 {
	
	static int N, M;
	static int[] out;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		out = new int[M];
		permutation(0,1);
		
		System.out.println(sb.toString());
	}
	
	private static void permutation(int cnt, int start) {
		if(cnt == M) {
			for(int i=0; i<cnt; i++) {
				sb.append(out[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		for(int i=start; i<=N; i++) {
			out[cnt] = i;
			permutation(cnt+1, i+1);
		}
	}

}
