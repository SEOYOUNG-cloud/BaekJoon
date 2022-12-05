package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1238_파티 {

	static class Node{
		int idx, weight;

		public Node(int idx, int weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}
	}
	static int V, E, X; // N 정점, M 간선, X 파티장소
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static int max_time = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<Node>());
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Node(to, weight));
		}
		
		for(int i=1; i<=V; i++) {
			// 오고 가는 시간이 가장 많은 학생 번호!
			if(i == X) continue;
			int[] dist = new int[V+1];
			for(int j=1; j<=V; j++)
				dist[j] = Integer.MAX_VALUE;
			
			int total = dijkstra(i, X, dist);
			
			for(int j=1; j<=V; j++)
				dist[j] = Integer.MAX_VALUE;
			
			total += dijkstra(X, i, dist);
			if(total > max_time) {
				max_time = total;
			}
		}
		
		System.out.println(max_time);

	}
	private static int dijkstra(int start, int end, int[] dist) {
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.idx == end) {
				return dist[now.idx];
			}
			if(dist[now.idx] < now.weight) continue;
			
			for(int i=0; i<graph.get(now.idx).size(); i++) {
				Node next = graph.get(now.idx).get(i);
				
				if(dist[next.idx] > now.weight + next.weight) {
					dist[next.idx] = now.weight + next.weight;
					pq.add(new Node(next.idx, dist[next.idx]));
				}
			}
			
		}
		
		return dist[end];
	}

}
