package Baek;

import java.util.Scanner;

public class Baek2908 { // ���
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num1 = scan.nextInt();
		num1 = Integer.parseInt(new StringBuilder().append(num1).reverse().toString());
		
		//stringbuilder Ÿ���� ���ڿ��� ��ȯ��Ű�� ���� toString();
		//Integer.parseInt�� string -> int ���ֱ�
		
		int num2 = scan.nextInt();
		num2 = Integer.parseInt(new StringBuilder().append(num2).reverse().toString());
		
		if(num1 > num2)
			System.out.println(num1);
		else {
			System.out.println(num2);
		}	
		//System.out.print(num1 > num2 ? num1 : num2); //num1�� 2���� ũ��? true�� num1, false�� num2
	}
}