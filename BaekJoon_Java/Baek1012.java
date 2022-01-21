package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baek1012 { // DFS
	public static int count[] = new int[1250];
	public static int farm[][] = new int[50][50];
	public static int M = 0, N = 0, K = 0;
	public static int index = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				M = Integer.parseInt(st.nextToken());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				farm[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;	
			}
			
			for(int x = 0; x < M; x++)
				for(int y = 0; y < N; y++) {
					if(worm_DFS(x, y))
						count[index]++;
				}
			
			index++;
		}
		
		for(int i = 0; i < count.length; i++) {
			if(count[i] != 0)
				System.out.println(count[i]);
			else {
				break;
			}
		}
	}
	
	public static boolean worm_DFS(int x, int y) {
		
		if(x <= -1 || y <= -1 || x >= M || y >= N)
			return false;
		
		if(farm[x][y] == 1) {
			farm[x][y] = 0;
			
			//상하좌우 잘펴보기
			worm_DFS(x - 1, y);
			worm_DFS(x + 1, y);
			worm_DFS(x, y + 1);
			worm_DFS(x, y - 1);
			
			return true;
		}
		
		return false;
	}
}
