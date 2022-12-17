package BaekJoon;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main_BJ_1197_최소스패닝트리_Prim {
	
	static int V, E;
	static class Node{
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", next=" + next + "]";
		}
		
	}
	static class Vertex{
		int idx, weight;

		public Vertex(int idx, int weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		Node node[] = new Node[V+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			node[from] = new Node(to, weight, node[from]);
			node[to] = new Node(from, weight, node[to]);
		}
		
		int minVertex[] = new int[V+1];
		Arrays.fill(minVertex, Integer.MAX_VALUE);
		minVertex[1] = 0;
		boolean visited[] = new boolean[V+1];
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		pq.offer(new Vertex(1, 0));
		
		int result = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			Vertex now = pq.poll();
			
			if(visited[now.idx]) continue;
			visited[now.idx] = true;
			result += now.weight;
			if(++cnt == V) break;
			
			for(Node n=node[now.idx]; n != null; n=n.next) {
				if(!visited[n.vertex] && (minVertex[n.vertex] > n.weight)) {
					minVertex[n.vertex] = n.weight;
					pq.offer(new Vertex(n.vertex, n.weight));
				}
			}
		}
		
		System.out.println(result);

	}

}
