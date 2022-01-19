package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;


public class Baek10610 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		
		String[] number = N.split("");
		int count = 0;

		
		Arrays.sort(number, Collections.reverseOrder());
		
		
		
		String answer = "";
		for(int i = 0; i < number.length; i++) {
			count += Integer.parseInt(number[i]);
			answer += number[i];
		}
				
		
		if(count % 3 == 0 && Integer.parseInt(number[number.length - 1]) == 0)
			System.out.println(answer);
		else {
			System.out.println("-1");
		}
		
		
		
		
	}

}
