package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_달팽이숫자_박서영 {
	static int map[][];
	//오 아래 왼 위 순서
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static int n, num=1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("./input (4).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());

		
		for(int tc = 1; tc <= test_case; tc++) {
			n = Integer.parseInt(br.readLine());

			map = new int[n][n];
			num = 1;
			
			map[0][0] = 1;
			turn(0,0);
			
			System.out.print("#" + tc + " ");
			for(int i = 0; i < n; i++) {
				System.out.println();
				for(int j = 0; j < n; j++)
					System.out.print(map[i][j] + " ");
			}
			
			System.out.println();
			
		}

	}
	public static void turn(int x, int y) {
		while(num < n*n) {
			for(int i = 0; i < 4; i++) {
				while(true) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] != 0) break;
					num++;
					map[nx][ny] = num;
					x = nx;
					y = ny;
				}
			}
		}
	}
}
