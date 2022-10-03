package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 중복순열로 깰 순서 생성
 * 2. bfs로 벽돌 깨면서 퍼지는 부분 다 bfs 처리 + visited 처리
 * 3. 벽돌 밑으로 내리기
 * 
 * 4. 다 돌았으면 남아있는 벽돌의 수 구해서 answer보다 크면 갱신 
 * */
public class Solution_벽돌깨기 {

	static int N, W, H;
	static int[][] map;
	static int answer;
	static int order[];

	public static void main(String[] args) throws FileNotFoundException, Exception {
		System.setIn(new FileInputStream("res/input_벽돌깨기.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			answer = Integer.MAX_VALUE;

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					int in = Integer.parseInt(st.nextToken());
					map[i][j] = in;
				}
			}
			
			// 입력 끝 //

			order = new int[N];
			permutation(0);
			
			
			System.out.printf("#%d %d\n", tc, answer);
		}

	}
	
	// 1. 중복순열로 깰 순서 생성
	private static void permutation(int cnt) {
		if(cnt == N) {
			// 순서 = order
			int clone[][] = new int[H][W];
			for(int i=0; i<H; i++)
				clone[i] = map[i].clone();
			
			bfs(order, clone);
			
			
			return;
		}
		
		for(int i=0; i<W; i++) {
			order[cnt] = i;
			permutation(cnt+1);
		}
	}
	
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	
	// 2. bfs로 벽돌 깨면서 퍼지는 부분 다 bfs 처리 + visited 처리
	private static void bfs(int[] order, int[][] clone_map) {
		int total = 0;
		
		for(int o : order) { // o: 깰 y 인덱스
			int peek = -1;
			for(int i=0; i<=H-1; i++) {
				if(clone_map[i][o] > 0) {
					peek = i;
					break;
				}
			}
			
			// 그 줄에 벽돌이 없으면 그 순서 자체를 넘김 (continue)
			if(peek == -1) continue;
			
			// bfs로 벽돌 뽀개자
			boolean[][] visited = new boolean[H][W];
			Queue<int[]> queue = new ArrayDeque<>();
			queue.add(new int[] {peek, o, clone_map[peek][o]}); // queue에 저장할 것: x, y, 퍼질개수
			
			while(!queue.isEmpty()) {
				int out[] = queue.poll();
				int x = out[0];
				int y = out[1];
				int num = out[2] - 1;
				
				clone_map[x][y] = 0; // 벽돌 뽀갬
				if(num == 0) continue; // 1이면 자기 자신만 뽀개므로 넘어감
				
				for(int d=0; d<4; d++) {
					x = out[0];
					y = out[1];
					for(int i=0; i<num; i++) { // 퍼질 개수만큼 퍼지도록,,,,돌림
						x += dx[d];
						y += dy[d];
						
						if(x < 0 || x >= H || y < 0 || y >= W) break;
						if(visited[x][y] || clone_map[x][y] == 0) continue;
						visited[x][y] = true;
						queue.add(new int[] {x, y, clone_map[x][y]});
						
					}
					
				}
			} // 다 뽀갰음

			
			// 벽돌 내리기
			down(clone_map);
			
		}
		
		// 다 돌았으니 남아있는 벽돌의 개수 세기
		for(int i=0; i<H; i++)
			for(int j=0; j<W; j++)
				if(clone_map[i][j] > 0) total++;
		
		answer = Math.min(total, answer);
		
	}
	
	// 3. 벽돌 밑으로 내리기
	private static void down(int[][] clone_map) {
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i=0; i<W; i++) {
			for(int j=H-1; j>=0; j--) {
				if(clone_map[j][i] != 0) {
					queue.add(clone_map[j][i]);
					clone_map[j][i] = 0;
				}
			}
			
			int x = H-1;
			while(!queue.isEmpty()) {
				clone_map[x--][i] = queue.poll();
			}
		}

		
	}

}
