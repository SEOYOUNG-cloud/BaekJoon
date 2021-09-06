package Baek;

import java.util.Scanner;

public class Baek10250 { // ACM hotel
	
	public static void main(String[] args) {
		
			
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for(int i=0; i<T; i++) {
			int H = scan.nextInt();
			int W = scan.nextInt();
			int N = scan.nextInt();
			int count = 1;
			
			while(N>H) {
				count += 1;
				N -= H;
			}
			System.out.println(N*100 + count);
				
		}
		scan.close();
	}
}	

