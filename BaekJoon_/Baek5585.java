package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek5585{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int pay = Integer.parseInt(br.readLine());
		
		int[] coin = {500, 100, 50, 10, 5, 1};
		int count = 0;
		
		pay = 1000 - pay;
		
		for(int i = 0; i < 6; i++) {
			count += pay / coin[i];
			pay %= coin[i];
		}
		
		System.out.println(count);
	}

}
