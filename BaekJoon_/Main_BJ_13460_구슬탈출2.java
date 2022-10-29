package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_13460_구슬탈출2 {

	static int N,M;
	static char[][] map;
	static int RedX, RedY, BlueX, BlueY;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				char in = line.charAt(j);
				if(in == 'B') {
					BlueX = i;
					BlueY = j;
				} else if(in == 'R') {
					RedX = i;
					RedY = j;
				}
				map[i][j] = in;
			}
		}
		
//		System.out.println(Arrays.deepToString(map));
		/// 입력 끝 ///
		
		// 방문 처리 배열을 4차원으로 생성
		// 
		boolean[][][][] visited = new boolean[N][M][N][M];

		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {RedX, RedY, BlueX, BlueY, 1});
		
		visited[RedX][RedY][BlueX][BlueY] = true;
		while(!queue.isEmpty()) {
			int[] out = queue.poll();
			int x = out[0];
			int y = out[1];
			int bx = out[2];
			int by = out[3];
			int cnt = out[4];
			
			if(cnt > 10) {
				break;
			}
			
			A: for(int d=0; d<4; d++) {
				int nx = x;
				int ny = y;
				int tx = bx;
				int ty = by;
				
				// B먼저 움직여서 구멍에 빠지면 못가는거임
				// 못간다 = 그 길이 의미가 없다.. 그러므로 넘어간다
				while(true) {
					if(tx < 0 || tx >= N || ty < 0 || ty >= M || map[tx][ty] == '#') break;
					if(map[tx][ty] == 'O') {
						continue A;
					}
					
					tx += dx[d];
					ty += dy[d];
				}
				tx -= dx[d];
				ty -= dy[d];
				
				while(true) {
					if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '#') break;
					if(map[nx][ny] == 'O') {
						if(cnt > 10) {
							System.out.println("-1");
						} else {
							System.out.println(cnt);
						}
						System.exit(0);
					}
					
					nx += dx[d];
					ny += dy[d];
				}
				nx -= dx[d];
				ny -= dy[d];
				
				if(nx == tx && ny == ty) {
					int blueD = Math.abs(bx - tx) + Math.abs(by - ty);
					int RedD = Math.abs(x -nx) + Math.abs(y - ny);
					
					if(RedD > blueD) {
						nx -= dx[d];
						ny -= dy[d];
					} else {
						tx -= dx[d];
						ty -= dy[d];
					}
				}
				if(!visited[nx][ny][tx][ty]) {
					visited[nx][ny][tx][ty] = true;
					queue.add(new int[] {nx, ny, tx, ty, cnt+1});
				}
			}
		}
		System.out.println("-1");
	}
}
