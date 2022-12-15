package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_9370_미확인도착지 {
	
	static class Node implements Comparable<Node>{
		int idx, cost;

		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [idx=" + idx + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // V
			int m = Integer.parseInt(st.nextToken()); // E
			int t = Integer.parseInt(st.nextToken()); // 목적지 후보 개수 
			
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 예술가의 출발지 
			int g = Integer.parseInt(st.nextToken()); // 거칠애 1
			int h = Integer.parseInt(st.nextToken()); // 거칠애 2
			
			ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
			for(int i=0; i<=n; i++)
				graph.add(new ArrayList<>());
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				graph.get(from).add(new Node(to, cost));
				graph.get(to).add(new Node(from, cost));
			}
			
			Set<Integer> set = new HashSet<>();
			// t개의 후보들 
			for(int i=0; i<t; i++) {
				set.add(Integer.parseInt(br.readLine()));
			}
			
			// 도로를 건너야 하는 곳이면 홀수, 아니면 짝수로 변경
			for(int i=1; i<=n; i++) {
				for(int j=0; j<graph.get(i).size(); j++) {
					Node in = graph.get(i).get(0);
					graph.get(i).remove(0);
					if((i == g && in.idx == h) || (in.idx == g && i == h)) {
						graph.get(i).add(new Node(in.idx, in.cost * 2 - 1));
					}
					else {
						graph.get(i).add(new Node(in.idx, in.cost * 2));
					}
				}
			}
			
			int[] dist = new int[n+1];
			for(int i=0; i<=n; i++)
				dist[i] = Integer.MAX_VALUE - 1;
			dist[s] = 0;
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(s, 0));
			
			while(!pq.isEmpty()) {
				Node now = pq.poll();
				if(now.cost > dist[now.idx]) continue;
				
				for(int i=0; i<graph.get(now.idx).size(); i++) {
					Node next = graph.get(now.idx).get(i);
					
					if(dist[next.idx] > now.cost + next.cost) {
						dist[next.idx] = now.cost + next.cost;
						pq.offer(new Node(next.idx, dist[next.idx]));
					}
				}
			}
			for(int i=1; i<=n; i++) {
				if(set.contains(i) && dist[i] % 2 == 1) sb.append(i).append(" ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());

	}

}
