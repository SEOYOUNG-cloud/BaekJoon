package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek20546 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stock = new int[14];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<14; i++) {
			stock[i] = Integer.parseInt(st.nextToken());
		}
		
		///입력 끝
		if(Jun(N, stock) > Sung(N, stock))
			System.out.println("BNP");
		else if(Jun(N, stock) < Sung(N, stock))
			System.out.println("TIMING");
		else
			System.out.println("SAMESAME");

	}
	private static int Jun(int N, int[] stock) {
		int buy = 0, count = 0, money=0;
		for(int i=0; i<14; i++) {
			if(stock[i] <= N) {
				buy = stock[i]; // buy: 얼마에 살건지 
				
				while(N >= buy) { // count: 몇 주 살건지 
					count+=1;
					N -= buy;
				} 
				money += count * (stock[13] - buy); // 번 돈 
			}
		}
		
		return money;
		
	}
	
	private static int Sung(int N, int[] stock) {
		Stack<int[]> stack = new Stack<>();
		int money=0;
		
		for(int i=0; i<11; i++) {
			int buy=0, count=0, sell=0;
			if(stock[i] > stock[i+1] && stock[i+1] > stock[i+2]) {
				buy = stock[i+3]; // buy: 얼마에 살건지 
				
				while(N >= buy) { // count: 몇 주 살건지 
					count+=1;
					N -= buy;
				}
				if(count != 0) {
					stack.push(new int[] {buy, count});
				}
			}
			else if((stock[i] < stock[i+1]) && (stock[i+1] < stock[i+2]) ) {
				sell = stock[i+3];
				while(!stack.isEmpty()) {
					int[] out = stack.pop();
					money += out[1] * (sell - out[0]);
				}
			}
		}
		if(!stack.isEmpty()) {
			int[] out = stack.pop();
			money += out[1] * (stock[13] - out[0]);
		}
		return money;
	}
}
