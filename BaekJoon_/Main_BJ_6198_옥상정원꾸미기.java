package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_6198_옥상정원꾸미기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		long answer = 0;
		for(int i=0; i<N; i++) {
			int height = Integer.parseInt(br.readLine());
			
			while(!stack.isEmpty() && stack.peek() <= height) {
				stack.pop();
			}
			stack.add(height);
			answer += stack.size()-1;
		}
		
		System.out.println(answer);

	}

}
