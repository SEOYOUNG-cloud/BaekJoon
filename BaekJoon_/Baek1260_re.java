package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Bj_1260_DFS와BFS_박서영 {

	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 정점
		int M = Integer.parseInt(st.nextToken()); // 간선
		int V = Integer.parseInt(st.nextToken()); // 시작점
		
		for(int i=0; i<N+1; i++)
			list.add(new ArrayList<>());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list.get(to).add(from);
			list.get(from).add(to);
		}
		for(int i=0; i<N+1; i++)
			Collections.sort(list.get(i));		
		
		visited = new boolean[N+1];
		dfs(V);
		sb.append('\n');
		visited = new boolean[N+1];
		bfs(V);
		System.out.println(sb);
		
		br.close();
	}
	
	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");
		
		for(int i=0; i<list.get(v).size(); i++) {
			if(!visited[list.get(v).get(i)]) {
				visited[list.get(v).get(i)] = true;
				dfs(list.get(v).get(i));
			}
		}
		
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
//			System.out.println(queue);
			int q = queue.poll();
			sb.append(q + " ");
			
			for(int i=0; i<list.get(q).size(); i++) {
				if(!visited[list.get(q).get(i)]) {
					visited[list.get(q).get(i)] = true;
					queue.offer(list.get(q).get(i));
				}
			}
		}
		sb.append('\n');
		
	}
	

}
