package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1916_최소비용구하기 {

	static class Node{
		int idx, cost;

		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception{
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine()); // 정점 수
		int E = Integer.parseInt(br.readLine()); // 간선 수
		
		// 초기화
		for(int i=0; i<V+1; i++)
			graph.add(new ArrayList<Node>());
		
		int[] dist = new int[V+1]; // 최소 비용을 저장할 배열
		// 최대로 초기화 해둠
		for(int i=0; i<V+1; i++)
			dist[i] = Integer.MAX_VALUE;
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Node(to, weight));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); // 시작점
		int end = Integer.parseInt(st.nextToken()); // 끝점
		
		//// 입력 끝 /////
		// 다익스트라 구현
		// 비용 기준으로 pq 구현
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2) -> Integer.compare(o1.cost, o2.cost));
		
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll(); // 현재노드
			
			// 현재 인덱스가 end 지점이라면 끝낸다.
			if(now.idx == end) {
				System.out.println(dist[now.idx]);
				return;
			}
			
			// 현재 가중치가 dist에 기록된 것보다 크다면 고려하지 않고 넘어간다.
			if(now.cost > dist[now.idx]) continue;
			
			// 선택한 노드의 주변 노드를 고려하기
			for(int i=0; i<graph.get(now.idx).size(); i++) {
				Node next = graph.get(now.idx).get(i);
				
				if(dist[next.idx] > now.cost + next.cost) {
					dist[next.idx] = now.cost + next.cost;
					pq.add(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		
		
	}

}
