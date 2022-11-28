package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_16198_에너지모으기 {
	
	static int N;
	static ArrayList<Integer> map;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			map.add(Integer.parseInt(st.nextToken()));
		
		backtracking(N, 0);
		
		System.out.println(answer);

	}
	static int answer = Integer.MIN_VALUE;
	private static void backtracking(int cnt, int total) {
		if(map.size() == 2) {
			answer = Math.max(answer, total);
			return;
		}
		for(int i=1; i<cnt-1; i++) {
			int now = map.get(i);
			map.remove(i);
			backtracking(cnt-1, total+(map.get(i-1)*map.get(i)));
			map.add(i, now);
		}
	}

}
