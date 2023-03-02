package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1927_최소힙 {

	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int cmd = Integer.parseInt(br.readLine());
			if(cmd == 0) {
				if(pq.isEmpty()) {
					sb.append("0").append('\n');
				} else {
					sb.append(pq.poll()).append('\n');
				}
			} else {
				pq.offer(cmd);
			}
		}
		
		System.out.println(sb.toString());

	}

}
