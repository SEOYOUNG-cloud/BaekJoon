package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1929_소수구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		if(N <= 2) sb.append("2").append('\n');
		if(N%2 == 0) N += 1;
		if(N == 1) N = 3;
		
		loop: for(int i=N; i<=M; i+=2) {
			for(int j=3; j<=Math.sqrt(i); j+=2) {
				if(i % j == 0) continue loop;
			}
			sb.append(i).append('\n');
		}
		
		System.out.println(sb.toString());

	}

}
