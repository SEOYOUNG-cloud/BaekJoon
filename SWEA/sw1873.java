package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873 {
	static char map[][];
	static int tank_x = 0, tank_y = 0; // 탱크 자리
	static int H, W;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("./input (6).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			
			for(int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int input_num = Integer.parseInt(br.readLine());
			char command[] = br.readLine().toCharArray();
			
			find_tank(); // 탱크 찾았어
			
			for(int input = 0; input < input_num; input++) {
				switch (command[input]) {
				case 'U':
					input_U();
					break;
				case 'D':
					input_D();	
					break;
				case 'L':
					input_L();	
					break;
				case 'R':
					input_R();
					break;
				case 'S':
					input_S();
					break;
				}
						
			}
			
			System.out.print("#" + tc + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++)
					System.out.print(map[i][j]);
				System.out.println();
			}

		}
		
	}
	public static void find_tank() {
		for(int i = 0; i < H; i++)
			for(int j = 0; j < W; j++)
				if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '^') {
					tank_x = i;
					tank_y = j;
					return;
				}
	}
	
	public static void input_U() {
		if(tank_x-1 >= 0 && map[tank_x-1][tank_y] == '.') {
			map[tank_x][tank_y] = '.';
			map[tank_x-1][tank_y] = '^';
			tank_x -= 1;
		}
		else
			map[tank_x][tank_y] = '^';
	}
	public static void input_D() {
		if(tank_x+1 < H && map[tank_x+1][tank_y] == '.') {
			map[tank_x][tank_y] = '.';
			map[tank_x+1][tank_y] = 'v';
			tank_x += 1;
		}
		else
			map[tank_x][tank_y] = 'v';
			
	}
	public static void input_L() {
		if(tank_y-1 >= 0 && map[tank_x][tank_y-1] == '.') {
			map[tank_x][tank_y] = '.';
			map[tank_x][tank_y-1] = '<';
			tank_y -= 1;
		}
		else
			map[tank_x][tank_y] = '<';
	}
	public static void input_R() {
		if(tank_y+1 < W && map[tank_x][tank_y+1] == '.') {
			map[tank_x][tank_y] = '.';
			map[tank_x][tank_y+1] = '>';
			tank_y += 1;
		}
		else
			map[tank_x][tank_y] = '>';
		
	}
	public static void input_S() {
		switch(map[tank_x][tank_y]) {
		case '^':
			if(tank_x-1 < 0) break;
			for(int i = tank_x-1; i >= 0; i--) {
				if(map[i][tank_y] == '*') {
					map[i][tank_y] = '.';
					break;
				} else if(map[i][tank_y] == '#')
					break;
			}
			break;
		case 'v':
			if(tank_x+1 >= H) break;
			for(int i = tank_x+1; i < H; i++) {
				if(map[i][tank_y] == '*') {
					map[i][tank_y] = '.';
					break;
				} else if(map[i][tank_y] == '#') {
					break;
				}
			}
			break;
		case '<':
			if(tank_y-1 < 0) break;
			for(int i = tank_y-1; i >= 0; i--) {
				if(map[tank_x][i] == '*') {
					map[tank_x][i] = '.';
					break;
				} else if(map[tank_x][i] == '#')
					break;
			}
			break;
		case '>':
			if(tank_y+1 >= W) break;
			for(int i = tank_y+1; i < W; i++) {
				if(map[tank_x][i] == '*') {
					map[tank_x][i] = '.';
					break;
				} else if(map[tank_x][i] == '#')
					break;
			}
			break;
			
		}

		
	}

}
