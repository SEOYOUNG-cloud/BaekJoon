package BaekJoon;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main_BJ_20920_영단어암기는괴로워 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			if(input.length() < M) continue;
			
			int value = map.getOrDefault(input, 0);
			map.put(input, value+1);
		}
		
		/* */
		ArrayList<String> lists = (ArrayList<String>) map.keySet().stream().collect(Collectors.toList());
		
		lists.sort((o1,o2) -> {
			int v1 = map.get(o1);
			int v2 = map.get(o2);
			
			if(v1 == v2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o2.length() - o1.length();
			}
			return v2-v1;
		});
		
		StringBuilder sb = new StringBuilder();
		for(String list : lists) {
			sb.append(list).append('\n');
		}
		
		System.out.println(sb.toString());
		
	}

}
