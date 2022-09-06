package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_탈주범검거 {

	static int N,M,R,C,L;
	static int[][] map;
	static ArrayList<int[]>[] structure = new ArrayList[7];
	static int answer;
	static boolean visited[][];
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_탈주범검거.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0; i<7; i++)
			structure[i] = new ArrayList<>();
		
		structure[0].add(new int[] {1,0});
		structure[0].add(new int[] {0,1});
		structure[0].add(new int[] {0,-1});
		structure[0].add(new int[] {-1,0});
		structure[1].add(new int[] {-1,0});
		structure[1].add(new int[] {1,0});
		structure[2].add(new int[] {0,1});
		structure[2].add(new int[] {0,-1});
		structure[3].add(new int[] {0,1});
		structure[3].add(new int[] {-1,0});
		structure[4].add(new int[] {1,0});
		structure[4].add(new int[] {0,1});
		structure[5].add(new int[] {0,-1});
		structure[5].add(new int[] {1,0});
		structure[6].add(new int[] {0,-1});
		structure[6].add(new int[] {-1,0});
		
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			answer = 0;
			visited = new boolean[N][M];
			
			map = new int[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					int in = Integer.parseInt(st.nextToken());
					map[i][j] = in-1;
				}
			}
			
			//입력끝//
			bfs();
			
			sb.append("#").append(tc).append(" ").append(answer).append('\n');
		}
		System.out.println(sb.toString());
		br.close();
	}
	
    private static void bfs() {
        boolean visited[][] = new boolean[N][M];
        visited[R][C] = true;
        answer += 1;
         
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] {R,C});
         
        int cnt = 0;
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	
        	cnt+=1;
        	if(cnt == L) return;
        	
        	
        	while(size-->0) {
	            int[] out = queue.poll();
	            int x = out[0];
	            int y = out[1];
	             
	            for(int d=0; d<structure[map[x][y]].size(); d++) {
	                int nx = x + structure[map[x][y]].get(d)[0];
	                int ny = y + structure[map[x][y]].get(d)[1];
	                 
	                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == -1) continue;
	                
	                for(int i=0; i<structure[map[nx][ny]].size(); i++) {
	    				if(structure[map[nx][ny]].get(i)[0] + nx == x
	    						&& structure[map[nx][ny]].get(i)[1] + ny == y) {
	    					queue.add(new int[] {nx,ny});
	    	                visited[nx][ny] = true;
	    	                answer += 1;
	    					break;
	    				}
	    			}
	            }
        	}
        }
    }
}
