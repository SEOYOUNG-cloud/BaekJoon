package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1_박서영 {
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static int N,M,R;
	static int map[][];
	static int Visited[][];
	static LinkedList<Integer> list = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		Visited = new int[N][M];
		
		// map 입력받기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		
		int round;
		if(Math.min(N, M) % 2 == 0)
			round = Math.min(N, M)/2;
		else
			round =  Math.min(N, M)/2 + 1;
		
		for(int i = 0; i < round; i++) {
			list.add(map[i][i]);
			Read(i,i);
			Write(i,i);
		}
		
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				System.out.print(Visited[i][j] + " ");
			System.out.println();
		}
		

	}
	public static void Read(int x, int y) {
		int nx = x;
		int ny = y;
		for(int i = 0; i < 4; i++) {
			while(true) {
				if(x + dx[i] < 0 || x + dx[i] >= N || y + dy[i] < 0 || y + dy[i] >= M 
						|| (x+dx[i]==ny && y+dy[i]==y) || map[x+dx[i]][y+dy[i]] == 0) {
					break;
				}
				x = x + dx[i];
				y = y + dy[i];
				
				list.add(map[x][y]);
				map[x][y] = 0;
			}
		}
		
	}
	
	public static void Write(int x, int y) {
		int index = R;
		while(index >= list.size()) index -= list.size();
		Visited[x][y] = list.get(index);
		
		list.remove(index);
		
		
		for(int i = 0; i < 4; i++) {
			while(!list.isEmpty()) {
				if(x + dx[i] < 0 || x + dx[i] >= N || y + dy[i] < 0 || y + dy[i] >= M || Visited[x+dx[i]][y+dy[i]] != 0) {
					break;
				}
				x = x + dx[i];
				y = y + dy[i];
				
				if(index >= list.size()) index = 0;
				Visited[x][y] = list.get(index);
				list.remove(index);
				if(index >= list.size()) index = 0;

			}
		}
	}

}
