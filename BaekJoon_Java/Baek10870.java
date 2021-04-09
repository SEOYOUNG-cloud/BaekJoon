package Baek;

import java.util.Scanner;

public class Baek10870 {
	public static void main(String[] args){
		int n;
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		if(n == 0)
			System.out.println("0");
		else if(n == 1)
			System.out.println("1");
		else
			System.out.println(fibo(n));
		}
		
	public static int fibo(int n){
			if(n<=1)
				return n;
			else
				return fibo(n-1) + fibo(n-2);
		}

}
