package test;

import java.util.Scanner;

public class Baek2530 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int m = scan.nextInt();
		int s = scan.nextInt();
		int time = scan.nextInt();
		
		s += time;
		m += s/60;
		s %= 60;
		h += m/60;
		m %= 60;
		
		System.out.println(h%24 + " " + m + " " + s);
	}

}
