package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek17406 {
	static int map[][], result[][], tmp_map[][];
	static int N,M,K;
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static boolean isSelected[];
	static int order[];
	static int turn_arr[][];
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// map 배열 만들고 입력받기
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		// result 배열 만들기
		result = new int[N][M];
		for(int i = 0; i < N; i++)
			System.arraycopy(map[i], 0, result[i], 0, M);
		// 중간맵도 만듦
		tmp_map = new int[N][M];
		for(int i = 0; i < N; i++)
			System.arraycopy(map[i], 0, tmp_map[i], 0, M);

		
		// turn하는거 입력받음
		turn_arr = new int[K][3];
		for(int i = 0; i < K; i++) {
			st= new StringTokenizer(br.readLine());
			
			turn_arr[i][0] = Integer.parseInt(st.nextToken());
			turn_arr[i][1] = Integer.parseInt(st.nextToken());
			turn_arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		isSelected = new boolean[K];
		order = new int[K];
		Perm(0);
	
		System.out.println(answer);
		
		
	}
	private static void Turn(int r, int c, int s) {
		int round = 2*s / 2 + 2*s % 2;

		for(int in = 0; in < round; in++) {
			int i = r-s-1 + in;
			int j = c-s-1 + in;
				for(int d = 0; d < 4; d++) {
					int length = 2*s - 2*in;
					while(length --> 0) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						result[nx][ny] = tmp_map[i][j];
						i = nx;
						j = ny;
					}
				}
				
				for(int index = 0; index < N; index++)
					System.arraycopy(result[index], 0, tmp_map[index], 0, M);
		}
		
	}
	public static void Perm(int cnt) {
		if(cnt == K) {
			for(int i = 0; i < K; i++) {
				Turn(turn_arr[order[i]][0], turn_arr[order[i]][1], turn_arr[order[i]][2]);
			}
			
		// 계산하는곳으로 보내기
		Find_min();
		
		// 초기화
		for(int i = 0; i < N; i++)
			System.arraycopy(map[i], 0, tmp_map[i], 0, M);
		for(int i = 0; i < N; i++)
			System.arraycopy(map[i], 0, result[i], 0, M);
		
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(isSelected[i]) continue;
			
			order[cnt] = i;
			isSelected[i] = true;
			Perm(cnt+1);
			isSelected[i] = false;
		}
		
	}
	
	public static void Find_min() {
		int min = Integer.MAX_VALUE; // 최솟값
		int total = 0; // 한 줄 합
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				total += result[i][j];
			}
			if(total < min)
				min = total;
			total = 0;
		}
		answer = Math.min(answer, min);
				
	}

}
