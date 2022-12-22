package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1260_DFS와BFS {
	
	static int N, M, V;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 시작 정점 번호
		
		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<N+1; i++)
			list.add(new ArrayList<>());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		for(int i=1; i<=N; i++)
			Collections.sort(list.get(i));
		
		///////////
		dfs(V, 0, new boolean[N+1]);
		sb.append('\n');
		
		bfs();
		System.out.println(sb.toString());
		
		
		
	}
	static StringBuilder sb = new StringBuilder();
	private static void dfs(int p, int cnt, boolean[] visited) {
		if(cnt == N) {
			return;
		}
		
		visited[p] = true;
		sb.append(p).append(" ");
		
		for(int i=0; i<list.get(p).size(); i++) {
			int out = list.get(p).get(i);
			if(!visited[out]) {
				dfs(out, cnt+1, visited);
			}
		}
	}
	private static void bfs() {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(V);
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int out = q.poll();
			
			if(visited[out]) continue;
			visited[out] = true;
			sb.append(out).append(" ");
			if(++cnt == N) return;
			
			for(int i=0; i<list.get(out).size(); i++) {
				int now = list.get(out).get(i);
				if(!visited[now]) {
					q.offer(now);
				}
			}
		}
	}

}
