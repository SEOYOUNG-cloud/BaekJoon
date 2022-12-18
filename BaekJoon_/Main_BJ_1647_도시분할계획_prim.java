package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1647_도시분할계획_prim { // prim O(ElogV + VlogV)

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
	}
	
	static int V, E;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		Node nodeList[] = new Node[V+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			nodeList[from] = new Node(to, weight, nodeList[from]);
			nodeList[to] = new Node(from, weight, nodeList[to]);
		}
		
		int[] min = new int[V+1];
		Arrays.fill(min, Integer.MAX_VALUE);
		min[1] = 0;
		
		boolean[] visited = new boolean[V+1];
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		pq.offer(new Vertex(1, 0));
		
		int result = 0;
		int cnt = 0;
		int max = Integer.MIN_VALUE;
		
		while(!pq.isEmpty()) {
			Vertex now = pq.poll();
			
			if(visited[now.idx]) continue;
			visited[now.idx] = true;
			result += now.weight;
			max = Math.max(now.weight, max);
			
			if(++cnt == V) break;
			
			for(Node temp=nodeList[now.idx]; temp!=null; temp=temp.next) {
				if(!visited[temp.idx] && min[temp.idx] > temp.weight) {
					min[temp.idx] = temp.weight;
					pq.offer(new Vertex(temp.idx, temp.weight));
				}
			}
		}
		
		System.out.println(result - max);
		
	}
}
