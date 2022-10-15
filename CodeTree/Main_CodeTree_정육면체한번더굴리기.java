import java.util.*;
import java.io.*;

public class Main_CodeTree_정육면체한번더굴리기 {
	
	static int n,m;
	static int[][] map;
	static int x,y,d; // 주사위가 존재하는 x,y,d값
	static int answer = 0;
	static int[][] dxy = {{0,1},{1,0},{0,-1},{-1,0}}; // 오,아래,왼,위 - 시계방향
	static int[] dice;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i=0; i<n; i++)
//			System.out.println(Arrays.toString(map[i]));
		
		// 입력 끝 //
		
		int bottom = 6; // 시작할 때 바닥은 6
		dice = new int[]{2,5,1,6,3,4}; // 앞 뒤 위 바닥 오른쪽 왼쪽
		
		// m번 반복하기
		for(int count=1; count<=m; count++) {
			// 1. 주사위가 있을 위치 구하기
			// 1-1. 먼저 옮겼을 때의 위치가 범위를 벗어나는지 체크
			
			// 범위를 벗어남
			if((x+dxy[d][0]) >= n || x+dxy[d][0] < 0 || y+dxy[d][1] >= n || y+dxy[d][1] < 0) { ////////////틀리면 여기 다시 확인해보자
				if(d == 0) d = 2;
				else if(d == 2) d = 0;
				else if(d == 1) d = 3;
				else d = 1;
			}
			
			// 1-2. 주사위 자리 옮기기
			x += dxy[d][0];
			y += dxy[d][1];
			
			// 2. 주사위 굴리기
			// 신경써야할 부분은 주사위의 바닥 부분
			RollDice(dice, d); // 주사위 굴림
			
			
			// 3. map에 있는 숫자 bfs
			int total = bfs(x, y);
			
			// 4. answer에 더함
			answer += total;
			
			// 5. 밑에 있는 숫자를 보고 방향을 바꿀지 말지 선택한다.
			bottom = dice[3];
			if(bottom > map[x][y]) { // 90도 시계방향
				d = (d+1)%4;
			} else if(bottom < map[x][y]) { // 90도 반시계방향
				d = (d+3)%4;
			}
			
		}
		
		System.out.println(answer);
		

	}

	private static int bfs(int i, int j) {
		boolean visited[][] = new boolean[n][n];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {i,j});
		visited[i][j] = true;
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			int out[] = queue.poll();
			int x = out[0];
			int y = out[1];
			
			for(int d=0; d<4; d++) {
				int nx = x + dxy[d][0];
				int ny = y + dxy[d][1];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
				if(map[x][y] == map[nx][ny]) {
					cnt += 1;
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		
		return cnt * map[i][j];
	}

	private static void RollDice(int[] dice, int dir) {
		switch (dir) {
		case 0: // 오른쪽
			swap(2, 5);
			swap(3, 4);
			swap(4, 5);
			break;
		case 1: // 아래
			swap(0, 2);
			swap(1, 3);
			swap(2, 3);
			break;
		case 2: // 왼쪽
			swap(2, 4);
			swap(3, 5);
			swap(4, 5);
			break;
		case 3: // 위
			swap(0, 3);
			swap(1, 2);
			swap(2, 3);
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
