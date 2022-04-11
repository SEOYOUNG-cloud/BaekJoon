package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baek2581 { // �Ҽ�
	
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
			if(prime[i] == false) { // �Ҽ��̸�
				sum += i;
				if(min == 50) { // �׳� ù��° �� ã�°�
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
	
	public static void get_prime() { // �����佺�׳׽��� ü
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) { // N���� ��Ʈ�������� Ȯ���ϸ� �ȴ�.
			if(prime[i] == true) continue;
			for(int j = i * i; j < prime.length; j += i) // i�� ������� true�� �����.
				prime[j] = true;
		}
	}

}
