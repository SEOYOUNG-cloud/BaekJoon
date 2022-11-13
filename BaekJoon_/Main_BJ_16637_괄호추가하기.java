package BaekJoon;

import java.util.*;
import java.io.*;


public class Main_BJ_16637_괄호추가하기 {

	static int N;
	static ArrayList<Integer> num = new ArrayList<>();
	static ArrayList<Character> math = new ArrayList<>();


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String line = br.readLine();

		for(int i=0; i<N; i++) {
			if(i % 2 == 0) num.add(line.charAt(i) - '0');
			else math.add(line.charAt(i));
		}

//		System.out.println(num);
//		System.out.println(math);
		dfs(0, num.get(0));
		System.out.println(answer);

	}
	static int answer = Integer.MIN_VALUE;
	private static void dfs(int i, int result) {
		if(i >= math.size()) {
			answer = Math.max(answer, result);
			return;
		}

		// 괄호 X
		dfs(i+1, calc(math.get(i), result, num.get(i+1)));

		// 괄호 O
		if(i+1 < math.size()) {
			// 뒤  먼저 계산하고 앞에까지 계산한 result랑 다시 계산한ㅁ
			int suf = calc(math.get(i+1), num.get(i+1), num.get(i+2));
			dfs(i+2, calc(math.get(i), result, suf));
		}
	}

	private static int calc(char m, int x1, int x2) {
		if(m=='+') return x1+x2;
		else if(m=='-') return x1-x2;
		else return x1*x2;
	}
}
