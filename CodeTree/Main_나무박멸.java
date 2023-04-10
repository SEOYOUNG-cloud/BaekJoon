import java.util.*;
import java.io.*;

public class Main_나무박멸 {
	
	static class xy implements Comparable<xy>{
		int x, y, cnt;

		public xy(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(xy o) {
			if(this.x == o.x) return this.y - o.y;
			return this.x - o.x;
		}
	}
	
	static int[][] tree; // 나무
	static int[][] diedTree; // 제초제가 뿌려진 + 벽 표시
	static int n; // 격자크기
	static int m; // 박멸 진행년수
	static int k; // 제초제 확산 범위
	static int c; // 제초제가 남아있는 년 수
	static int answer = 0; // 박멸한 나무의 수

	static int dx[] = {-1,0,0,1};
	static int dy[] = {0,-1,1,0};
	static int Dx[] = {-1,-1,1,1}; // 대각선
	static int Dy[] = {1,-1,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		tree = new int[n][n];
		diedTree = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int in = Integer.parseInt(st.nextToken());
				if(in == -1) {
					diedTree[i][j] = 1; // 벽은 양수로 표시
				} else {
					tree[i][j] = in;
				}
			}
		}
		
		/**** 입력 끝   ****/
		// m년만큼 돌자
		for(int year=1; year<=m; year++) {
			// 0. 제초제가 뿌려진 곳 +1한다.
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					int check = diedTree[i][j];
					if(check < 0) diedTree[i][j] += 1;
				}
			}
			
			// 1. 나무의 성장
			// 4방에 있는 칸 중 나무가 있는 칸의 수만큼 성장한다.
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(tree[i][j] > 0) { // 나무가 있는 칸이면
						int addAge = 0;
						for(int d=0; d<4; d++) {
							// 4방을 확인한다.
							int nx = i + dx[d];
							int ny = j + dy[d];
							
							if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
							if(tree[nx][ny] > 0) addAge += 1; // 그 자리에 나무가 있으면 +1한다.
						}
						
						tree[i][j] += addAge;
					}
				}
			}
			
			// 2. 나무의 번식
			// 2-1. 번식할 애기들 grow[][]에 넣음
			int[][] grow = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(tree[i][j] > 0) { // 나무가 있는 칸에서
						// 4방을 확인해서 벽, 다른나무, 제초제가 없는 칸의 개수를 찾는다.
						int cnt = 0;
						ArrayList<Integer> growSite = new ArrayList<>();
						for(int d=0; d<4; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							
							if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
							if(tree[nx][ny] == 0 && diedTree[nx][ny] == 0) {
								cnt += 1;
								growSite.add(d);
							}
						}
						// 자기꺼 / cnt만큼 번식한다.
						if(cnt == 0) continue;
						int addGrow = tree[i][j] / cnt;
						for(int g : growSite) { // 넣을 자리들..!
							int nx = i + dx[g];
							int ny = j + dy[g];
							grow[nx][ny] += addGrow;
						}
					}
				}
			}
			// 2-2. 번식시킨다.
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					tree[i][j] += grow[i][j];
				}
			}
			
			// 3. 제초제 뿌리기
			// 3-1. 어디에 뿌릴지 찾는다.
			int[][] killmap = new int[n][n];
			for(int i=0; i<n; i++)
				killmap[i] = tree[i].clone();
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					// 나무가 있는 곳에서
					if(tree[i][j] > 0) {
						// 4개의 대각선 방향으로 k칸만큼 전파된다.
						for(int d=0; d<4; d++) {
							int nx = i;
							int ny = j;
							for(int kan=1; kan<=k; kan++) {
								nx += Dx[d];
								ny += Dy[d];
								
								if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;
								// 만약 벽이 있거나 나무가 없으면 멈춘다. (그 칸까지만 뿌린다. 하지만 어디에 뿌릴지 찾기만 하는거라 걍 멈춤)
								if(diedTree[nx][ny] == 1 || tree[nx][ny] == 0) break;
								killmap[i][j] += tree[nx][ny];
							}
						}
					}
				}
			}
			
			
			// 3-2. 제일 큰 애 찾아
			int bigCnt = 0;
			PriorityQueue<xy> pq = new PriorityQueue<>();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(killmap[i][j] > bigCnt) {
						pq.clear();
						pq.offer(new xy(i, j, killmap[i][j]));
						
						bigCnt = killmap[i][j];
					} else if(killmap[i][j] == bigCnt) {
						pq.offer(new xy(i, j, killmap[i][j]));
					}
				}
			}
			
			xy pqOut = pq.poll();
			int bigX = pqOut.x;
			int bigY = pqOut.y;
			int big = pqOut.cnt;
			
			// 3-3. 거기에 제초제 뿌려
			answer += big;
			// 해당 자리에 먼저 뿌리고 
			diedTree[bigX][bigY] = -(c+1);
			tree[bigX][bigY] = 0;
			
			// 대각선들에 뿌린다.
			for(int d=0; d<4; d++) {
				int nx = bigX;
				int ny = bigY;
				for(int kan=1; kan<=k; kan++) {
					nx += Dx[d];
					ny += Dy[d];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;
					// 만약 벽이 있으면 멈추고
					if(diedTree[nx][ny] == 1) break;
					// 나무가 없으면 그 칸까지만 뿌린다.
					diedTree[nx][ny] = -(c+1);
					if(tree[nx][ny] == 0) break;
					tree[nx][ny] = 0;
				}
			}
			
		}
		
		System.out.println(answer);
	}

}
