package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리_크루스칼_박서영 {
	static class Edge implements Comparable<Edge>{
		int x, y, weight;

		public Edge(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}

	static int V,E;
	static ArrayList<Edge> list;
	static int parents[];
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점
			E = Integer.parseInt(st.nextToken()); // 간선
			
			list = new ArrayList<>();
			parents = new int[V+1];
			for(int i=1; i<=V; i++)
				parents[i] = i;
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				list.add(new Edge(a,b,weight));
			}
			
			// 가중치 기준으로 정렬
			Collections.sort(list);

			int result = 0;
			for(int i=0; i<E; i++) {
				if(union(list.get(i).x, list.get(i).y)) result += list.get(i).weight;
			}
			
			sb.append("#").append(tc).append(" ").append(result).append('\n');
			
			
		}
		System.out.println(sb.toString());

	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

}
