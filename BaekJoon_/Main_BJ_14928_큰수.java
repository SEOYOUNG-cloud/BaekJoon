package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_14928_큰수 {
	public static void main(String[] args) throws IOException {
		
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int remain = 0;
		
		for(int i=0; i<N.length(); i++) {
			remain = ((remain * 10) + (N.charAt(i) - '0')) % 20000303; 
		}
		
		System.out.println(remain);
	}
}
