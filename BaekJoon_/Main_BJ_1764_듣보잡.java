package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1764_듣보잡 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String in = br.readLine();
			if(set.contains(in)) list.add(in);
		}
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append('\n');
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append('\n');
		}
		
		System.out.println(sb.toString());

	}

}
