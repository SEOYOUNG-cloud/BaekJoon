package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1932_정수삼각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<N; i++)
			list.add(new ArrayList<>());
		
		int[][] map = new int[N][N];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=i+1; j++) {
				int in = Integer.parseInt(st.nextToken());
				list.get(i).add(in);
			}
		}
		map[0][0] = list.get(0).get(0);
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<i+1; j++) {
				int up = map[i][j];
				int down1 = list.get(i+1).get(j) + up;
				int down2 = list.get(i+1).get(j+1) + up;
				
				map[i+1][j] = Math.max(map[i+1][j], down1);
				map[i+1][j+1] = Math.max(map[i+1][j+1], down2);
			}
		}
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			answer = Math.max(answer, map[N-1][i]);
		}
		
		System.out.println(answer);
	}

}
