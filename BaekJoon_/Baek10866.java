package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Baek10866 {
	static Deque<Integer> q = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		while(N-->0) { // N번 돌아 
			String str = br.readLine();
			switch(str.substring(0, 3)) {
			case "pus":
				if(str.substring(5,8).equals("fro")) {
					push_front(Integer.parseInt(str.substring(11)));
				}
				else 
					push_back(Integer.parseInt(str.substring(10)));
				break;
			case "pop":
				if(str.substring(4,7).equals("fro")) pop_front();
				else pop_back();
				break;
			case "siz": size(); break;
			case "emp": empty(); break;
			case "fro": front(); break;
			case "bac": back(); break;
			}
		}
		System.out.println(sb);

	}
	public static void push_front(int n) {
		q.offerFirst(n);
	}
	static void push_back(int n) {
		q.offerLast(n);
	}
	static void pop_front() {
		if(q.isEmpty()) {
			sb.append("-1").append('\n');
			return;
		}
		sb.append(q.pollFirst()).append('\n');
	}
	static void pop_back() {
		if(q.isEmpty()) {
			sb.append("-1").append('\n');
			return;
		}
		sb.append(q.pollLast()).append('\n');
	}
	static void size() {
		sb.append(q.size()).append('\n');
	}
	static void empty() {
		if(q.isEmpty())
			sb.append("1").append('\n');
		else
			sb.append("0").append('\n');
	}
	static void front() {
		if(q.isEmpty()) {
			sb.append("-1").append('\n');
			return;
		}
		sb.append(q.peekFirst()).append('\n');
	}
	static void back() {
		if(q.isEmpty()) {
			sb.append("-1").append('\n');
			return;
		}
		sb.append(q.peekLast()).append('\n');
	}

}
