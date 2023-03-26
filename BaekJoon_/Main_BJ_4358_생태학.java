package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_4358_생태학 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double n = 0;
		Map<String, Integer> map = new HashMap<>();
		while(true) {
			String key = br.readLine();
			if(key == null || key.equals("")) break;
			n++;
			
			if(map.containsKey(key)) {
				int v = map.get(key);
				map.put(key, v+1);
			} else {
				map.put(key, 1);
			}
		}
		StringBuilder sb = new StringBuilder();
		ArrayList<String> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);
		
		for(String key : keys) {
			double value = map.get(key)/n * 100;
			String percent = String.format("%.4f", value);
			sb.append(key).append(" ").append(percent).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
