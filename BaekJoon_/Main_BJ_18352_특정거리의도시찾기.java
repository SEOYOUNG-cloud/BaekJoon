package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_18352_특정거리의도시찾기 {

	static class Node{
		int idx, cost;

		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 도시 개수 V
		int M = Integer.parseInt(st.nextToken()); // 도로 개수 E
		int K = Integer.parseInt(st.nextToken()); // 거리 정보
		int X = Integer.parseInt(st.nextToken()); // 출발 도시 번호
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		for(int i=0; i<N+1; i++)
			graph.add(new ArrayList<>());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Node(to, 1));
		}
		
		int[] dist = new int[N+1];
		for(int i=0; i<=N; i++)
			dist[i] = Integer.MAX_VALUE;
		dist[X] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.offer(new Node(X, 0));
		
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
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			if(dist[i] == K) answer.add(i);
		}
		Collections.sort(answer);
		
		if(answer.size() == 0) System.out.println("-1");
		else {
			for(int i=0; i<answer.size(); i++)
				System.out.println(answer.get(i));
		}

	}

}
