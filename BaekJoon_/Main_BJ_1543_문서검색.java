package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1543_문서검색 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String compare = br.readLine();
		int size = input.length();
		
		
		StringBuilder sb = new StringBuilder(input);
		int answer = 0;
		for(int i=0; i<sb.length()-compare.length()+1; i++) {
			if(sb.substring(i, i+compare.length()).toString().equals(compare)) {
				answer += 1;
				sb.delete(i, i+compare.length());
				i--;
			}
		}
		
		System.out.println(answer);
	}

}
