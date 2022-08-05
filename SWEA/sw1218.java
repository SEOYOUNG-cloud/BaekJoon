package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1218_괄호짝짓기_박서영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("./input (2).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		A: for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			Stack<Character> stack = new Stack<>();
			
			String str = br.readLine();
			for(int i = 1; i < N; i++) {
				if(stack.isEmpty()) {
					stack.push(str.charAt(i));
					continue;
				}
				if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '<') {
					stack.push(str.charAt(i));
					continue;
				}
				if(stack.peek() == '(' && str.charAt(i) == ')') stack.pop();
				else if(stack.peek() == '[' && str.charAt(i) == ']') stack.pop();
				else if(stack.peek() == '{' && str.charAt(i) == '}') stack.pop();
				else if(stack.peek() == '<' && str.charAt(i) == '>') stack.pop();
				else {
					System.out.println("#" + tc + " " + "0");
					continue A;
				}
			}
			
			System.out.println("#" + tc + " " + "1");
			
			
		
		}
		

	}

}
