package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baek10162 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int countA = 0, countB = 0, countC = 0;
		
		countA = T / 300;
		countB = (T % 300) / 60;
		countC = (T % 300 % 60) / 10;
		if((T % 300 % 60 % 10) != 0) System.out.println("-1");
		else {
			System.out.println(countA + " " + countB + " " + countC);
		}
	}

}
