package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class sw3124_prim_priorityQueue {
	
	static class Node{
		int no, weight;
		Node next;
		public Node(int no, int weight, Node next) {
			super();
			this.no = no;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex{
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
	}
	
	static int V,E;
	static Node list[];
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점
			E = Integer.parseInt(st.nextToken()); // 간선
			
			list = new Node[V+1];
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				list[a] = new Node(b,weight,list[a]);
				list[b] = new Node(a,weight,list[b]);
			}
			
			// 입력 끝 //
			sb.append("#").append(tc).append(" ").append(prim()).append('\n');
			
		}
		System.out.println(sb.toString());
	}
		
	private static long prim() {
		int cnt = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
		boolean visited[] = new boolean[V+1];

		long result = 0;
		
		pq.offer(new Vertex(1,0));
		
		while(!pq.isEmpty()) {
			Vertex q = pq.poll();
			if(visited[q.no]) continue;
			
			visited[q.no] = true;
			result += q.weight;
			if(++cnt == V) break;
			
			for(Node n=list[q.no]; n != null; n=n.next) {
				if(!visited[n.no]) {
					pq.offer(new Vertex(n.no, n.weight));
				}
			}
		}
		
		return result;
	}

}
