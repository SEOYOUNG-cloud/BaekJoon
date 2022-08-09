package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek18269_Deque {
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> q = new ArrayDeque<>();

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
		q.add(n);
		return;
	}
	static void pop() {
		if(q.isEmpty()) {
			sb.append("-1").append('\n');
			return;
		}
		sb.append(q.poll()).append('\n');
	}
	static void size() {
		sb.append(q.size()).append('\n');
		return;
	}
	static void empty() {
		if(q.isEmpty()) {
			sb.append("1").append('\n');
		} else {
			sb.append("0").append('\n');
		}
		return;
	}
	static void front() {
		if(q.isEmpty()) {
			sb.append("-1").append('\n');
			return;
		}
		sb.append(q.peek()).append('\n');
		return;
	}
	static void back() {
		if(q.isEmpty()) {
			sb.append("-1").append('\n');
			return;
		}
		sb.append(q.peekLast()).append('\n');
		return;
	}

}

