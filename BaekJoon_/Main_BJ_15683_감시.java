package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_15683_감시_박서영 {
	
	static int N,M,CCTV_cnt;
	static int map[][], cctv_index_perm[], clone_map[][];
	static ArrayList<int[]> CCTV_xy = new ArrayList<>();
	static ArrayList<Integer> cctv_num = new ArrayList<>(); // cctv 번호 저장
	static int cctv_dir_num[] = {0,4,2,4,4,1};
	static int dx[] = {0,-1,0,1,0};
	static int dy[] = {0,0,1,0,-1};
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int in = Integer.parseInt(st.nextToken());
				map[i][j] = in;
				if(in != 0 && in != 6) {
					CCTV_xy.add(new int[] {i,j}); // CCTV 위치 배열로 넣어놓음
					cctv_num.add(in); // CCTV 번호
					
				}
			}
		}
		/// 입력 끝 ///
		
		CCTV_cnt = CCTV_xy.size(); // CCTV 개수
		cctv_index_perm = new int[CCTV_cnt];
		
		CCTV_perm(0);

		
		System.out.println(answer);
		

	}
	// 1. CCTV 순열 구하기
	private static void CCTV_perm(int cnt) {
		if(cnt == CCTV_cnt) {
			CCTV_num_dir(); // 보내보내보내
			return;
		}
		
		for(int i=0; i < cctv_dir_num[cctv_num.get(cnt)]; i++) {
			cctv_index_perm[cnt] = i;
			CCTV_perm(cnt+1);
		}
	}
	
	// 2. CCTV 번호에 따라 방향 번호 알려주는 함수
	private static void CCTV_num_dir() {	
		
		clone_map = new int[N][M];
		for(int a=0; a<N; a++)
				System.arraycopy(map[a], 0, clone_map[a], 0, M);
		
		// cctv_index_perm에서 cctv 번호에 따라...
		for(int i=0; i<CCTV_cnt; i++) {
	
			int x = CCTV_xy.get(i)[0];
			int y = CCTV_xy.get(i)[1];
		
			switch(cctv_num.get(i)) {
			case 1:
				switch(cctv_index_perm[i]) {
				case 0:
					dir(x,y,1);
					break;
				case 1:
					dir(x,y,2);
					break;
				case 2:
					dir(x,y,3);
					break;
				case 3:
					dir(x,y,4);
					break;
				}
				break;
			
			
			case 2:
				switch(cctv_index_perm[i]) {
				case 0:
					dir(x,y,1);dir(x,y,3);
					break;
				case 1:
					dir(x,y,2);dir(x,y,4);
					break;
				}
				break;
			
			case 3:
				switch(cctv_index_perm[i]) {
				case 0:
					dir(x,y,1);dir(x,y,2);
					break;
				case 1:
					dir(x,y,2);dir(x,y,3);
					break;
				case 2:
					dir(x,y,3);dir(x,y,4);
					break;
				case 3:
					dir(x,y,1);dir(x,y,4);
					break;
				}
				break;
			
			case 4:
				switch(cctv_index_perm[i]) {
				case 0:
					dir(x,y,1);dir(x,y,2);dir(x,y,4);
					break;
				case 1:
					dir(x,y,1);dir(x,y,3);dir(x,y,4);
					break;
				case 2:
					dir(x,y,2);dir(x,y,3);dir(x,y,4);
					break;
				case 3:
					dir(x,y,1);dir(x,y,2);dir(x,y,3);
					break;
				}
				break;
			case 5:
				dir(x,y,1);dir(x,y,2);dir(x,y,3);dir(x,y,4);
				break;
			}
			
		}
		// 맵에 있는 0의 개수 세기
		Count_Zero();	

	}
	// 방향마다 cctv가 감시하는 부분에 표시하기
	private static void dir(int x, int y, int dir) {
		while(true) {
			x += dx[dir];
			y += dy[dir];
			
			if(x < 0 || x >= N || y < 0 || y >= M || clone_map[x][y] == 6) break;
			clone_map[x][y] = -1;
		}
			
	}
	private static void Count_Zero() {
		int count = 0;
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				if(clone_map[i][j] == 0)
					count += 1;
		
		if(count < answer) answer = count;
	}
	
}
