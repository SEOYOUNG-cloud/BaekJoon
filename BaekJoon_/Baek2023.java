package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2023 {
	static int N;
	static StringBuilder answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = new StringBuilder();

		make("",0);
		System.out.println(answer);
		
	}
	
	public static void make(String num, int cnt) {
		if(cnt == N) {
			answer.append(num).append('\n');
			return;
		}
		for(int i = 1; i <= 9; i++) {
			if(confirm(Integer.valueOf(num+i)))
				make(num+i, cnt+1);
		}
		
	}
	
	public static boolean confirm(int n) { // 소수인지 확인
		if(n==1) return false;
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i == 0) return false;
		}
		return true;
	}

}
