package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1874_스택수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int start = 0;
		for(int i=0; i<N; i++) {
			int in = Integer.parseInt(br.readLine());
			
			if(in > start) {
				for(int s = start+1; s<=in; s++) {
					stack.add(s);
					sb.append("+").append('\n');
				}
				start = in;
			}
			
			else if(stack.peek() != in) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append("-").append('\n');
		}
		
		System.out.println(sb.toString());
	}
}
