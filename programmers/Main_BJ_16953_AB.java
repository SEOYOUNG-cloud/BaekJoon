package BaekJoon;

import java.io.*;
import java.util.*;

public class Main_BJ_16953_AB {
	static class Node implements Comparable<Node>{
		long value, cnt;
		
		public Node(long value, long cnt) {
			this.value = value;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return (int) (this.cnt - o.cnt);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		if(A==B) {
			System.out.println("0");
			return;
		}
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(A, 1));
		
		while(!queue.isEmpty()) {
			Node out = queue.poll();
			if(out.value == B) {
				System.out.println(out.cnt);
				return;
			}
			if(out.value * 2 <= B && out.value*2 >= 0) {
				queue.offer(new Node(out.value * 2, out.cnt+1));
			}
			if(out.value*10+1 <= B && out.value*10+1 >= 0) {
				queue.offer(new Node(out.value*10+1, out.cnt+1));
			}
		}
		
		System.out.println("-1");
		
	}
}
