package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek21610 {
	
	static int N,M;
	static int map[][];
	static boolean cloud[][];
	static int dx[] = {0,0,-1,-1,-1,0,1,1,1};
	static int dy[] = {0,-1,-1,0,1,1,1,0,-1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 비구름이 드리운 곳 표시 T:비구름, F:비구름x
		cloud = new boolean[N][N]; // false로 초기화 되어있음
		
		// 비바라기!
		cloud[N-1][0] = true;
		cloud[N-1][1] = true;
		cloud[N-2][0] = true;
		cloud[N-2][1] = true;
		
		// 방향 거리 입력받으면서 움직이기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			// 구름 움직이기부터 시작하자
			move_cloud(d,s);		
		}
		
		// 마지막으로 바구니에 있는 물의 양 세기
		int answer = 0;
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				answer += map[i][j];

		
		System.out.println(answer);


	}
	private static ArrayList<int[]> find_cloud() {
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				if(cloud[i][j]) list.add(new int[] {i,j});

		return list;
	}
	private static void move_cloud(int d, int s) {
		// 구름 찾아
		ArrayList<int[]> cloud_list = find_cloud();
		
		for(int size=0; size<s; size++) {
			for(int i=0; i<cloud_list.size(); i++) {
				int x = cloud_list.get(i)[0];
				int y = cloud_list.get(i)[1];
				
				x += dx[d];
				y += dy[d];
				
				if(x == N) x=0;
				if(x < 0) x = N-1;
				if(y == N) y=0;
				if(y < 0) y = N-1;
				
				//리스트 안에 값 바꿔놓자
				cloud_list.get(i)[0] = x;
				cloud_list.get(i)[1] = y;
			}
		}
			// 클라우드 초기화함. 밑에서 다시 넣어줄거임
			cloud = new boolean[N][N];

			// 옮겼으면 바구니에 물줌
			for(int i=0; i<cloud_list.size(); i++) {
				int x = cloud_list.get(i)[0];
				int y = cloud_list.get(i)[1];

				map[x][y] += 1;
				cloud[x][y] = true;
			}
		
		// 대각선에 0이 아닌 개수만큼 물 넣기
		diagonal(cloud_list);

	}
	
	// 대각선 확인하고 물주자!
	private static void diagonal(ArrayList<int[]> cloud_list) {
		for(int i=0; i<cloud_list.size(); i++) {
			int cnt = 0;
			int x = cloud_list.get(i)[0];
			int y = cloud_list.get(i)[1];
			
			for(int d=2; d<=8; d+=2) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != 0) cnt+=1;
			}
			
			map[x][y] += cnt;
		}
		
		make_cloud();
	}
	
	// 구름 다시 만들기!
	private static void make_cloud() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] >= 2 && !cloud[i][j]) {
					map[i][j] -= 2;
					cloud[i][j] = true;
				} else if(cloud[i][j]) cloud[i][j] = false;
			}
		}
	}

}
