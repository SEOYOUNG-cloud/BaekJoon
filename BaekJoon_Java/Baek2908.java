package Baek;

import java.util.Scanner;

public class Baek2908 { // 상수
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num1 = scan.nextInt();
		num1 = Integer.parseInt(new StringBuilder().append(num1).reverse().toString());
		
		//stringbuilder 타입을 문자열로 반환시키기 위해 toString();
		//Integer.parseInt로 string -> int 해주기
		
		int num2 = scan.nextInt();
		num2 = Integer.parseInt(new StringBuilder().append(num2).reverse().toString());
		
		if(num1 > num2)
			System.out.println(num1);
		else {
			System.out.println(num2);
		}	
		//System.out.print(num1 > num2 ? num1 : num2); //num1이 2보다 크면? true면 num1, false면 num2
	}
}