package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1058_친구 {
	
	static int N;
	static char[][] map;
	static char[][] answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		answer = new char[N][N];
		
		for(int i=0; i<N; i++) {
			char[] in = br.readLine().toCharArray();;
			map[i] = in;
		}
		for(int i=0; i<N; i++)
			answer[i] = map[i].clone();
		
		select();
		int max = 0;
		for(int i=0; i<N; i++) {
			int total = 0;
			for(int j=0; j<N; j++) {
				if(answer[i][j] == 'Y') total += 1;
			}
			max = Math.max(max, total);
		}
		
		System.out.println(max);
		
	}
	static ArrayList<Integer> list;
	private static void select() {
		for(int i=0; i<N; i++) {
			list = new ArrayList<>();
			
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'Y') {
					list.add(j);
				}
			}
			comb(0,0);
		}
	}
	static int[] arr = new int[2];
	private static void comb(int cnt, int start) {
		if(cnt == 2) {
			answer[arr[0]][arr[1]] = 'Y';
			answer[arr[1]][arr[0]] = 'Y';
			return;
		}
		
		for(int i=start; i<list.size(); i++) {
			arr[cnt] = list.get(i);
			comb(cnt+1, i+1);
		}
	}

}
