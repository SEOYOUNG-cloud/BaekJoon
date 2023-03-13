package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_11051_이항계수2_2 {
	static long div = 10007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long mom = fibo(N);
		long kid = fibo(K) * fibo(N-K) % div;
		
		
		System.out.println((mom * pow(kid, div-2)) % div);
		
	}
	private static long fibo(int N) {
		long f = 1;
		while(N > 1) {
			f = (f* N) % div;
			N--;
		}
		return f;
	}
	
	private static long pow(long a, long b) { //  a^b
		if(b == 1) return a % div;
		
		long temp = pow(a, b/2);
		
		if(b % 2 == 1) return (temp * temp % div) * a % div;
		return temp * temp % div;
	}
	

}

