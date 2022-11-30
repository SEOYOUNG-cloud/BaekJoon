package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1956_운동 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[V+1][V+1];
		int INF = 5000000;
		
		for(int i=0; i<=V; i++) {
			for(int j=0; j<=V; j++) {
				if(i==j) map[i][j] = 0;
				else map[i][j] = INF;
			}
		}
		
		for(int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map[a][b] = w;
		}
		for(int k=1; k<=V; k++)
			for(int i=1; i<=V; i++)
				for(int j=1; j<=V; j++)
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
		
		
		// map[a][b] != INF && map[b][a] != INF라면 사이클 발생 O
		int answer = Integer.MAX_VALUE;
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(i != j && (map[i][j] != INF && map[j][i] != INF)) {
					answer = Math.min(answer, map[i][j] + map[j][i]);
				}
			}
		}
		
		if(answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);

	}

}
