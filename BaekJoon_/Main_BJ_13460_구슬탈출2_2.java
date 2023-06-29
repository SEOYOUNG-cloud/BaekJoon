package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_13460_구슬탈출2_2 {
	
	static class Node{
		int redX, redY, blueX, blueY, cnt;
		
		public Node(int redX, int redY, int blueX, int blueY, int cnt) {
			this.redX = redX;
			this.redY = redY;
			this.blueX = blueX;
			this.blueY = blueY;
			this.cnt = cnt;
		}
	}
	
	static int N, M;
	static int hole[];
	static char map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		hole = new int[2];
		int redX = -1;
		int redY = -1;
		int blueX = -1;
		int blueY = -1;
		
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j);
				
				if(map[i][j] == 'O') {
					hole[0] = i;
					hole[1] = j;
				} else if(map[i][j] == 'B') {
					blueX = i;
					blueY = j;
					map[i][j]='.';
				} else if(map[i][j] == 'R') {
					redX = i;
					redY = j;
					map[i][j]='.';
				}
			}
		}
		
		/* 입력 끝 */
		
		// 1. 움직일 수 있는 방향은 4가지이다. 동서남북
		int dx[] = {0,0,1,-1};
		int dy[] = {1,-1,0,0};
		
		// 2. queue에 동서남북으로 움직일 수 있게 돕는다.
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(redX, redY, blueX, blueY, 1));
		boolean[][][][] visited = new boolean[N][M][N][M];
		visited[redX][redY][blueX][blueY] = true;
		
		while(!queue.isEmpty()) {
			Node out = queue.poll();
			int cnt = out.cnt;
			
			if(cnt > 10) continue; // 다음번에 기울였을 때 10번이 넘어가면 멈춘다.
				
			// 동서남북 방향으로 기울인다.
			A: for(int d=0; d<4; d++) {
				boolean red = false;
				int nrx = out.redX;
				int nry = out.redY;
				int nbx = out.blueX;
				int nby = out.blueY;
				
				// 파란 공 움직이기
				// 다음번에 갈 곳이 막혀있지 않고 범위 안이라면
				while(nbx+dx[d] >= 0 && nbx+dx[d] < N && nby+dy[d] >= 0 && nby+dy[d] < M && map[nbx+dx[d]][nby+dy[d]] != '#') {
					// 간다!
					nbx += dx[d];
					nby += dy[d];
					
					// 구멍을 만나면
					if(nbx == hole[0] && nby == hole[1]) {
						// 이번 경로는 그냥 버린다.
						continue A;
					}
				}
				
				// 빨간 공 움직이기
				while(nrx+dx[d] >= 0 && nrx+dx[d] < N && nry+dy[d] >= 0 && nry+dy[d] < M && map[nrx+dx[d]][nry+dy[d]] != '#') {
					// 간다!
					nrx += dx[d];
					nry += dy[d];
					
					// 구멍을 만나면
					if(nrx == hole[0] && nry == hole[1]) {
						red = true;
					}
				}
				
				if(red) {
					System.out.println(cnt);
					return;
				}
				
				// 만약 도착한 지점이 같다면
				if(nrx == nbx && nry == nby) {
					switch (d) {
					case 0: // 오른쪽으로 기울였다면
						if(out.redY < out.blueY) {
							// 파랑 공이 더 오른쪽에 있었다면 빨간 공이 한 칸 왼쪽에 있어야함
							nry -= 1;
						} else {
							nby -= 1;
						}
						break;
					case 1: // 왼쪽으로 기울였다면
						if(out.redY < out.blueY) {
							// 파랑 공이 더 오른쪽에 있었다면 파란 공이 한 칸 오른쪽에 있어야함
							nby += 1;
						} else {
							nry += 1;
						}
						break;
					case 2: // 아래로 기울였다면
						if(out.redX < out.blueX) {
							// 파란 공이 더 밑에 있었다면 빨간 공이 한 칸 위에 있어야함
							nrx -= 1;
						} else {
							nbx -= 1;
						}
						break;
					case 3: // 위로 기울였다면
						if(out.redX < out.blueX) {
							// 파란 공이 더 밑에 있었다면 파란 공이 한 칸 밑에 있어야함
							nbx += 1;
						} else {
							nrx += 1;
						}
						break;
					default:
						break;
					}
				}
			
				
				// 다시 넣는다.
				if(!visited[nrx][nry][nbx][nby]) {
					visited[nrx][nry][nbx][nby] = true;
					queue.add(new Node(nrx, nry, nbx, nby, cnt+1));
				
				}
				
			}
		}
		System.out.println("-1");
	}
}
