package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baek1697 { // BFS
	public static int N, K;
	public static int count[] = new int[100001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N == K) System.out.println("0");
		else
			bfs(N);
	}
	
	public static void bfs(int N) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		count[N] = 1;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int i = 0; i < 3; i++) {
				int next = 0;
				
				if(i == 0) next = temp + 1;
				else if(i == 1) next = temp - 1;
				else next = temp * 2;
				
				if(next == K) {
					System.out.println(count[temp]);
					return;
				}
				
				if(next >= 0 && next <= 100000 && count[next] == 0) {
					queue.offer(next);
					count[next] = count[temp] + 1;
				}
				
			}
		}
	}
}
