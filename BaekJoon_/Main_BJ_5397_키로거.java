package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_5397_키로거 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			String cmds = br.readLine();
			
			Stack<Character> left = new Stack<>();
			Stack<Character> right = new Stack<>();
			
			for(int c=0; c<cmds.length(); c++) {
				char cmd = cmds.charAt(c);
				switch (cmd) {
				case '-':
					if(!left.isEmpty()) {
						left.pop();
					}
					break;
				case '<':
					if(!left.isEmpty()) {
						right.push(left.pop());
					}
					break;
				case '>':
					if(!right.isEmpty()) {
						left.push(right.pop());
					}
					break;
				default:
					left.add(cmd);
					break;
				}
			}
			
			while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
