package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Baek1316 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		A: while(N-->0) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			
			stack.push(str.charAt(0));
			for(int i = 1; i < str.length(); i++)
				if(stack.peek() != str.charAt(i) && stack.contains(str.charAt(i)))
					continue A;
				else stack.push(str.charAt(i));
			
			answer+=1;
		}
		
		System.out.println(answer);
		
	}

}
