package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_15904_UCPC는무엇의약자일까 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		char[] ucpc = {'U', 'C', 'P', 'C'};
		
		int idx=0;
		for(char str : arr) {
			if(str == ucpc[idx]) {
				if(idx == 3) {
					System.out.println("I love UCPC");
					return;
				}
				idx++;
			}
		}
		System.out.println("I hate UCPC");
	}

}
