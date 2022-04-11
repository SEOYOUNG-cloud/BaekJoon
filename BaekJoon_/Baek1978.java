package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Baek1978 { // �Ҽ� ã��
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		ArrayList<Integer> prime = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {	
			prime.add(i, Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < N; i++) {
			if((prime.get(i) % 2) == 0) { // ¦���̸�
				continue;
			} else { // Ȧ����
				if(prime.get(i) == 1) {}
				else {
					for(int j = 3; j < prime.get(i); j += 2) {
						if(prime.get(i) % j == 0)break; // ����������� �Ҽ� x
						else {
							if((j+2) == prime.get(i)) count++;
						}
					}
					
				}

			}
			
		}
		
		if(prime.contains(2) == true) count++;
		if(prime.contains(3) == true) count++;
		System.out.println(count);
	}
}
