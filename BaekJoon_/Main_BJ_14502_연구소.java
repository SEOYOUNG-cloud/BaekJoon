package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 벽 3개를 고르자 -> 조합
 * 2. BFS로 바이러스 퍼뜨리기 - dfs로 가지치는게 나을지도..
 * 3. 0의 개수 세면서 최솟값으로 갱신
 * **/
public class Main_BJ_14502_연구소 {

	static int N, M;
	static int[][] map;
	static ArrayList<int[]> zero;
	static ArrayList<int[]> virus;
	static int answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		map = new int[N][M];
		zero = new ArrayList<>();
		virus = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int in = Integer.parseInt(st.nextToken());
				map[i][j] = in;
				if(in == 0) zero.add(new int[] {i,j});
				else if(in == 2) {
					virus.add(new int[] {i,j});
				}
			}
		}
		answer = Integer.MIN_VALUE;
		
		// 입력 끝 //
		
		combination(0,0);
		
		System.out.println(answer);
		
	}
	
	static int[] order = new int[3];
	private static void combination(int cnt, int start) {
		if(cnt == 3) {
			int[][] temp = wall(order);
			
			bfs(temp);
			
			return;
		}
		
		for(int i=start; i<zero.size(); i++) {
			order[cnt] = i;
			combination(cnt+1, i+1);
		}
	}

	private static int[][] wall(int[] order) {
		int[][] clone_map = new int[N][M];
		for(int i=0; i<N; i++)
			clone_map[i] = map[i].clone();
			
		for(int o : order) {
			int x = zero.get(o)[0];
			int y = zero.get(o)[1];
			
			clone_map[x][y] = 1;
		}
		
		
		return clone_map;
	}
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	private static void bfs(int[][] temp) {
		
		Queue<int[]> queue = new ArrayDeque<>();
		for(int[] v : virus) { // 2인 부분 다 넣어놓음
			queue.add(new int[] {v[0], v[1]});
		}
		
		while(!queue.isEmpty()) {
			int out[] = queue.poll();
			int x = out[0];
			int y = out[1];
			
			// 빼내면서 바이러스 퍼뜨린다.
			temp[x][y] = 2;
			
			for(int d=0; d<4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || temp[nx][ny] != 0) continue;
				queue.add(new int[] {nx, ny});
			}
		} // 다 퍼뜨림
		
		
		int safe = 0;
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				if(temp[i][j] == 0) safe += 1;
		answer = Math.max(answer, safe);
		

	}

}
