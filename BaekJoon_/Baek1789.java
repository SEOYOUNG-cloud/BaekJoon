package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baek1789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		
		long count = 0;
		for(long i = 1; i <= 200; i++) {
			if(S - i == 0) {
				count++;
				break;
			}
			else if(S - i < 0) {				
				break;
			}
			else {
				S -= i;
				count++;
			}
		}
		
		System.out.println(count);
	}

}
