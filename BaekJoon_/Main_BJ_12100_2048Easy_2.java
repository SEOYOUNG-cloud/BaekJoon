package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_12100_2048Easy_2 {
	
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/***/
		dfs(0);
		System.out.println(answer);
	}
	static int answer = 0;
	private static void dfs(int cnt) {
		if(cnt == 5) {
			int max = 0;
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					max = Math.max(map[i][j], max);
			
			answer = Math.max(max, answer);
			return;
		}
		
        int copy[][] = new int[N][N];
        for(int i = 0; i < N; i++)
            copy[i] = map[i].clone();
        
        for(int i=0; i<4; i++) {
        	switch (i) {
			case 0:
				up();
				break;
			case 1:
				down();
				break;
			case 2:
				left();
				break;
			case 3:
				right();
				break;
			default:
				break;
			}
        	
        	dfs(cnt+1);
            for(int c = 0; c < N; c++)
                map[c] = copy[c].clone();
        }
		
	}
	
	private static void up() {
		int nmap[][] = new int[N][N];
		
		for(int y=0; y<N; y++) {
			int nx=0;
			int block = 0;
			for(int x=0; x<N; x++) {
				if(map[x][y] != 0) {
					if(block == 0) {
						block = map[x][y];
					} else if(map[x][y] == block) {
						nmap[nx++][y] = block*2;
						block = 0;
					} else {
						nmap[nx++][y] = block;
						block = map[x][y];
					}
				}
			}
			if(block != 0) {
				nmap[nx++][y] = block;
			}
		}
		
		for(int i=0; i<N; i++) {
			map[i] = nmap[i].clone();
		}
	}
	private static void down() {
		int nmap[][] = new int[N][N];
		
		for(int y=0; y<N; y++) {
			int nx=N-1;
			int block = 0;
			for(int x=N-1; x>=0; x--) {
				if(map[x][y] != 0) {
					if(block == 0) {
						block = map[x][y];
					}
					else if(map[x][y] == block) {
						nmap[nx--][y] = block * 2;
						block = 0;
					} else {
						nmap[nx--][y] = block;
						block = map[x][y];
					}
				}
			}
			if(block != 0) {
				nmap[nx--][y] = block;
			}
		}
		
		for(int i=0; i<N; i++) {
			map[i] = nmap[i].clone();
		}
	}
	
	private static void right() {
		int nmap[][] = new int[N][N];
		
		for(int x=0; x<N; x++) {
			int ny=N-1;
			int block = 0;
			for(int y=N-1; y>=0; y--) {
				if(map[x][y] != 0) {
					if(block == 0) {
						block = map[x][y];
					}
					else if(map[x][y] == block) {
						nmap[x][ny--] = block * 2;
						block = 0;
					} else {
						nmap[x][ny--] = block;
						block = map[x][y];
					}
				}
			}
			if(block != 0) {
				nmap[x][ny--] = block;
			}
		}
		
		for(int i=0; i<N; i++) {
			map[i] = nmap[i].clone();
		}
	}
	
	private static void left() {
		int nmap[][] = new int[N][N];
		
		for(int x=0; x<N; x++) {
			int ny=0;
			int block = 0;
			for(int y=0; y<N; y++) {
				if(map[x][y] != 0) {
					if(block == 0) {
						block = map[x][y];
					} else if(map[x][y] == block) {
						nmap[x][ny++] = block*2;
						block = 0;
					} else {
						nmap[x][ny++] = block;
						block = map[x][y];
					}
				}
			}
			if(block != 0) {
				nmap[x][ny++] = block;
			}
		}
		
		for(int i=0; i<N; i++) {
			map[i] = nmap[i].clone();
		}
	}
}
