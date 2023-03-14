package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1213_팰린드롬만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<input.length; i++) {
			map.merge(input[i], 1, (value, putValue) -> value+1);
		}

		List<Character> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);
		
		int odd = 0;
		Character middle = ' ';
		for(Character key : keySet) {
			Integer value = map.get(key);
			if(value % 2 == 1) {
				odd += 1;
				middle = key;
			}
			
			value /= 2;
			map.remove(key);
			
			if(value != 0)
				map.put(key, value);
		}
		
		if(odd > 1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);
		
		StringBuilder sb = new StringBuilder();
		for(Character key : keySet) {
			int value = map.get(key);
			for(int i=0; i<value; i++) {
				sb.append(key);
			}
		}
		
		if(odd == 1) {
			sb.append(middle);
		}
		
		Collections.sort(keySet, Collections.reverseOrder());
		for(Character key : keySet) {
			int value = map.get(key);
			for(int i=0; i<value; i++) {
				sb.append(key);
			}
		}
		
		System.out.println(sb.toString());
		

	}

}
