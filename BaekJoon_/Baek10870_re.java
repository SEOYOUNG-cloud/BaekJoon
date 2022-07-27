package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek10870_re {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(fibo(n));
	}
	public static int fibo(int n) {
		if(n == 1 || n == 0)
			return n;
		else
			return fibo(n-2) + fibo(n-1);
	}

}
