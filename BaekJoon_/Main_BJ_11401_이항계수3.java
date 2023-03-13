package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_11401_이항계수3 {
	static long div = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long mom = fibo(N);
		long kid = fibo(K) * fibo(N-K) % div;
		
		System.out.println(mom * pow(kid, div-2) % div);
		
	}
	
	private static long fibo(long n) {
		long fact = 1;
		while(n > 1) {
			fact = (fact*n) % div;
			n--;
		}
		
		return fact;
	}
	
	private static long pow(long a, long b) {
		if(b == 1) return a % div;
		
		long temp = pow(a, b/2);
		
		if(b % 2 == 1) return (temp * temp % div) * a % div;
		
		return temp * temp % div;
	}

}
