package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_15644_구슬탈출3 {

	static int N,M;
	static char[][] map;
	static int RedX, RedY, BlueX, BlueY;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static boolean[][][][] visited;
	
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
		
		/// 입력 끝 ///
		
		// 방문 처리 배열을 4차원으로 생성
		// 앞 2차원은 빨간 공 위치, 뒤 2차원은 파란 공 위치임
		// 그래서 빨간 공 위치와 파란 공 위치가 같았던 곳만 피하면서 방문체크
		visited = new boolean[N][M][N][M];
		dir = new ArrayList<>();
		
		answer = Integer.MAX_VALUE;
		dfs(RedX, RedY, BlueX, BlueY, 1);
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println("-1");
			System.exit(0);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<dir.size(); i++) {
			switch (dir.get(i)) {
			case 0:
				sb.append("D");
				break;
			case 1:
				sb.append("U");
				break;
			case 2:
				sb.append("R");
				break;
			case 3:
				sb.append("L");
				break;
			default:
				break;
			}
		}
		System.out.println(answer);
		System.out.println(sb.toString());
		
	}
	static ArrayList<Integer> dir;
	static ArrayList<Integer> list = new ArrayList<>();
	static int answer;
	private static void dfs(int Rx, int Ry, int Bx, int By, int cnt) {
		if(cnt > 10) {
			return;
		}
		if(cnt > answer) {
			return;
		}
		
		A: for(int d=0; d<4; d++) { // DURL
			int nx = Rx;
			int ny = Ry;
			int tx = Bx;
			int ty = By;
			
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
					if(cnt < answer) {
						answer = cnt;
						dir.clear();
						for(int i=0; i<list.size(); i++) {
							dir.add(list.get(i));
						} dir.add(d);
					}
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
				int blueD = Math.abs(Bx - tx) + Math.abs(By - ty);
				int RedD = Math.abs(Rx -nx) + Math.abs(Ry - ny);
				
				if(RedD > blueD) {
					nx -= dx[d];
					ny -= dy[d];
				} else {
					tx -= dx[d];
					ty -= dy[d];
				}
			}
			// 빨간 공과 파란 공의 다음 위치가 나왔음
			// 빨간 공&파란 공의 위치가 같은지만 체크하고 큐에 넣음
			if(!visited[nx][ny][tx][ty]) {
				visited[nx][ny][tx][ty] = true;
				list.add(d);
				dfs(nx,ny,tx,ty,cnt+1);
				list.remove(list.size()-1);
				visited[nx][ny][tx][ty] = false;
			}
		}
	}
}
