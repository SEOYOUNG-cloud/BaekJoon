package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek17142 {

	static int N, M, virus_size;
	static int[][] map, map_clone;
	static ArrayList<int[]> virus;
	static int answer=Integer.MAX_VALUE;
	static int[][] use_virus;
	static int vir_cnt=0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		map_clone = new int[N][N];
		use_virus = new int[M][2];
		virus = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int in = Integer.parseInt(st.nextToken());
				map[i][j] = in;
				if(in == 2) {
					virus.add(new int[] {i,j});
				} else if(in == 0) vir_cnt++;
			}
		}
		virus_size = virus.size();
		
		// 입력 끝 //
		comb(0,0);
		if(answer == Integer.MAX_VALUE) System.out.println("-1");
		else
			System.out.println(answer);
	}
	private static void comb(int cnt, int start) {
		if(cnt == M) {
			for(int i=0; i<N; i++)
				map_clone[i] = map[i].clone();
			bfs();
			return;
		}
		for(int i=start; i<virus_size; i++) {
			use_virus[cnt][0] = virus.get(i)[0];
			use_virus[cnt][1] = virus.get(i)[1];
			comb(cnt+1, i+1);
		}
		
	}
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0; i<M; i++)
			queue.offer(new int[] {use_virus[i][0], use_virus[i][1]});
		
		int cnt=-1;
		boolean[][] visited = new boolean[N][N];

		while(!queue.isEmpty()) {
			int size = queue.size();
			cnt += 1;
			
			if(conf()) {
				answer = Math.min(answer, cnt);
				return;
			}
		
			while(size-->0) {
				int[] out = queue.poll();
				int x = out[0];
				int y = out[1];
				visited[x][y] = true;
			
				for(int d=0; d<4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || map_clone[nx][ny] == 1 || visited[nx][ny]) continue;
					map_clone[nx][ny] = 2;
					
					visited[nx][ny] = true;
					
					queue.add(new int[] {nx, ny});
				}
			}	
		}
		if(conf())
			answer = Math.min(answer, cnt);
		
	}
	private static boolean conf() {
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				if(map_clone[i][j] == 0)
					return false;
		return true;
	}

}

