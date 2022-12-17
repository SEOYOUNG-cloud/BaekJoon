package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1922_네트워크연결_Prim {
	
	static class Node{
		int idx, weight;
		Node next;

		public Node(int idx, int weight, Node next) {
			super();
			this.idx = idx;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex{
		int idx, weight;

		public Vertex(int idx, int weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Vertex [idx=" + idx + ", weight=" + weight + "]";
		}
	}
	static int V, E;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		Node node[] = new Node[V+1];
		
		for(int i=0; i<E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			node[from] = new Node(to, weight, node[from]);
			node[to] = new Node(from, weight, node[to]);
		}
		
		int minVertex[] = new int[V+1];
		Arrays.fill(minVertex, Integer.MAX_VALUE);
		minVertex[1] = 0;
		
		boolean[] visited = new boolean[V+1];
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
			
			for(Node temp=node[now.idx]; temp!=null; temp=temp.next) {
				if(!visited[temp.idx] && (minVertex[temp.idx] > temp.weight)) {
					minVertex[temp.idx] = temp.weight;
					pq.offer(new Vertex(temp.idx, temp.weight));
				}
			}
		}
		
		System.out.println(result);
	}

}
