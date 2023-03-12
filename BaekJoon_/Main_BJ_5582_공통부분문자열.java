package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_5582_공통부분문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = br.readLine().toCharArray();
		String str2 = br.readLine();

		int[] dp = new int[str1.length];
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str1.length; i++) {
			sb.append(str1[i]);
			if(str2.contains(sb.toString())) {
				dp[i] = sb.length();
			} else {
				while(sb.length() != 0) {
					sb.deleteCharAt(0);
					if(str2.contains(sb.toString())) {
						dp[i] = sb.length();
						break;
					}
				}
				dp[i] = sb.length();
			}
		}
		
		int answer = 0;
		for(int i=0; i<str1.length; i++)
			answer = Math.max(answer, dp[i]);
		
		System.out.println(answer);

	}

}
