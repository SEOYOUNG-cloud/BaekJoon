package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1504_특정한최단경로 {
	
	static class Node{
		int idx, weight;

		public Node(int idx, int weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [idx=" + idx + ", weight=" + weight + "]";
		}
	}
	static int N, E; // 정점, 간선
	static ArrayList<ArrayList<Node>> graph; // 간선 저장 그래프
	static int a, b; // 반드시 거쳐야하는 점 a,b

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new ArrayList<ArrayList<Node>>();
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Node(to, w));
			graph.get(to).add(new Node(from, w));
		}
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		/// 입력 끝 ////
		// 1. 1 -> a -> b -> N
		int answer = 0;
		int path1toA = dijkstra(1, a);
		int pathAtoB = dijkstra(a, b);
		int pathBtoN = dijkstra(b, N);
		if(path1toA != -1 && pathAtoB != -1 && pathBtoN != -1) answer = path1toA + pathAtoB + pathBtoN;
		
		int path1toB = dijkstra(1, b);
		int pathBtoA = dijkstra(b, a);
		int pathAtoN = dijkstra(a, N);
		if(path1toB != -1 && pathBtoA != -1 && pathAtoN != -1) answer = Math.min(answer, path1toB + pathBtoA + pathAtoN);
		
		if(answer == 0) System.out.println("-1");
		else System.out.println(answer);

	}
	private static int dijkstra(int start, int end) {
		// 다익스트라 구현하기
		int[] dist = new int[N+1];
		for(int i=0; i<N+1; i++)
			dist[i] = Integer.MAX_VALUE;
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1.weight, o2.weight));
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.weight > dist[now.idx]) continue;
			
			if(now.idx == end) {
				return dist[now.idx];
			}
			
			for(int i=0; i<graph.get(now.idx).size(); i++) {
				Node next = graph.get(now.idx).get(i);
				if(dist[next.idx] > now.weight + next.weight) {
					dist[next.idx] = now.weight + next.weight;
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		
		return -1;
	}

}
