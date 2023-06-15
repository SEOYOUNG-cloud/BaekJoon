package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1918_후위표기식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] expression = br.readLine().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<expression.length; i++) {
			char now = expression[i];
			if(now >= 'A' && now <= 'Z') {
				sb.append(now);
			} 
			else if(now == '(') {
				stack.add(now);
			} else if(now == ')') {
				while(stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			}
			// 연산자일 때
			else {
				while(!stack.isEmpty() && num(stack.peek()) >= num(now)) {
					sb.append(stack.pop());
				}
				stack.add(now);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());

	}
	private static int num(char op) {
		switch (op) {
		case '+':
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		default:
			return -1;
		}
	}
}
