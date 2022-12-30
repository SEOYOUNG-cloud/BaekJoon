package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_11726_2xn타일링 {

	static long[] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new long[1001];
		map[1] = 1;
		map[2] = 2;
		
		for(int i=3; i<=N; i++) {
			map[i] = (map[i-1] + map[i-2]) % 10007;
		}
		System.out.println(map[N]);
	}
}
