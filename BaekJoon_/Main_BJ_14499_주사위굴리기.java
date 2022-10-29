package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_14499_주사위굴리기 {

	static int N,M,x,y,K;
	static int[][] map;
	static int[] dice = new int[6]; // 위 아래 왼 오 앞 뒤 
	static int[] direct;
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 가로 
		M = Integer.parseInt(st.nextToken()); // 세로 
		x = Integer.parseInt(st.nextToken()); // 주사위 좌표 x
		y = Integer.parseInt(st.nextToken()); // 주사위 좌표 y
		K = Integer.parseInt(st.nextToken()); // 명령 개수 K
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		direct = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int d = Integer.parseInt(st.nextToken());
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			// 범위 넘어가면 출력도하지마 
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}
			
			moveDice(d);
			
			
			// 이동한 칸에 쓰여 있는 수가 0이면 주사위 바닥면에 쓰여 있는 수 칸에 복사 
			if(map[nx][ny] == 0) {
				int bottom = dice[1];
				map[nx][ny] = bottom;
				
			} else { // 바닥에 쓰인 수가 주사위에 복사됨 
				int mapBottom = map[nx][ny];
				dice[1] = mapBottom;
				map[nx][ny] = 0;
			}
			
			x = nx;
			y = ny;
			sb.append(dice[0]).append('\n');
		}
		
		
//		System.out.println(Arrays.deepToString(map));
		System.out.println(sb.toString());

		
	}
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	private static void moveDice(int dir) {
		switch (dir) {
		case 1:
			swap(0,3);
			swap(1,2);
			swap(0,1);
			break;
		case 2:
			swap(0,2);
			swap(0,3);
			swap(1,3);
			break;
		case 3:
			swap(0,5);
			swap(0,1);
			swap(0,4);
			break;
		case 4:
			swap(0,4);
			swap(0,1);
			swap(0,5);
			break;

		default:
			break;
		}
	}
	private static void swap(int a, int b) {
		int tmp = dice[a];
		dice[a] = dice[b];
		dice[b] = tmp;
		
	}

}
