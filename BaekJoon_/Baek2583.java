package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Baek2583 { // DFS
	public static ArrayList<Integer> count = new ArrayList<Integer>();
	public static int map[][];
	public static int M, N, K, Allcount = 0, index = 0;
	public static int dx[] = {1, -1, 0, 0};
	public static int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		int in[] = new int[4];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			in[0] = Integer.parseInt(st.nextToken());
			in[1] = Integer.parseInt(st.nextToken());
			in[2] = Integer.parseInt(st.nextToken());
			in[3] = Integer.parseInt(st.nextToken());
			
			for(int x = in[0]; x < in[2]; x++)
				for(int y = in[1]; y < in[3]; y++)
					map[x][y] = 1;
		}
		
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(map[i][j] == 0) {
					index++;
					dfs(i, j);
					count.add(Allcount, index);
					Allcount++;
					index = 0;
				}
		
		Collections.sort(count);
		System.out.println(Allcount + " ");
		for(int i = 0; i < count.size(); i++)
			System.out.print(count.get(i) + " ");
		
	}
	
	public static void dfs(int x, int y) {
		map[x][y] = 1;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx <= -1 || nx >= N || ny <= -1 || ny >= M) continue;
			if(map[nx][ny] == 0) {
				dfs(nx, ny);
				index++;
			}
		}
	}

}
