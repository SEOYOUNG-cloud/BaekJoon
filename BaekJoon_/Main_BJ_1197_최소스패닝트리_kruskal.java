package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1197_최소스패닝트리_kruskal {
	
	static int V, E;
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		Edge edge[] = new Edge[E];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edge[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edge);
		
		parents = new int[V+1];
		for(int i=0; i<=V; i++)
			parents[i] = i;
		
		int result = 0;
		int cnt = 0;
		for(Edge e : edge) {
			if(union(e.from, e.to)) {
				result += e.weight;
				if(++cnt == V-1) break;
			}
		}
		
		System.out.println(result);
		

	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[aRoot] = bRoot;
		return true;
	}

}
