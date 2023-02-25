package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1202_보석도둑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 보석 개수
		int K = Integer.parseInt(st.nextToken()); // 가방 개수

		int[][] jewel = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 보석 무게
			int V = Integer.parseInt(st.nextToken()); // 보석 가격
			
			jewel[i][0] = M;
			jewel[i][1] = V;
		}
		
		int[] bag = new int[K];
		for(int i=0; i<K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		/* 입력 끝 */
		// 1. 보석은 무게 순 오름차순, 가격 순 내림차순 한다.
		Arrays.sort(jewel, (o1, o2) -> o1[0]!=o2[0] ? o1[0]-o2[0] : o2[1]-o1[1]);
		
		// 2. 가방은 오름차순 정렬한다.
		Arrays.sort(bag);
		
		// 3. 가방을 훑으면서 넣을 수 있는 보석이라면 pq에 넣는다.
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
		long answer = 0;
		for(int i=0, j=0; i<K; i++) {
			int bagM = bag[i];
			while(j < N && bagM >= jewel[j][0]) {
				pq.offer(jewel[j++][1]);
			}
			
			if(!pq.isEmpty()) answer += pq.poll();
		}
		
		System.out.println(answer);
		

	}

}
