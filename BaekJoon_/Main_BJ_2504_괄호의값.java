package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_2504_괄호의값 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		int tmp = 1;
		for(int i=0; i<input.length(); i++) {
			char in = input.charAt(i);
			
			if(in == '(') {
				stack.push('(');
				tmp *= 2;
			} else if(in == '[') {
				stack.push('[');
				tmp *= 3;
			} else if(in == ')'){
				if(stack.isEmpty() || stack.peek() != '(') {
					System.out.println("0");
					return;
				}
				
				if(input.charAt(i-1) == '(') answer += tmp;
				stack.pop();
				tmp /= 2;
				
			} else {
				if(stack.isEmpty() || stack.peek() != '[') {
					System.out.println("0");
					return;
				}
				if(input.charAt(i-1) == '[') answer += tmp;
				stack.pop();
				tmp /= 3;
			}
		}
		
		if(stack.isEmpty())
			System.out.println(answer);
		else
			System.out.println("0");
	}

}
