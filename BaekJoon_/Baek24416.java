package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek24416 {
	static int fib=0, fibonacci=0;
	static int f[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		f = new int[N+1];
		fib(N);
		fibonacci(N);
		System.out.println(fib + " " + fibonacci);
	}
	private static int fib(int n) {
		if(n == 1 || n == 2) {
			fib+=1;
			return 1;
		}
		else
			return fib(n-1) + fib(n-2);
	}
	private static int fibonacci(int n) {
		f[1] = 1;
		f[2] = 1;
		
		for(int i = 3; i <= n; i++) {
			fibonacci += 1;
			f[i] = f[i-1] + f[i-2];
		}
		return f[n];
	}

}
