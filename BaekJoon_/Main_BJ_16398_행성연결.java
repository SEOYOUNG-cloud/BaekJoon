package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_16398_행성연결 { // 크루스칼 쓰면 10억이라서 프림 써야할듯

	static class Node{
		int idx, weight;
		Node next;

		public Node(int idx, int weight, Node next) {
			super();
			this.idx = idx;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [idx=" + idx + ", weight=" + weight + ", next=" + next + "]";
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
	
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Node[] nodeList = new Node[N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0) continue;
				nodeList[i] = new Node(j, map[i][j], nodeList[i]);
			}
		}
		
		int[] minVertex = new int[N];
		Arrays.fill(minVertex, Integer.MAX_VALUE);
		minVertex[0] = 0;
		boolean[] visited = new boolean[N];
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		pq.offer(new Vertex(0, 0));
		
		long result = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			Vertex now = pq.poll();
			
			if(visited[now.idx]) continue;
			visited[now.idx] = true;
			result += now.weight;
			if(++cnt == N) break;
			
			for(Node temp=nodeList[now.idx]; temp!=null; temp=temp.next) {
				if(!visited[temp.idx] && minVertex[temp.idx] > temp.weight) {
					minVertex[temp.idx] = temp.weight;
					pq.offer(new Vertex(temp.idx, temp.weight));
				}
			}
		}
		
		System.out.println(result);
		

	}

}
