package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_9935_문자열폭발 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		String b = br.readLine();
		char[] bomb = b.toCharArray();
		
		/* 입력 끝 */
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<str.length; i++) {
			stack.add(str[i]);
			// 사이즈가 같아지면 탐색 시작 
			if(stack.size() >= bomb.length) {
				boolean check = true;
				for(int j=0; j<bomb.length; j++) {
					char compareStr = stack.get(stack.size() - bomb.length + j);
					char compareBomb = bomb[j];
					
					if(compareStr != compareBomb) {
						check = false;
						break;
					}
				}
				
				if(check) {
					for(int j=0; j<bomb.length; j++) {
						stack.pop();
					}
				}
			}
			
			
		}

		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) sb.append(stack.pop());
		sb.reverse();
		
		System.out.println(sb.length() != 0 ? sb.toString() : "FRULA");
			
	}

}
