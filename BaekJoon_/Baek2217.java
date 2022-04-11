package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;


public class Baek2217 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		Integer[] rope = new Integer[k];
		
		for(int i = 0; i < k; i++)
			rope[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(rope, Collections.reverseOrder());
		
		int max = 0;
		for(int i = 1; i < k+1; i++)
			if((rope[i-1] * i) > max) max = rope[i-1] * i;
		
		System.out.println(max);
			
		
	}

}
