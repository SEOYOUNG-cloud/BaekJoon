package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Baek2164 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n==1) {
			System.out.println(n);
			return;
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i = 1; i <= n; i++) {
			queue.add(i);
		}
		while(queue.size() != 1) {
			queue.remove();
			queue.offer(queue.peek());
			queue.remove();
		}
		
		System.out.println(queue.peek());
		
	}

}
