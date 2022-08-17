package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_요리사_박서영 {
	static int N, min = Integer.MAX_VALUE;
	static int map[][];
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/input_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			
			for(int i=0; i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			combintation(0,0);
			sb.append("#" + tc + " " + min + "\n");			
		}
		System.out.println(sb);
	}
	private static void combintation(int cnt, int start) {
		if(cnt == N/2) {
			calcul();
			return;
		}
		for(int i=start; i<N; i++) {
			visited[i] = true;
			combintation(cnt+1, i+1);
			visited[i] = false;
		}
	}

	private static void calcul() {
		int a=0, b=0;
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(visited[i] && visited[j])
					a += map[i][j] + map[j][i];
				else if(!visited[i] && !visited[j])
					b += map[i][j] + map[j][i];
			}
		}
		min = Math.min(min, Math.abs(a-b));
		return;
	}

}
