package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_16938_캠프준비 {
	
	static int N, L, R, X;
	static int[] map;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			map[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(map);
		
		////////
//		backtracking(0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
		// 1. 몇 개 선택할지 for문 돌림 
		// 2. 조합으로 찾음 
		for(int i=2; i<=N; i++) {
			combination(0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		
		System.out.println(answer);
		
	}
	static int answer = 0;
	static ArrayList<Integer> list = new ArrayList<>();
	private static void combination(int cnt, int now, int start, int total, int big, int small) {
		if(cnt == now) {
			// 문제 난이도의 합 >= L , <= R
			// 가장 어려운 문제 - 쉬운 문제 >= X
			if(cnt > 1) {
				if(total >= L && total <= R && big-small >= X) {
					answer += 1;
				}
			}
			
			return;
		}
		
		for(int i=start; i<N; i++) {
			combination(cnt+1, now, i+1, total+map[i], Math.max(big, map[i]), Math.min(small, map[i]));
		}
	}

}
