package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1715_카드정렬하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++)
			pq.offer(Integer.parseInt(br.readLine()));
		
		/* 입력 끝 */
		int answer = 0;
		while(pq.size() != 1) {
			int a = pq.poll();
			int b = pq.poll();
			answer += (a+b);
			pq.offer(a+b);
		}
		
		System.out.println(answer);

	}

}
