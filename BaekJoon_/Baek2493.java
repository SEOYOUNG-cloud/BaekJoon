package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek2493 {
	static int N;
	static int map[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1];
		
		if(N==1) {
			System.out.println("0");
			return;
		}
		
		Stack<int[]> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			int top = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if(stack.peek()[0] >= top) {
					sb.append(stack.peek()[1]+ " ");
					break;
				}
				stack.pop();
			}
			
			if(stack.isEmpty()) sb.append("0 ");
			stack.push(new int[] {top, i});
			
		}
		
		System.out.println(sb);
			

	}

}
