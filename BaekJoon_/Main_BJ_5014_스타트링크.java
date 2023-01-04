package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_5014_스타트링크 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken()); // 최고층 
		int S = Integer.parseInt(st.nextToken()); // 지금 있는 
		int G = Integer.parseInt(st.nextToken()); // 이동하려는 층 
		int U = Integer.parseInt(st.nextToken()); // 위로 
		int D = Integer.parseInt(st.nextToken()); // 아래로 
		
		int dx[] = {(-1)*D, U};
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(S);
		
		int result = -1;
		boolean visited[] = new boolean[F+1];
		while(!q.isEmpty()) {
			int size = q.size();
			result += 1;
			while(size --> 0) {
				int out = q.poll();
				
				if(out == G) {
					System.out.println(result);
					return;
				}
				if(visited[out]) continue;
				visited[out] = true;
				
				for(int d=0; d<2; d++) {
					int temp = out + dx[d];
					if(temp > F || temp <= 0 || visited[temp]) continue;
					
					q.offer(temp);
				}
			}
		}
		
		System.out.println("use the stairs");

	}

}
