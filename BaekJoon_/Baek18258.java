package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baek18258 {
	static int command[] = new int[2000000]; // 명령어 최대 200만
	static int start_index=0, end_index=0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		while(N-->0) { // N번 돌아 
			String cmd = br.readLine();
			switch(cmd.substring(0, 3)) {
				case "pus":
					push(Integer.parseInt(cmd.substring(5, cmd.length())));
					break;
				case "pop":
					pop();
					break;
				case "siz":
					size();
					break;
				case "emp":
					empty();
					break;
				case "fro":
					front();
					break;
				case "bac":
					back();
					break;
			}
		}
		System.out.println(sb);

	}
	static void push(int n) {
		command[end_index++] = n;
		return;
	}
	static void pop() {
		if(start_index == end_index) {
			sb.append("-1").append('\n');
			return;
		}
		sb.append(command[start_index++]).append('\n');
		return;
	}
	static void size() {
		sb.append(end_index - start_index).append('\n');
		return;
	}
	static void empty() {
		if(start_index == end_index) {
			sb.append("1").append('\n');
		} else {
			sb.append("0").append('\n');
		}
		return;
	}
	static void front() {
		if(start_index == end_index) {
			sb.append("-1").append('\n');
			return;
		}
		sb.append(command[start_index]).append('\n');
		return;
	}
	static void back() {
		if(start_index == end_index) {
			sb.append("-1").append('\n');
			return;
		}
		// push하면 해당 index에 넣고 +1 하므로 -1 해줘야 마지막에 있는 값 나옴 
		sb.append(command[end_index-1]).append('\n');
		return;
	}

}
