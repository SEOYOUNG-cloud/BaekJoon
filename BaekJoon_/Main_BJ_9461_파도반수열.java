package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_9461_파도반수열{

	static long[] map;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		map = new long[101];
		map[1] = 1;
		map[2] = 1;
		map[3] = 1;
		
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(recursive(N)).append('\n');
		}
		System.out.println(sb.toString());

	}
	private static long recursive(int n) {
		if(map[n] != 0) return map[n];
		if(map[n-3] == 0) map[n-3] = recursive(n-3);
		if(map[n-2] == 0) map[n-2] = recursive(n-2);
		
		return map[n] = map[n-2]+map[n-3];
	}

}
