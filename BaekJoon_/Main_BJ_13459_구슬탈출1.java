package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_13459_구슬탈출1 {

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
		// 앞 2차원은 빨간 공 위치, 뒤 2차원은 파란 공 위치임
		// 그래서 빨간 공 위치와 파란 공 위치가 같았던 곳만 피하면서 방문체크
		boolean[][][][] visited = new boolean[N][M][N][M];

		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {RedX, RedY, BlueX, BlueY, 1}); // cnt는 1부터 시작함 무조건 움직이니까..
		
		visited[RedX][RedY][BlueX][BlueY] = true;
		while(!queue.isEmpty()) {
			int[] out = queue.poll();
			int x = out[0]; // redX
			int y = out[1]; // redY
			int bx = out[2]; // blueX
			int by = out[3]; // blueY
			int cnt = out[4]; // cnt
			
			if(cnt > 10) { // 10번 이상이면 끝냄
				break;
			}
			
			A: for(int d=0; d<4; d++) { // 한 공만 움직일 수도 있어서 사방 다 살펴볼거임.
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
				
				// 그 다음 빨간 공 움직이기
				// 공에 들어갔다면 cnt 세서 체크체크
				while(true) {
					if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '#') break;
					if(map[nx][ny] == 'O') {

						System.out.println(cnt);
						System.exit(0); // 출력하고 바로 끝내기
					}
					
					nx += dx[d];
					ny += dy[d];
				}
				nx -= dx[d];
				ny -= dy[d];
				
				// 빨간 공과 파란 공이 같은 위치에 올 수 없다고 했음
				// 그 말은 한 공이 먼저 도착하면 그 옆에 놓인다는 뜻..
				// 그래서 거리가 짧은애가 도착하고, 거리가 긴 애가 그 옆에 정착
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
				// 빨간 공&파란 공의 위치가 같은지만 체크하고 큐에 넣음
				if(!visited[nx][ny][tx][ty]) {
					visited[nx][ny][tx][ty] = true;
					queue.add(new int[] {nx, ny, tx, ty, cnt+1});
				}
			}
		}
		System.out.println("-1");
	}
}
