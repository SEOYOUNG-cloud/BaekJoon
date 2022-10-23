package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_14889_스타트와링크 {
	
	static int N;
	static int[][] map;
	static int team[];
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		team = new int[N/2];
		
//		for(int i=0; i<N; i++)
//		System.out.println(Arrays.toString(map[i]));
		
		// nC4 - nC2 구해서 능력치 차이 구함 
		combination4(0,0);
		
		System.out.println(answer);
	}
	private static void combination4(int cnt, int start) {
		if(cnt == N/2) {
//			System.out.println(Arrays.toString(team));
			int[] team2 = new int[N/2];
			int idx = 0;
			A: for(int i=0; i<N; i++) {
				for(int j=0; j<N/2; j++) {
					if(team[j] == i) continue A;
				}
				team2[idx++] = i;
			}
			calc(team, team2);
			return;
		}
		
		for(int i=start; i<N; i++) {
			team[cnt] = i;
			combination4(cnt+1, i+1);
		}
	}

	private static void calc(int[] teamA, int[] teamB) {
//		System.out.println(Arrays.toString(teamA) + " " + Arrays.toString(teamB));
		int start = 0;
		int link = 0;
		
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				start += map[teamA[i]][teamA[j]];
				link += map[teamB[i]][teamB[j]];
				
			}
		}
		
//		System.out.println(start + " " + link);
		answer = Math.min(answer, Math.abs(start-link));
	}

}
