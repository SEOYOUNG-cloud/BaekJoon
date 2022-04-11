package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baek4963 {
	public static int w = 0, h = 0;
	public static int count[] = new int[2500]; // 섬의 개수
	public static int map[][] = new int[50][50];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int index = 0;
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w]; // 지도 초기화
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < w; j++) 
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(Land_dfs(i, j)) {
						count[index]++;
					}
				}
			}
			index++;
			
			
		}	
			
			for(int i = 0; i < index; i++)
				System.out.println(count[i]);
		
	}
	
	public static boolean Land_dfs(int x, int y) {
		int dx[] = {1, -1, 0, 0, 1, 1, -1, -1};
		int dy[] = {0, 0, 1, -1, 1, -1, 1, -1};
		
		if(x <= -1 || x >= h || y <= -1 || y >= w) return false;
		if(map[x][y] == 1) {
			
			map[x][y] = 0;
			
			for(int i = 0; i < 8; i++) {
				Land_dfs(x + dx[i], y + dy[i]);
			}
			
			return true;
		}
		
		return false;
		
	}
	
}
