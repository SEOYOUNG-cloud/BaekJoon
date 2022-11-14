package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_2239_스도쿠 {

	static int[][] map;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		list = new ArrayList<>();

		for(int i=0; i<9; i++) {
			String line = br.readLine();
			for(int j=0; j<9; j++) {
				int in = line.charAt(j) - '0';
				map[i][j] = in;
				if(in == 0) {
					list.add(new int[] {i,j});
				}
			}
		}

		////////////
		size = list.size();
		dfs(0);


	}
	static int size;
	private static void dfs(int cnt) {
		if(cnt == size) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
			return;
		}

		int in[] = list.get(cnt);
		int x = in[0];
		int y = in[1];

		// 그 줄에 존재하지 않고 네모박스에 존재하지 않는 숫자를 넣는다.
		boolean visited[] = new boolean[10];
		//가로, 세로
		for(int i=0; i<9; i++) {
			visited[map[x][i]] = true;
			visited[map[i][y]] = true;
		}
		// 3x3 네모박스
		for(int i=x/3*3; i<(x/3*3)+3; i++) {
			for(int j=y/3*3; j<(y/3*3)+3; j++) {
				visited[map[i][j]] = true;
			}
		}
		// 뺀다.
		for(int i=1; i<10; i++) {
			if(!visited[i]) {
				int num = i;

				map[x][y] = num;

				dfs(cnt+1);
				map[x][y] = 0;
			}
		}

	}

}