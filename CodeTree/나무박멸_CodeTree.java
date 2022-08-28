package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
-1. 나무가 성장하기 전에 c+1이면 0으로 초기화하는... 그니까 제초제 있는곳에 +1하는 과정이 필요함
1. 나무 성장
	1-1) 4방에 있는 나무 수만큼 성장(0~4)
	
2. 나무 번식
	2-1) 존재하는 나무를 기준으로 4방을 번식함
	2-2) 나무 개수 / 4방에 있는 빈칸 수 (0~4) 만큼 4방에 더해줌 (겹칠 수 있으므로)
	
3. 제초제 뿌리기
	- 대각선 방향으로 K만큼 전파됨
	- 벽이 있거나 나무가 없으면 거기까지 전파
	- c년만큼 있다가 c+1년 째!에 사라짐
	- 다시 뿌려지면 c년 남은걸로 초기화됨
	3-1) map 훑으면서 나무가 있으면 그자리 + 대각선 k만큼 더한 정보를 x,y,max 값에 넣어놓고 계속 갱신한다.
	3-2) 이제 그 자리가 max값이 제일 큰 자리이므로 그 자리와 대각선을 모두 -(c+1)로 바꾼다.
	3-3) 뿌려진 곳에 또 뿌려지면 -(c+1)로 바꾼다.
*/

public class KillTree_CodeTree {

	static int n,m,k,c;
	static int map[][], killmap[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int ddx[] = {1,-1,1,-1}; // 대각선 x
	static int ddy[] = {-1,-1,1,1}; // 대각선 y
	static int answer = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 격자 크기
		m = Integer.parseInt(st.nextToken()); // 박멸이 진행되는 년 수
		k = Integer.parseInt(st.nextToken()); // 제초제 확산 범위
		c = Integer.parseInt(st.nextToken()); // 제초제가 남아있는 년 수
		
		map = new int[n][n];
		killmap = new int[n][n]; // 제초제를 뿌린곳 지도
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 입력 끝 //

		while(m-->0) {
			start();
			
			grow_tree();
			
			breed();
			
			herb();
			
		}
		
		System.out.println(answer);
	}
	// 1. 나무 성장
	// - 4방에 있는 나무 수만큼 성장(0~4)
	private static void grow_tree() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] > 0 && killmap[i][j] == 0) { // 나무가 존재(>0)하면
					for(int d=0; d<4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						if(!isRange(nx, ny)) continue;
						if(killmap[nx][ny] != 0) continue;
						if(map[nx][ny] > 0) map[i][j]++;
					}	
				}
			}
		}
		
		
//		// 자라거라 맵 찍어보기
//		for(int i=0; i<n; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}
	// 2. 나무 번식
	// 4방 탐색해서 빈칸개수 찾고 그 칸에 나무수/빈칸개수 넣기 -> 빈칸개수를 안 후 나무수로 나눠서 그 자리에 넣어줘야함
	private static void breed() {
		int[][] temp = new int[n][n];
		for(int i=0; i<n; i++)
			temp[i] = map[i].clone();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] > 0) {
					ArrayList<int[]> spread = new ArrayList<>();
					
					for(int d=0; d<4; d++) {
						int r = i + dx[d];
						int c = j + dy[d];
						
						if(isRange(r,c) && map[r][c] == 0 && killmap[r][c] == 0) {
							spread.add(new int[] {r, c});
						}
					}
					
					if(spread.size() == 0)
						continue;
					
					int tree = map[i][j] / spread.size();
					for(int[] s : spread) {
						temp[s[0]][s[1]] += tree;
					}
				}
			}
		}
		
		for(int i=0; i<n; i++)
			map[i] = temp[i].clone();
	}
	
	// 3. 제초제 뿌리기
	private static void herb() {
		int maxX=0, maxY=0, max = 0;
		
		// 3-1) 제초제를 뿌릴곳 탐색
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] > 0) { // 나무가 있으면
					//그자리 + 대각선 k만큼의 나무를 합해서 max에 갱신
					
					int total = map[i][j];
					for(int d=0; d<4; d++) { // 대각선 방향에 따라
						int x = i;
						int y = j;
						for(int K=0; K<k; K++) { // k만큼 훑는다
							int nx = x + ddx[d];
							int ny = y + ddy[d];
							
							if(!isRange(nx, ny) || map[nx][ny] == -1 || map[nx][ny] == 0) break;
							
							total += map[nx][ny];
							x = nx;
							y = ny;
						}
					}
				
//				System.out.println("(" + i + ", " + j + ") : " + total );
				//여기 불안하다^^/./////....
					if(max < total) {
						max = total;
						maxX = i;
						maxY = j;
					} else if(max == total) {
						if(i < maxX) {
							maxX = i;
							maxY = j;
						} else if(i == maxX) {
							if(j < maxY) {
								maxX = i;
								maxY = j;
							}
						}
					}
					
				}
				
			}
		}
		answer += max;
		// 3-2) 뿌릴곳 정했으니 그 자리와 대각선에 제초제 뿌리기
		//		벽이나 나무가 없다면 그 자리까지 뿌리기 (벽에는 안뿌릴거임)
		killmap[maxX][maxY] = -c-1;
		map[maxX][maxY] = 0;
		
		
		A:for(int d=0; d<4; d++) { // 대각선 방향에 따라
			int x = maxX;
			int y = maxY;
			for(int K=0; K<k; K++) { // k만큼 훑는다
				int nx = x + ddx[d];
				int ny = y + ddy[d];
				
				if(!isRange(nx, ny) || map[nx][ny] == -1) continue A;
				if(map[nx][ny] == 0 || killmap[nx][ny] < 0) { // 나무가 그냥 없는곳이면
					killmap[nx][ny] = -c-1;
					continue A;
				}
				map[nx][ny] = 0;
				killmap[nx][ny] = -c-1;
				
				
				x = nx;
				y = ny;
			}
		}
		
	}
	
	// -1. 1년이 지났을 때 제초제가 있는 곳에 +1을 먼저 해야하기 때문에 제초제+1 해주는거 먼저 실행
	private static void start() {
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				if(killmap[i][j] < 0)
					killmap[i][j]+=1;
	}
	
	
	private static boolean isRange(int nx, int ny) {
		if(nx < 0 || nx >= n || ny < 0 || ny >= n )
			return false;
		else 
			return true;
	}

}
