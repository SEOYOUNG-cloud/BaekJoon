package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1181_단어정렬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<String> str = new ArrayList<>();
		for(int i=0; i<N; i++) {
			str.add(br.readLine());
		}
		///////
		HashSet<String> set = new HashSet<>(str);
		ArrayList<String> newStr = new ArrayList<>(set);
		
		Collections.sort(newStr, (o1, o2) -> {
			if(o1.toString().length() == o2.toString().length()) {
				return o1.compareTo(o2);
			} else {
				return o1.toString().length() - o2.toString().length();
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<newStr.size(); i++)
			sb.append(newStr.get(i)).append('\n');
		
		System.out.println(sb.toString());
	}

}
