package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek9342 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		A: while(T --> 0) {
			Stack<Character> stack = new Stack<>();
			String answer="Infected!";
			
			char[] str = br.readLine().toCharArray();
			
			// 스택에 넣으면서 중복제거 
			for(int i=0; i<str.length; i++) {
				if(!(str[i] >= 'A' && str[i] <= 'F')) { // 애초에 A~F 가 아닌 값이 들어오면 실패 
					System.out.println("Good");
					continue A;
				}
				if(i == 0) {
					stack.push(str[i]);
					continue;
				}
				if(stack.peek() != str[i])
					stack.push(str[i]);
			}
			
			
			// 중복제거 했으니 사이즈가 3,4,5 중 하나가 아니면 실패! 
			if(stack.size() > 5 || stack.size() < 3) {
				answer="Good";
			}
			else {
				if(stack.size() == 3) { // stack 사이즈 3
					if(stack.pop() == 'C' && stack.pop() == 'F' && stack.pop() == 'A') {} 
					else {
						answer = "Good";
					}
				}
				else if(stack.size() == 4) { // stack 사이즈 4
					if(stack.peek() != 'C') {
						stack.pop();
						if(stack.pop() == 'C' && stack.pop() == 'F' && stack.pop() == 'A') {}
						else answer="Good";
					} else {
						if(stack.pop() == 'C' && stack.pop() == 'F' && stack.pop() == 'A') {}
						else answer="Good";
					}
				} else { // stack 사이즈 5
					stack.pop();
					if(stack.pop() == 'C' && stack.pop() == 'F' && stack.pop() == 'A') {} 
					else {
						answer = "Good";
					}
				}
			}
			
			System.out.println(answer);
		}

	}

}
