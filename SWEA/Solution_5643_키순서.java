package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서 {
	
	static int N,M;
	static ArrayList[] list;

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			list = new ArrayList[N+1];
			
			for(int i=0; i<=N; i++)
				list[i] = new ArrayList<>();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
			}
			
			// 입력 끝 //
			
			
			boolean[][] visited = new boolean[N+1][N+1];
			Queue<Integer> queue = new ArrayDeque<>();
			for(int i=1; i<=N; i++)
				for(int j=1; j<=N; j++)
					if(i==j) visited[i][j] = true;
			
				 
			for(int i=1; i<=N; i++) {
				
				queue.add(i);
				
				while(!queue.isEmpty()) {
					int x = queue.poll();
					
					for(int i1=0; i1<list[x].size(); i1++) {
						int y = (int) list[x].get(i1); // 연결되는 수
						if(visited[i][y]) continue;
						
						visited[i][y] = true;
						visited[y][i] = true;
						queue.add(y);
					}
				}
				
			}
			
			int answer = 0;
			for(int i=1; i<=N; i++) {
				int count = 0;
				for(int j=1; j<=N; j++) {
					if(visited[i][j]) count+=1;
				}
				if(count == N) answer += 1;
			}
					
			
			sb.append("#").append(tc).append(" ").append(answer).append('\n');
		}
		
		System.out.println(sb.toString());
		

	}

}
