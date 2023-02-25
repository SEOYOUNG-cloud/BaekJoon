package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BJ_15661_링크와스타트 {
	
	static int N;
	static int[][] map;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		// 1. 링크팀과 스타트팀을 고른다.
		// 2. 둘의 팀원들 능력치를 계산한다.
		// 3. 최솟값을 저장한다.
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		///////
		for(int i=1; i<=N/2; i++) {
			comb(0, 0, i, new boolean[N]);
		}
		System.out.println(answer);
		
		
	}
	private static void comb(int cnt, int start, int n, boolean[] selected) {
		if(cnt == n) {
			calcul(selected);
			return;
		}
		
		for(int i=start; i<N; i++) {
			selected[i] = true;
			comb(cnt+1, i+1, n, selected);
			selected[i] = false;
		}
	}
	private static void calcul(boolean[] s) {
		int link = 0;
		int start = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(s[i] && s[j])
					link += map[i][j];
				else if(!s[i] && !s[j])
					start += map[i][j];
			}
		}
		
		answer = Math.min(answer, Math.abs(link-start));
	}

}
