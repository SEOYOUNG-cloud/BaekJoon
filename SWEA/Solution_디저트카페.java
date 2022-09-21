package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 디저트카페 {

	static int N;
	static int[][] map;
	static int answer;
	static int rx, ry;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
//		System.setIn(new FileInputStream("res/input_디저트.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			answer = Integer.MIN_VALUE;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 입력 끝 // 
			
			// for문으로 시작점 구하기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					HashSet<Integer> set = new HashSet<>();
					set.add(map[i][j]);
					rx = i;
					ry = j;
					dfs(i,j,0,set,1);
				}
			}
		
			
			if(answer < 3) answer = -1;
			sb.append("#").append(tc).append(" ").append(answer).append('\n');
		}
		System.out.println(sb.toString());
		

	}
	static int[] dx = {1, 1, -1,-1};
	static int[] dy = {1, -1, -1, 1};
	public static void dfs(int x, int y, int d, HashSet<Integer> set, int cnt) {
 		for(int i = d ; i <4;i++) {
			
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx==rx && ny == ry) answer = Math.max(answer, cnt);
			
			
			if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
			if(set.contains(map[nx][ny])) continue;
			
			
			set.add(map[nx][ny]);
			dfs(nx,ny,i,set,cnt+1);
			set.remove(map[nx][ny]);
			
			
			
		}
	}

}
