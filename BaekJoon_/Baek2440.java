package test;

import java.util.Scanner;

public class Baek2440 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		int N = scanner.nextInt();
		for(int i = N; i > 0; i--) {
			for(int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}
		
		scanner.close();
	}

}
