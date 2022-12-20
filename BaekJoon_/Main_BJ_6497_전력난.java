package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_6497_전력난 {

	static class Node{
		int from, to, weight;

		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
	}
	static int V, E;
	static Node[] nodeList;
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
		
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			if(V==0 && E==0) break;
			
			nodeList = new Node[E];
			int way = 0;
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				nodeList[i] = new Node(from, to, weight);
				way += weight;
			}
			Arrays.sort(nodeList, (o1,o2)->Integer.compare(o1.weight, o2.weight));
			
			
			parents = new int[V];
			for(int i=0; i<V; i++)
				parents[i] = i;
			
			int result = 0;
			int cnt = 0;
			for(Node node : nodeList) {
				if(union(node.from, node.to)) {
	//				System.out.println("연결: " + node.from +" -> " + node.to);
					result += node.weight;
					if(++cnt == V-1) break;
				}
			}
			
			sb.append(way - result).append('\n');
		}
		
		System.out.println(sb.toString());

	}
	static int[] parents;
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
