package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1260_UseList {

	static List<Integer>[] list;
	static int N, V;
	static StringBuilder sb = new StringBuilder();
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new List[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}	
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
			
		for(int i=0; i<=N; i++)
			Collections.sort(list[i]);
			
		visited = new boolean[N+1];
		dfs(V);
		sb.append('\n');
		
		visited = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb);
		

	}
	private static void dfs(int V) {
		visited[V] = true;
		sb.append(V).append(" ");
		
		for(int i=0; i<list[V].size(); i++) {
			if(!visited[list[V].get(i)]) {
				dfs(list[V].get(i));
			}
		}
	}
	
	private static void bfs(int V) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int out = queue.poll();
			sb.append(out).append(" ");
			
			for(int i=0; i<list[out].size(); i++) {
				if(!visited[list[out].get(i)]) {
					
					visited[list[out].get(i)] = true;
					queue.add(list[out].get(i));
				}
			}
		}
	}

}
