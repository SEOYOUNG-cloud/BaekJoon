package Baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_17144_미세먼지안녕_박서영2 {

	static int R, C; // map의 가로, 세로
	static int[][] map;
	static int aircleaner1, aircleaner2; // 공기청정기 1이 위쪽, 2가 아래쪽
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken()); // T초 후 방에 남은 미세먼지 출력해야함
		
		map = new int[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				int in = Integer.parseInt(st.nextToken());
				map[i][j] = in;
				if(in == -1)
					aircleaner2 = i;
			}
		}
		aircleaner1 = aircleaner2-1;
		
		// 입력 끝 // 

		while(T-->0) {
			spread();
			airClean();
		}
		
		int answer = 0;
		for(int i=0; i<R; i++)
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) answer += map[i][j];
			}
		
		System.out.println(answer);		
//		airClean();
//		
		for(int i=0; i<R;i++)
			System.out.println(Arrays.toString(map[i]));

	}
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	
	// 1. 미세먼지 확산 메소드
	private static void spread() {
		int map_clone[][] = new int[R][C];
		
		for(int x=0; x<R; x++) {
			for(int y=0; y<C; y++) {
				if(map[x][y] > 0) {
					int cnt = 0; // 먼지 개수
					// 먼지 만나면 4방 탐색
					for(int d=0; d<4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						
						if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1) continue;
						cnt+=1;
						map_clone[nx][ny] += map[x][y] / 5;
						
					}
					map_clone[x][y] += map[x][y] - (map[x][y]/5) * cnt;
				}
			}
		}
		
		for(int i=0; i<R; i++)
			map[i] = map_clone[i].clone();
	}
	
	// 2. 공기청정기 가동 메소드
	private static void airClean() {
		clockwise();
		counterclockwise();
		
	}
	
	// 2-1. 시계 방향으로 회전 : (0,0) ~ (aircleaner1, C-1)
	// 아래 -> 위 <-
	private static void clockwise() {
		int dxr[] = {0,1,0,-1};
		int dyr[] = {1,0,-1,0};
		
		int x = 0, y = 0;
		for(int d=0; d<4; d++) {
			while(true) {
				int nx = x + dxr[d];
				int ny = y + dyr[d];
				
				if(nx < 0 || nx > aircleaner1 || ny < 0 || ny >= C) break;
				map[x][y] = map[nx][ny];
				x = nx;
				y = ny;
			}
		}
		map[aircleaner1][0] = -1;
		map[aircleaner1][1] = 0;
		
	}
	

	// 2-2. 반시계 방향으로 회전 : (aircleaner2, 0) ~ (R-1, C-1)
	// -> 아래 <- 위
	
	private static void counterclockwise() {
		int dxr[] = {1,0,-1,0};
		int dyr[] = {0,1,0,-1};
		
		int x = aircleaner2, y = 0;
		for(int d=0; d<4; d++) {
			while(true) {
				int nx = x + dxr[d];
				int ny = y + dyr[d];
				
				if(nx < aircleaner2 || nx >= R || ny < 0 || ny >= C) break;
				map[x][y] = map[nx][ny];
				x = nx;
				y = ny;
			}
		}
		map[aircleaner2][0] = -1;
		map[aircleaner2][1] = 0;
	}

}
