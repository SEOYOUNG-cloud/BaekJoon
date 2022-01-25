package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baek10026 {
	public static int N = 0;
	public static int dx[] = {1, -1, 0, 0};
	public static int dy[] = {0, 0, 1, -1};
	public static String pic[][];
	public static String pic_cb[][]; // color blindness
	public static boolean visited[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		pic = new String[N][N];
		pic_cb = new String[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String in = br.readLine();
			for(int j = 0; j < N; j++)
				pic[i][j] = String.valueOf(in.charAt(j));
		}
				
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) {
				if(pic[i][j].equals("G"))
					pic_cb[i][j] = "R";
				else {
					pic_cb[i][j] = pic[i][j];
				}
			}
		
		
		int count = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) 
				if(!visited[i][j]) {
					area_dfs(i, j, pic);
					count++;
				}
		
		visited = new boolean[N][N];
		
		int count_cb = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) 
				if(!visited[i][j]) {
					area_dfs(i, j, pic_cb);
					count_cb++;
				}
			
		System.out.println(count + " " + count_cb);
	}
	
	public static void area_dfs(int x, int y, String pic[][]) {
		visited[x][y] = true;
		String tmp = pic[x][y];
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx <= -1 || nx >= N || ny <= -1 || ny >= N) continue;
			
			if(!visited[nx][ny] && pic[nx][ny].equals(tmp))
				area_dfs(nx, ny, pic);
		}
		
	}

}
