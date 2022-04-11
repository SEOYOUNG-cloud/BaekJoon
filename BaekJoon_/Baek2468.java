package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Baek2468 {
	public static int[][] map = new int[100][100];
	public static int[][] map_clone = new int[100][100]; // map에서 안전영역은 1, 아닌곳은 0을 넣은 배열
	public static int[] count = new int[100];
	public static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N]; // map 배열 초기화
		map_clone = new int[N][N];
		
		int max = 0;
		for(int i = 0; i < N; i++) { // 입력된 값 map 배열에 넣고 안전영역 max 높이 찾아놓기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] >= max) max = map[i][j];
			}
		}
		
		
		int index = 0;
		for(int i = 0; i < max + 1; i++) { // 제일 높은곳까지만 넣어서 확인
			
			//map_clone 초기화
			for(int j = 0; j < N; j++)
				for(int k = 0; k < N; k++)
					if(map[j][k] >= i) map_clone[j][k] = 1;
					else map_clone[j][k] = 0;
			
			//안전 영역 계산값 count[] 배열에 넣기
			for(int j = 0; j < N; j++)
				for(int k = 0; k < N; k++)
					if(safe_dfs(j, k)) {
						count[index]++;
					}
			index++;
		}
		
		Arrays.sort(count);
		
		System.out.println(count[99]); // 오름차순이므로 가장 뒤에있는 값 = 제일 큰 값 출력
		
		
		
	}
	
	public static boolean safe_dfs(int x, int y) {
		int dx[] = {1, -1, 0, 0};
		int dy[] = {0, 0, 1, -1};
		
		if(x <= -1 || x >= N || y <= -1 || y >= N) return false;
		if(map_clone[x][y] == 1) {
			map_clone[x][y] = 0;
			
			for(int i = 0; i < 4; i++) 
				safe_dfs(x + dx[i], y + dy[i]);
			
			return true;
		}
		
		
		return false;
	}

}
