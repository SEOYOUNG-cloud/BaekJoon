package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_10816_숫자카드2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<N; i++) {
			int in = Integer.parseInt(st.nextToken());
			if(map.containsKey(in)) {
				int value = map.get(in);
				map.put(in, value+1);
			} else {
				map.put(in, 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int in = Integer.parseInt(st.nextToken());
			if(map.containsKey(in)) {
				sb.append(map.get(in)).append(" ");
			} else
				sb.append("0 ");
		}
		
		System.out.println(sb.toString());

	}

}
