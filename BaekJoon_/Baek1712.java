package Baek;

import java.util.Scanner;

public class Baek1712 {  // 손익분기점
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();
		
		
		if(C - B <= 0) System.out.println("-1");
		else {
			System.out.println(A/(C-B) + 1);
		}
	}

}
