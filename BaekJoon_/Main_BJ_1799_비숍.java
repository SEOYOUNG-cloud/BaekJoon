package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1799_비숍 {
	
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		ArrayList<int[]> list1 = new ArrayList<>();
		ArrayList<int[]> list2 = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int in = Integer.parseInt(st.nextToken());
				map[i][j] = in;
				if(in == 1) {
					if((i+j) %2 == 0)
						list1.add(new int[] {i,j});
					else
						list2.add(new int[] {i,j});
				}
			}
		}
		
		//////////
		dfs(0,0,list1, true);
		dfs(0,0,list2, false);
		System.out.println(answer1+answer2);
	}
	static int answer1 = Integer.MIN_VALUE;
	static int answer2 = Integer.MIN_VALUE;
	
	private static void dfs(int cnt, int total, ArrayList<int[]> list, boolean check) {
		for(int i=cnt; i<list.size(); i++) {
			int cur[] = list.get(i);
			// 비숍을 놓을 수 있으면 놓기
			if(canB(cur)) {
				int x = cur[0];
				int y = cur[1];
				
				map[x][y] = 2;
				dfs(i+1, total+1, list, check);
				map[x][y] = 1;
			}
		}
		
		if(check)
			answer1 = Math.max(answer1, total);
		else
			answer2 = Math.max(answer2, total);
	}
	private static boolean canB(int[] put) { // 비숍을 놓을 수 있는곳인지 체크
		int dx[] = {1,1,-1,-1};
		int dy[] = {1,-1,1,-1};
		int x = put[0];
		int y = put[1];
		
		while(true) {
			x += dx[0];
			y += dy[0];
			
			if(x >= N || x < 0 || y >= N || y < 0) break;
			if(map[x][y] == 2) return false;
		}
		
		x = put[0];
		y = put[1];
		
		while(true) {
			x += dx[1];
			y += dy[1];
			
			if(x >= N || x < 0 || y >= N || y < 0) break;
			if(map[x][y] == 2) return false;
		}
		
		x = put[0];
		y = put[1];
		
		while(true) {
			x += dx[2];
			y += dy[2];
			
			if(x >= N || x < 0 || y >= N || y < 0) break;
			if(map[x][y] == 2) return false;
		}
		
		x = put[0];
		y = put[1];
		
		while(true) {
			x += dx[3];
			y += dy[3];
			
			if(x >= N || x < 0 || y >= N || y < 0) break;
			if(map[x][y] == 2) return false;
		}
		
		return true;
		
	}

}
