package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_등산로조성_박서영 {

	static int N, K;
	static int[][] map;
	static ArrayList<int[]> maxList;
	static int answer;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_등산로.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			maxList = new ArrayList<>();
			answer=Integer.MIN_VALUE;
			
			int max = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int in = Integer.parseInt(st.nextToken());
					map[i][j] = in;
					if(max < in) {
						maxList.clear();
						maxList.add(new int[] {i,j});
						max = in;
					} else if(max == in)
						maxList.add(new int[] {i,j});
				}
			}
			// 입력 끝 //
			for(int i=0; i<maxList.size(); i++) {
				// 시작점 x,y
				int x = maxList.get(i)[0];
				int y = maxList.get(i)[1];
				
				for(int j=0; j<N; j++) {
					for(int k=0; k<N; k++) {
						if(j==x && k==y) continue; // 시작점이면 안깎음
						int[][] clone = new int[N][N];
						
						for(int cut=1; cut<=K; cut++) {
							for(int c=0; c<N; c++) {
								clone[c] = map[c].clone();
							}
							clone[j][k] -= cut;
							
//							System.out.println();
//							for(int q=0; q<N; q++)
//								System.out.println(Arrays.toString(clone[q]));
							bfs(x,y,clone);
						}
						
					}
				}
				
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append('\n');
		}
		System.out.println(sb.toString());
	}
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	private static void bfs(int startX, int startY, int[][] map) {		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {startX, startY});
		
		int cnt=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			cnt+=1;
			while(size-->0) {
				int[] out = queue.poll();
				int x = out[0];
				int y = out[1];
				
				for(int d=0; d<4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] >= map[x][y]) continue;
					queue.offer(new int[] {nx,ny});
				}
			}
		}
		answer = Math.max(answer, cnt);
		
		
	}


}
