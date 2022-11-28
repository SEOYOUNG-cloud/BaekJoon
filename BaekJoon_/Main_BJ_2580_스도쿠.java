package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_2580_스도쿠 {
	
	static int[][] map;
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[9][9];
		
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				int in = Integer.parseInt(st.nextToken());
				map[i][j] = in;
				if(in == 0) {
					list.add(new int[] {i,j});
				}
			}
		}
		
		// 입력 끝 //
		backtracking(0);

	}
	private static void backtracking(int cnt) {
		if(cnt == list.size()) {
			StringBuilder sb = new StringBuilder();
	        for(int i=0; i<9; i++) {
	            for(int j=0; j<9; j++) {
	                sb.append(map[i][j]).append(" ");
	            }
	            sb.append("\n");
	        }
	        System.out.print(sb.toString());
			System.exit(0);
			return;
		}
		
		int out[] = list.get(cnt);
		int x = out[0];
		int y = out[1];
		
		boolean[] conf = new boolean[10];
		
		
		for(int l=0; l<9; l++) {
			conf[map[x][l]] = true; // 1. 가로줄 확인
			conf[map[l][y]] = true; // 2. 세로줄 확인
		}
		// 3. 네모 확인
		for(int lx=x/3*3; lx<=x/3*3+2; lx++) {
			for(int ly=y/3*3; ly<=y/3*3+2; ly++) {
				conf[map[lx][ly]] = true;
			}
		}
		
		// 4. 넣었다가..뺐다가..
		for(int in=1; in<=9; in++) {
			if(!conf[in]) {
				map[x][y] = in;
				backtracking(cnt+1);
				map[x][y] = 0;
			}
		}
	}
}
