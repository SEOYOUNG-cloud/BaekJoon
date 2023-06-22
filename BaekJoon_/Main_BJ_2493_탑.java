package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_2493_탑 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		Stack<int[]> stack = new Stack<>();
		
		for(int i=1; i<=N; i++) {
			int in = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek()[0] < in) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				sb.append("0").append(" ");
			} else {
				sb.append(stack.peek()[1]).append(" ");
			}
			stack.add(new int[] {in, i});
		}
		
		System.out.println(sb.toString());
	}
}
