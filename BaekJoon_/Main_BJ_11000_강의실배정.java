package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_11000_강의실배정 {
	
	static class time implements Comparable<time>{
		int start, end;

		public time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(time o) {
			return this.start - o.start; // 시작 시간으로 정렬
		}

		@Override
		public String toString() {
			return "time [start=" + start + ", end=" + end + "]";
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<time> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.add(new time(start, end));
		}
		
		Collections.sort(list);
		
		/* 입력 끝 */
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
		pq.add(list.get(0).end);
		
		for(int i=1; i<N; i++) {
			System.out.println(pq);
			int peek = pq.peek();
			if(peek > list.get(i).start) pq.add(list.get(i).end);
			else {
				pq.poll();
				pq.add(list.get(i).end);
			}
		}
		
		System.out.println(pq.size());
		

	}

}
