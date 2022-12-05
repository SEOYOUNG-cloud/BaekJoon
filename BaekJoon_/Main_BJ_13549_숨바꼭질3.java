package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_13549_숨바꼭질3 {
	// 1초에 갈 수 있는거: x-1, x+1, 2*x
	// end까지 도달해야함 
	// dp인듯 
	
	static int start, end;
	static int INF = 200001;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		/////
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1])); // 현재 위치, cnt
		queue.add(new int[] {start, 0});
		
		boolean visited[] = new boolean[INF];
//		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int out[] = queue.poll();
			int idx = out[0];
			int cnt = out[1];
			
			if(idx == end) {
				System.out.println(cnt);
				return;
			}
			visited[idx] = true;
			
			// x+1
			if(idx+1 < INF && !visited[idx+1]) {
				queue.add(new int[] {idx+1, cnt+1});
			}
			
			// x-1
			if(idx-1 >= 0 && !visited[idx-1]) {
				queue.add(new int[] {idx-1, cnt+1});
			}
			
			// x*2
			if(idx*2 < INF && !visited[idx*2]) {
				queue.add(new int[] {idx*2, cnt});
			}
		}
		
	}
}
