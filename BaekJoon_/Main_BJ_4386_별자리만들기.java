package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_4386_별자리만들기 { // 간선이 최대 100!개라서 prim 써야함 (정점 100개)

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
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int V = Integer.parseInt(br.readLine());
		double[][] map = new double[V][2];
		
		Node[] node = new Node[V];
		for(int i=0; i<V; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Double.parseDouble(st.nextToken());
			map[i][1] = Double.parseDouble(st.nextToken());
		}
		
		for(int i=0; i<V-1; i++) {
			double x = map[i][0];
			double y = map[i][1];
			for(int j=i+1; j<V; j++) {
				double nx = map[j][0];
				double ny = map[j][1];
				
				double calc = Math.sqrt(((x-nx)*(x-nx) + (y-ny)*(y-ny)));
				double dis = Math.round(calc * 100)/100.0;
				
				node[i] = new Node(j, dis, node[i]);
				node[j] = new Node(i, dis, node[j]);
			}
		}
		
		double minVertex[] = new double[V];
		Arrays.fill(minVertex, Integer.MAX_VALUE);
		minVertex[0] = 0.0;
		boolean visited[] = new boolean[V];
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>((o1, o2)->Double.compare(o1.weight, o2.weight));
		pq.offer(new Vertex(0, 0.0));
		
		double result = 0.0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			Vertex now = pq.poll();
			
			if(visited[now.idx]) continue;
			visited[now.idx] = true;
			result += now.weight;
			if(++cnt == V) break;
			
			for(Node temp=node[now.idx]; temp!=null; temp=temp.next) {
				if(!visited[temp.idx] && minVertex[temp.idx] > temp.weight) {
					minVertex[temp.idx] = temp.weight;
					pq.offer(new Vertex(temp.idx, temp.weight));
				}
			}
		}
		
		System.out.println(result);
	}

}
