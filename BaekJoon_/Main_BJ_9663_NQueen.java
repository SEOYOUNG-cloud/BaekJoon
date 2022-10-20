package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_9663_NQueen {

	static int N;
	static int[] chess;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		chess = new int[N];
		
		dfs(0);
		
		System.out.println(answer);

	}

	private static void dfs(int cnt) {
		if(cnt == N) {
			answer += 1;
			return;
		}
		
		for(int i=0; i<N; i++) {
			chess[cnt] = i;
			if(conf(cnt)) dfs(cnt+1);
		}
	}
	private static boolean conf(int cnt) {
		
		// 행 확인
		for(int i=0; i<cnt; i++) {
			if(chess[i] == chess[cnt]) return false;
		}
		
		// 대각선 확인
		for(int i=0; i<cnt; i++) {
			if(Math.abs(i - cnt) == Math.abs(chess[i] - chess[cnt])) return false;
		}
		
		return true;
		
	}

}
