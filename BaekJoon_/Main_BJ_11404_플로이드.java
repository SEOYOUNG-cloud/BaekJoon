package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_11404_플로이드 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int city = Integer.parseInt(br.readLine());
		int bus = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int INF = 100000000;
		
		int[][] map = new int[city+1][city+1];
		for(int i=0; i<city+1; i++)
			for(int j=0; j<city+1; j++) {
				if(i==j) map[i][j] = 0;
				else map[i][j] = INF;
			}
		
		for(int i=0; i<bus; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map[a][b] = Math.min(map[a][b], w);
		}
		
		for(int k=1; k<=city; k++)
			for(int i=1; i<=city; i++)
				for(int j=1; j<=city; j++)
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=city; i++) {
			for(int j=1; j<=city; j++) {
				if(map[i][j] == INF) sb.append("0").append(" "); // 갈 수 없는 곳은 0 출력하기
				else sb.append(map[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());

	}

}
