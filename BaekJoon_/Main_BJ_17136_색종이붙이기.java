package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_17136_색종이붙이기 {
	
	static int[][] map;
	static int paper = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[10][10];
		
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				int in = Integer.parseInt(st.nextToken());
				if(in == 1) paper += 1;
				map[i][j] = in;
			}
		}
		
		dfs(0,0,0,0,0,0,0);
		if(answer ==  Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}
	static int answer = Integer.MAX_VALUE;
	private static void dfs(int one, int two, int three, int four, int five, int p, int x) {
		if(one > 5 || two > 5 || three > 5 || four > 5 || five > 5) {
			return;
		}
		if(one+two+three+four+five > answer) {
			return;
		}
		if(p == paper) {
			answer = Math.min(answer, one+two+three+four+five);
			return;
		}
		
		for(int i=x; i<10; i++) {
			for(int j=0; j<10; j++) {
				// 1. 1이고 방문하지 않았다면 
				
				// 1-1. 1x1이 되는지 확인
				if(map[i][j] == 1) {
				map[i][j] = 0;
					dfs(one+1, two, three, four, five, p+1, i);
					map[i][j] = 1;
				}
				// 1-2. 2x2가 되는지 확인
				if(map[i][j] == 1 && conf(i, j, 2)) {
					// 이미 방문처리는 했으므로 dfs 돌리고 다시 백트래킹
					
					dfs(one, two+1, three, four, five, p+4, i);
					back(i,j,2);
				}
				// 1-3. 3x3 되는지 확인 
				if(map[i][j] == 1 && conf(i, j, 3)) {
					// 이미 방문처리는 했으므로 dfs 돌리고 다시 백트래킹
					
					dfs(one, two, three+1, four, five, p+9, i);
					back(i,j,3);
				}
				// 1-4. 4x4 되는지 확인 
				if(map[i][j] == 1 && conf(i, j, 4)) {
					// 이미 방문처리는 했으므로 dfs 돌리고 다시 백트래킹
					
					dfs(one, two, three, four+1, five, p+16, i);
					back(i,j,4);
				}
				// 1-5. 5x5 되는지 확인 
				if(map[i][j] == 1 && conf( i, j, 5)) {
					// 이미 방문처리는 했으므로 dfs 돌리고 다시 백트래킹
					
					dfs(one, two, three, four, five+1, p+25, i);
					back(i,j,5);
					
				}
				if(map[i][j] == 1) return;
			}
		}
	}
	private static boolean conf(int x, int y, int n) {
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(i >= 10 || j >= 10) return false;
				// 방문한 곳이라면 끝
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		// 내려왔으면 방문할 수 있는곳임 
		// visited 처리한다.
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(i >= 10 || j >= 10) return false;
				map[i][j] = 0;
			}
		}
		
		return true;
	}
	private static void back(int x, int y, int n) {
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				map[i][j] = 1;
			}
		}
	}

}
