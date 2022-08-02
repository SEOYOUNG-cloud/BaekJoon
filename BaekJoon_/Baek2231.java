package BaekJoon;

import java.util.Scanner;

public class Baek2231 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int answer = 0;
		
		for(int i = 1; i < N; i++) {
			int hap = i/1000000 + i%1000000/100000 + i%100000/10000 + i%10000/1000 + i%1000/100 + i%100/10 + i%10;
			if((hap + i) == N) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);

	}

}
