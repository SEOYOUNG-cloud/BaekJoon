package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1753_최단경로 {
	
	static class Edge implements Comparable<Edge>{
		int V, weight;

		public Edge(int v, int weight) {
			super();
			V = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		ArrayList<Edge>[] list = new ArrayList[V+1];
		for(int i=0; i<=V; i++)
			list[i] = new ArrayList<>();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b, w));
		}
		
		// 다익스트라
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		Edge[] D = new Edge[V+1];
		
		for(int i=1; i<=V; i++) {
			if(i == start) {
				D[i] = new Edge(start, 0);
			} else {
				D[i] = new Edge(i, Integer.MAX_VALUE);
			}
			pq.add(D[i]);
		}
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(edge.weight == Integer.MAX_VALUE) break;
			
			for(Edge next : list[edge.V]) {
				// 방문했으면 지나감
				if(visited[next.V]) continue;
				
				if(D[next.V].weight > D[edge.V].weight + next.weight) {
					D[next.V].weight = D[edge.V].weight + next.weight;
					
					pq.remove(D[next.V]);
					pq.add(D[next.V]);
				}
			}
			
			// 방문체크
			visited[edge.V] = true;
		}
		
		for(int i=1; i<=V; i++) {
			int d = D[i].weight;
			if(d == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(D[i].weight);
		}
	}

}
