import java.util.*;
import java.io.*;

public class Main_팩맨 {

	static class midDir{
		int mid, dir;

		public midDir(int mid, int dir) {
			super();
			this.mid = mid;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "midDir [mid=" + mid + ", dir=" + dir + "]";
		}
	}
	static class Dir implements Comparable<Dir>{
		int d1, d2, d3;

		public Dir(int d1, int d2, int d3) {
			super();
			this.d1 = d1;
			this.d2 = d2;
			this.d3 = d3;
		}

		@Override
		public String toString() {
			return "Dir [d1=" + d1 + ", d2=" + d2 + ", d3=" + d3 + "]";
		}

		@Override
		public int compareTo(Dir o) {
			if(this.d1 == o.d1 && this.d2 != this.d2) return this.d2-o.d2;
			else if(this.d1 == o.d1 && this.d2 == o.d2) return this.d3 - o.d3;
			return this.d1 - o.d1;
		}
	}

	static int m; // 몬스터 수
	static int t; // 턴 수
	static int[] packman; // 팩맨 초기위치
	static int[][] diedMap; // 시체 표시할 맵
	static List<midDir>[][] monster;
	static List<midDir>[][] egg;
	static int mid = 1; // 몬스터 아이디
	
	static int dx[] = {-1,-1,0,1,1,1,0,-1};
	static int dy[] = {0,-1,-1,-1,0,1,1,1};
	
	static int pdx[] = {-1,0,1,0}; // 팩맨이 찾을 dx,dy
	static int pdy[] = {0,-1,0,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		packman = new int[2];
		diedMap = new int[4][4];
		monster = new ArrayList[4][4];
		egg = new ArrayList[4][4];
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				monster[i][j] = new ArrayList<>();
				egg[i][j] = new ArrayList<>();
			}
		}
		
		st = new StringTokenizer(br.readLine());
		packman[0] = Integer.parseInt(st.nextToken()) - 1;
		packman[1] = Integer.parseInt(st.nextToken()) - 1;
		
		for(int i=0; i<m; i++) { // 몬스터 정보 m개 입력
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			monster[r-1][c-1].add(new midDir(mid++, d-1));
		}
		
		/*** 입력 끝 ***/
		for(int turn=1; turn<=t; turn++) {
			// 1. 몬스터 복제 시도
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					egg[i][j].addAll(monster[i][j]);
				}
			}
			
			// 2. 몬스터 이동
			// 현재 자신이 가진 방향으로 이동한다.
			// 이동했을 때 새로운 맵에 기록한다.
			List<midDir>[][] newMap = new ArrayList[4][4];
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					newMap[i][j] = new ArrayList<>(); 
				}
			}
			// 몬스터 훑으면서
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(monster[i][j].size() > 0) {
						for(int m=0; m<monster[i][j].size(); m++) {
							midDir out = monster[i][j].get(m);
							int nowDir = out.dir;
							
							boolean check = false;
							for(int d=0; d<8; d++) {
								int nx = i + dx[(d+nowDir) % 8];
								int ny = j + dy[(d+nowDir) % 8];
								
								if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && diedMap[nx][ny] >= 0 && (nx!=packman[0] || ny!=packman[1])) {
									// 갈 수 있는 곳이면 간다.
									// 이동: cntMap에서 원래곳 -1, 갈 곳+1, 몬스터 위치변경, 방향 변경
									newMap[nx][ny].add(new midDir(out.mid, (d+nowDir) % 8));
									check = true;
									break;
								}
							}
							// 모두 갈 수 없는 곳이라면 똑같이 넣는다.
							if(!check) {
								newMap[i][j].add(new midDir(out.mid, out.dir));
							}
						}
					}
				}
			}
			
			// newMap -> 기존맵(monster)에 넣음
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					monster[i][j].clear();
					monster[i][j].addAll(newMap[i][j]);
				}
			}
			
			// 3. 팩맨 이동
			// 이동할 곳을 찾아야함.
			pq = new PriorityQueue<>();
			maxEat = 0;
			perm(0);
			
			// 움직일 방향
			Dir moveDir = pq.poll();
			int moveDirArr[] = {moveDir.d1, moveDir.d2, moveDir.d3};
			
			int moveX = packman[0];
			int moveY = packman[1];
			
			for(int d=0; d<3; d++) {
				// 움직인다.
				moveX += pdx[moveDirArr[d]];
				moveY += pdy[moveDirArr[d]];

				// 먹는다.
				if(monster[moveX][moveY].size() > 0) { // 몬스터가 있는곳이면
					monster[moveX][moveY].clear(); // 몬스터 삭제!
					diedMap[moveX][moveY] = -3; // 시체표시
				}
			}

			// 팩맨 옮기기
			packman[0] = moveX;
			packman[1] = moveY;
			
			
			// 4. 시체 소멸
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(diedMap[i][j] < 0) diedMap[i][j] += 1;
				}
			}
			
			// 5. 부화
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(egg[i][j].size() > 0) {
						for(int m=0; m<egg[i][j].size(); m++) {
							monster[i][j].add(egg[i][j].get(m));
						}
						egg[i][j].clear();
					}
				}
			}
		}
		int answer = 0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				answer += monster[i][j].size();
			}
		}
		System.out.println(answer);
	}
	static int[] order = new int[3];
	static PriorityQueue<Dir> pq;
	static int maxEat;
	private static void perm(int cnt) { // 팩맨 방향찾기!!!
		if(cnt == 3) {
			// 해당 order 방향대로 이동하면서 몇개먹는지 찾음
			int eatCnt = eatCnt();
			if(eatCnt > maxEat) {
				maxEat = eatCnt;
				pq.clear();
				pq.offer(new Dir(order[0], order[1], order[2]));
			} else if(eatCnt == maxEat) {
				pq.offer(new Dir(order[0], order[1], order[2]));
			}
			return;
		}
		
		for(int i=0; i<4; i++) {
			order[cnt] = i;
			perm(cnt+1);
		}
	}
	private static int eatCnt() {
		int x = packman[0];
		int y = packman[1];
		boolean[][] check = new boolean[4][4];
		
		int eat = 0;
		
		for(int d=0; d<3; d++) {
			int dir = order[d];
			int nx = x + pdx[dir];
			int ny = y + pdy[dir];
			
			if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) return -1;
			if(!check[nx][ny]) {
				eat += monster[nx][ny].size();
				check[nx][ny] = true;
			}
			x = nx;
			y = ny;
		}
		return eat;
	}
}
