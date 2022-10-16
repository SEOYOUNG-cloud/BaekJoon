package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_1952_달팽이2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[M][N];
		int all = M*N-1;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};

		int d= 0;
		int x = 0, y=0;
		map[x][y] = true;

		while(!(all == 0)) {
			int nx = x + dx[d%4];
			int ny = y + dy[d%4];

			if(nx < 0 || nx >= M || ny < 0 || ny >= N || map[nx][ny]) {
				d += 1;
				continue;
			}

			all -= 1;
			map[nx][ny] = true;

			x = nx;
			y = ny;

		}

		System.out.println(d);
	}

}
