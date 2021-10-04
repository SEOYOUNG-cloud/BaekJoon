package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baek2581 { // 소수
	
	public static boolean prime[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
				
		prime = new boolean[N + 1];
		get_prime();
		
		int sum = 0;
		int min = 50;
		for(int i = M; i <= N; i++) {
			if(prime[i] == false) { // 소수이면
				sum += i;
				if(min == 50) { // 그냥 첫번째 값 찾는거
					min = i;
				}
			}
		}
		
		if(sum == 0)
			System.out.println("-1");
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
	
	public static void get_prime() { // 에라토스테네스의 체
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) { // N값의 루트값까지만 확인하면 된다.
			if(prime[i] == true) continue;
			for(int j = i * i; j < prime.length; j += i) // i의 배수값을 true로 만든다.
				prime[j] = true;
		}
	}

}
