package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_9095_123더하기 {

	static int[] list;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		list = new int[11];
		list[1] = 1;
		list[2] = 2;
		list[3] = 4;
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(recursive(N)).append('\n');
		}
		System.out.println(sb.toString());

	}
	private static int recursive(int n) {
		if(list[n] != 0) return list[n];
		if(list[n-3] == 0) list[n-3] = recursive(n-3);
		if(list[n-2] == 0) list[n-2] = recursive(n-2);
		if(list[n-1] == 0) list[n-1] = recursive(n-1);
		
		return list[n] = list[n-3] + list[n-2] + list[n-1];
	}

}
