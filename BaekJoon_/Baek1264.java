package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1264 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int total = 0;
			String n = br.readLine();
			if(n.equals("#")) break;

			n = n.toLowerCase();
			for(int i = 0; i < n.length(); i++) {
				if("aeiou".indexOf(n.charAt(i))!=-1) {
					total += 1;
				}
			}
			System.out.println(total);
			
		}
		
	
	}

}
