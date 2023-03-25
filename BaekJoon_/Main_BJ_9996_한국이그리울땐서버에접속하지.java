package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_9996_한국이그리울땐서버에접속하지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] pattern = br.readLine().split("\\*");
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=N; tc++) {
			String check = br.readLine();
			if(check.length() < pattern[0].length() + pattern[1].length()) {
				sb.append("NE").append('\n');
				continue;
			}
			
			String prefix = check.substring(0, pattern[0].length());
			String suffix = check.substring(check.length()-pattern[1].length(), check.length());
			
			if(pattern[0].equals(prefix) && pattern[1].equals(suffix)) {
				sb.append("DA").append('\n');
			} else {
				sb.append("NE").append('\n');
			}
		}
		
		System.out.println(sb.toString());
	}

}
