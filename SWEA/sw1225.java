package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기_박서영 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./input (1).txt"));
		String str = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc = 0; tc < 10; tc++) {
			int T = Integer.parseInt(br.readLine()); // test case
			st = new StringTokenizer(br.readLine());
			
			Queue<Integer> queue = new ArrayDeque<>();
			
			// 숫자 입력받기
			for(int i = 0; i < 8; i++)
				queue.offer(Integer.parseInt(st.nextToken()));
						
			A: while(true) {
				for(int i=1; i <= 5; i++) {
					if(queue.peek() - i <= 0) {
						queue.offer(0);
						queue.remove();
						break A;
					}
					queue.offer(queue.peek() - i);
					
					queue.remove();
				}
			}
			
			System.out.print("#"+ T + " ");
			for(int q : queue) System.out.print(q + " ");
			System.out.println();
		}

	}

}
