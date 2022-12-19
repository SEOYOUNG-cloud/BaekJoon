package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1774_우주신과의교감 {
	
	static class Node{
		int idx;
		double weight;
		Node next;

		public Node(int idx, double weight, Node next) {
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
		int idx;
		double weight;

		public Vertex(int idx, double weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}
	}
	
	static int N, M;
	static Node[] nodeList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // V
		M = Integer.parseInt(st.nextToken()); // E
		
		long map[][] = new long[N+1][2];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Long.parseLong(st.nextToken());
			map[i][1] = Long.parseLong(st.nextToken());
		}
		
		nodeList = new Node[N+1];		
		
		for(int i=1; i<N; i++) {
			long x = map[i][0];
			long y = map[i][1];
			for(int j=i+1; j<=N; j++) {
				long nx = map[j][0];
				long ny = map[j][1];
				
				long a = (x-nx)*(x-nx);
				long b = (y-ny)*(y-ny);
				double dis = Math.sqrt(a + b);
				
				nodeList[i] = new Node(j, dis, nodeList[i]);
				nodeList[j] = new Node(i, dis, nodeList[j]);
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodeList[x] = new Node(y, 0, nodeList[x]);
			nodeList[y] = new Node(x, 0, nodeList[y]);
		}
		
		///////
		System.out.printf("%.2f", prim(1));


	}
	private static double prim(int start) {
		double[] minVertex = new double[N+1];
		Arrays.fill(minVertex, Double.MAX_VALUE);
		minVertex[start] = 0.0;
		
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> (double)o.weight));
		pq.offer(new Vertex(start, 0.0));
		
		double result = 0;
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
		
		return result;
	}

}
