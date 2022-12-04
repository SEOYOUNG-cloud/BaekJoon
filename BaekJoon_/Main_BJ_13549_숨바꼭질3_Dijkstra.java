package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_13549_숨바꼭질3_Dijkstra {
	
	static int start, end;
	static int INF = 200001;
	static class Node{
		int idx, cost;

		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		/////////
		int dist[] = new int[INF]; // v: 위치, E: 간선이 cnt
		for(int i=0; i<INF; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.idx == end) {
				System.out.println(dist[end]);
				return;
			}
			
			if(dist[now.idx] < now.cost) continue; // 최소거리 찾는거니께 
			
			// 선택한 노드의 주변 노드 고려하기!
			// 선택한 노드에서 밖으로 나가는 노드는 무조건 3개임 +1, -1, *2
			if(now.idx+1 < INF && (dist[now.idx+1] > now.cost + 1)) {
				dist[now.idx+1] = now.cost+1;
				pq.offer(new Node(now.idx+1, dist[now.idx+1]));
			}
			if(now.idx-1 >= 0 && (dist[now.idx-1] > now.cost + 1)) {
				dist[now.idx-1] = now.cost+1;
				pq.offer(new Node(now.idx-1, dist[now.idx-1]));
			}
			if(now.idx*2 < INF && (dist[now.idx*2] > now.cost)) {
				dist[now.idx*2] = now.cost;
				pq.offer(new Node(now.idx*2, dist[now.idx*2]));
			}
		}
	}

}
