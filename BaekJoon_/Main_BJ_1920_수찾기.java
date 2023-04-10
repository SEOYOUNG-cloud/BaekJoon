package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1920_수찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> A = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int in = Integer.parseInt(st.nextToken());
			if(A.contains(in)) { 
				sb.append("1").append('\n');
			} else {
				sb.append("0").append('\n');
			}
		}
		System.out.println(sb.toString());
		
	}

}
