package BaekJoon;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main_BJ_17140_이차원배열과연산 {
	
	static class Node implements Comparable<Node>{
		int number, count; // 등장 횟수, 숫자 
		
		public Node(int number, int count) {
			super();
			this.number = number;
			this.count = count;
		}

		// 수의 등장 횟수가 적은 것, 수가 작은 것 순서로 정렬 
		@Override
        public int compareTo(Node o) {
            if (this.count > o.count) {
                return 1;
            } else if (this.count == o.count) {
                return this.number - o.number;
            } else {
                return -1;
            }
		}
           

		@Override
		public String toString() {
			return "Node [number=" + number + ", count=" + count + "]";
		}
	}
	
	static int[][] map;
	static int r=3, c=3;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[100][100];
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/* 입력 끝 */
		for(int time=0; time<=100; time++) {
			// r,c가 k이면 끝낸다
			if(map[r-1][c-1] == k) {
				System.out.println(time);
				return;
			}
			
			 start();
		}
		System.out.println("-1");
	}
	
	private static void start() {
		if(r >= c) {
			for(int i=0; i<r; i++)
				R(i);
		}
		else {
			for(int i=0; i<c; i++)
				C(i);
		}
	}
	
	private static void R(int key) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Map<Integer, Integer> cnt = new HashMap<>();
		
		for(int i=0; i<r; i++) {
			if(map[key][i] == 0) continue;
			cnt.compute(map[key][i], (number, count) -> count == null ? 1 : count+1);
		}
		
		cnt.forEach((k,v) -> pq.offer(new Node(k, v)));
		
		int i=0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			map[key][i++] = node.number;
			map[key][i++] = node.count;
		}
		
		c = Math.max(c, i+1);
		
		while(i < 100) {
			map[key][i++] = 0;
			map[key][i++] = 0;
		}
	}
	
	private static void C(int key) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Map<Integer, Integer> cnt = new HashMap<>();
		
		for(int i=0; i<c; i++) {
			if(map[i][key] == 0) continue;
			cnt.compute(map[i][key], (number, count) -> count == null ? 1 : count+1);
		}
		
		cnt.forEach((k,v) -> pq.offer(new Node(k, v)));
		
		int i=0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			map[i++][key] = node.number;
			map[i++][key] = node.count;
		}
		
		r = Math.max(r, i+1);
		
		while(i < 100) {
			map[i++][key] = 0;
			map[i++][key] = 0;
		}
	}

}
