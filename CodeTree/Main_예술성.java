import java.util.*;
import java.io.*;

public class Main_예술성 {
	
	static class xy{
		int x, y;

		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static class group {
		int cnt, num;

		public group(int cnt, int num) {
			super();
			this.cnt = cnt;
			this.num = num;
		}

		@Override
		public String toString() {
			return "group [cnt=" + cnt + ", num=" + num + "]";
		}
	}

	static int n; // 격자 크기
	static int[][] map;
	static int[][] group; // 그룹핑 된 맵
	static Map<Integer, group> groupInfo; // 그룹핑 된 애들 정보저장
	static int answer = 0; // 조화로움 총합
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		group = new int[n][n];
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/**** 입력 끝 ****/
		for(int tc=0; tc<=3; tc++) {
			// 1. 그룹핑
			grouping();
			
			// 4. 네곳 90도 시계방향 회전
			turnSquare(0, 0, n/2-1, n/2-1);
			turnSquare(0, n/2+1, n/2-1, n-1);
			turnSquare(n/2+1, 0, n-1, n/2-1);
			turnSquare(n/2+1, n/2+1, n-1, n-1);
			// 5. 십자 90도 반시계 회전
			turnMiddle();
		}
		
		System.out.println(answer);
		
	}
	// 그룹핑
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	private static void grouping() {
		boolean[][] visited = new boolean[n][n];
		groupInfo = new HashMap<>();
		group = new int[n][n];
		
		int idx = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					Queue<xy> queue = new ArrayDeque<>();
					queue.offer(new xy(i, j));
					
					int cnt = 1;
					group[i][j] = idx;
					visited[i][j] = true;
					
					while(!queue.isEmpty()) {
						xy out = queue.poll();
						int x = out.x;
						int y = out.y;
						
						for(int d=0; d<4; d++) {
							int nx = x+dx[d];
							int ny = y+dy[d];
							if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] 
									|| (map[x][y] != map[nx][ny])) continue;
							
							visited[nx][ny] = true;
							group[nx][ny] = idx;
							cnt += 1;
							queue.offer(new xy(nx, ny));
						}
					}
					groupInfo.put(idx, new group(cnt, map[i][j]));
					idx++;
				}
			}
		}
		// 2. 조합
		nC2(1, idx, 0);
	}
	
	// 조합 idx C 2
	static int comb[] = new int[2];
	private static void nC2(int start, int idx, int cnt) {
		if(cnt == 2) {
			// 3. 조화로움 구하기
			wonderful(comb[0], comb[1]);
			return;
		}
		for(int i=start; i<idx; i++) {
			comb[cnt] = i;
			nC2(i+1, idx, cnt+1);
		}
	}
	
	// a,b 두 그룹의 조화로움 계산
	private static void wonderful(int a, int b) {
		// (a에 속한 칸의 수 + b에 속한 칸의 수)
		int kan = groupInfo.get(a).cnt + groupInfo.get(b).cnt;
		
		// 그룹 a를 이루고 있는 숫자 값  x b
		int numA = groupInfo.get(a).num;
		int numB = groupInfo.get(b).num;
		
		// x 그룹 a,b가 맞닿아있는 변의 수
		int cnt=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(group[i][j] == a) {
					// 4방 확인해서 b가 있으면 +1
					for(int d=0; d<4; d++) {
						int nx = i+dx[d];
						int ny = j+dy[d];
						if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
						if(group[nx][ny] == b) cnt++;
					}
				}
			}
		}
		answer += kan * numA * numB * cnt;
	}	
	// 4곳 시계방향 회전
	private static void turnSquare(int startX, int startY, int endX, int endY) {
		int line = endX - startX + 1; // 한 줄의 길이
		int[][] square = new int[line][line];
		
		int i = 0;
		for(int y=startY; y<=endY; y++) {
			for(int x=endX, j=0; x>endX-line; x--) {
				square[i][j++] = map[x][y];
			} i++;
		}
		
		int a=0;
		for(int x=startX; x<=endX; x++) {
			for(int j=startY, b=0; j<=endY; j++) {
				map[x][j] = square[a][b++];
			}
			a++;
		}
	}
	
	// 가운데 + 반시계방향 회전
	private static void turnMiddle() {
		// 90도 방향으로 + 회전
		int middle = n/2;
		// |
		int[] l = new int[n];
		int i=0;
		for(int j=n-1; j>=0; j--) {
			l[i++] = map[middle][j];
		}
		
		// ㅡ
		int j=0;
		int[] m = new int[n];
		for(int x=0; x<n; x++) {
			m[j++] = map[x][middle];
		}
		
		// 옮기기
		int a=0;
		for(int b=0; b<n; b++) {
			map[b][middle] = l[a++];
		}
		int c=0;
		for(int d=0; d<n; d++) {
			map[middle][d] = m[c++];
		}
		
	}

}
