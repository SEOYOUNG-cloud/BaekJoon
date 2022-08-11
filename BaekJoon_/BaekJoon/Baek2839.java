package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2839 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = Integer.MAX_VALUE;
		
		if(N % 3 == 0) // 3킬로로 가득
			answer = N/3;
		if(N % 5 == 0) // 5킬로로 가득
			answer = N/5;
		
		// 섞어서
		for(int i=1; i <= N/5; i++)
			for(int j=1; j <= N/3; j++)
				if(i*5 + j*3 == N) {
					answer = Math.min(answer, i+j);
				}
		
		if(answer == Integer.MAX_VALUE) 
			System.out.println("-1");
		 else
			System.out.println(answer);
	}

}
