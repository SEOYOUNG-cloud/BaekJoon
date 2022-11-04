package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_14503_로봇청소기 {
	
	static int N,M;
	static int dir;
	static int rx, ry;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		rx = Integer.parseInt(st.nextToken());
		ry = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//// 입력 끝 ////
		cleaning(rx, ry, dir);
		System.out.println(answer);
	}
	static int answer = 0;
	private static void cleaning(int x, int y, int direction) {
		//1. 현재 위치 청소
		if(map[x][y] == 0) {
			map[x][y] = 2;
			answer+=1;
		}
		
		boolean check = false;
		//2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 탐색 진행
		for(int d=0; d<4; d++) {
			int dir = (direction+3)%4; // 왼쪽 방향
			int nx = x+dx[dir]; // 왼쪽 한칸 직진
			int ny = y+dy[dir]; // 왼쪽 한칸 직진
			
			// 2-1. 왼쪽 방향에 청소하지 않는 공간이 있다면
			if(map[nx][ny] == 0) {
				// 그 방향을 회전하고 한칸 전진
				cleaning(nx, ny, dir);
				check = true;
				
				return;
			}
			
			direction = dir;
			
		}

			
		// 2-3. 네 방향 모두 청소가 이미 되어있거나 벽이라면
		if(!check) {
			// 바라보는 방향을 유지한 채로 한 칸 후진
			int back = (direction + 2) % 4;
			int bx = x + dx[back];
			int by = y + dy[back];
			
			if(map[bx][by] != 1) {
				cleaning(bx, by, direction);
			}
			
		}
	}
}
