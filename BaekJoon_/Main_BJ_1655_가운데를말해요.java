package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1655_가운데를말해요 {

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minPQ = new PriorityQueue<>(); // 최소 힙
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1,o2) -> o2-o1); // 최대 힙
		
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			int minSize = minPQ.size();
			int maxSize = maxPQ.size();
			
			// 1. 우선순위 큐의 크기가 같다면 최대 큐에 넣어주고 다르면 min에 넣음
			if(minSize == maxSize)
				maxPQ.offer(num);
			else
				minPQ.offer(num);
			
			// 2. 양쪽 다 비어있지 않고 최대 큐의 root값이 더 크면 최소 큐의 root값과 자리 바꿈
			if(!minPQ.isEmpty() && !maxPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
				int maxTemp = maxPQ.poll();
				int minTemp = minPQ.poll();
				
				maxPQ.offer(minTemp);
				minPQ.offer(maxTemp);
			}
			
			// 3. maxPQ의 root값이 가운데 값임
			sb.append(maxPQ.peek()).append('\n');
		}
		System.out.println(sb.toString());
	}

}
