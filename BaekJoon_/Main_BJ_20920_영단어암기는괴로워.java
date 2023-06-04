package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_20920_영단어암기는괴로워 {
	
	static class Words implements Comparable<Words>{
		String word;
		int cnt;
		
		public Words(String word, int cnt) {
			this.word = word;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Words o) {
			if(this.cnt != o.cnt) return o.cnt - this.cnt;
			else if(o.word.length() != this.word.length()) return o.word.length() - this.word.length();
			return this.word.compareTo(o.word);
		}	
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			if(input.length() < M) continue;
			
			if(!map.containsKey(input)) {
				map.put(input, 1);
			} else {
				int value = map.get(input);
				map.replace(input, value+1);
			}
		}
		
		/* */
		ArrayList<Words> list = new ArrayList<>();
		map.forEach((key, value) -> {
			list.add(new Words(key, value));
		});
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(Words word : list) {
			sb.append(word.word).append('\n');
		}
		
		System.out.println(sb.toString());
		
	}

}
