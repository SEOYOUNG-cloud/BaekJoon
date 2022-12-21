package BaekJoon;

import java.util.*;
import java.io.*;

/**
 * 기존 MST와 비슷한데 M-W를 번갈아가며 연결해야 한다.
 * 시간 복잡도를 고려했을 때 프림이 더 낫지만.. 둘 다 가능함
 * 프림으로 풀겠음
 * 간선을 저장할 때 W-M 으로 연결된 간선만 저장함 
 * */

public class Main_BJ_14621_나만안되는연애 {
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
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int[] g = new int[V+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<V+1; i++) {
			char in = st.nextToken().charAt(0);
			if(in == 'M')
				g[i] = 0;
			else
				g[i] = 1;
		}
		
		Node nodeList[] = new Node[V+1];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if(g[to] != g[from]) {
				nodeList[to] = new Node(from, weight, nodeList[to]);
				nodeList[from] = new Node(to, weight, nodeList[from]);
			}
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
			if(++cnt == V) {
				System.out.println(result);
				return;
			}
			
			for(Node temp=nodeList[now.idx]; temp!=null; temp=temp.next) {
				if(!visited[temp.idx] && minVertex[temp.idx] > temp.weight) {
					minVertex[temp.idx] = temp.weight;
					pq.offer(new Vertex(temp.idx, temp.weight));
				}
			}
		}
		System.out.println("-1");
	}

}
