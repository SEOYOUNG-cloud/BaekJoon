package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_12904_A와B {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		StringBuilder sb = new StringBuilder(T);
		
		while(sb.length() != S.length()) {
			if(sb.charAt(sb.length()-1) == 'A')
				sb.replace(sb.length()-1, sb.length(), "");
			else {
				sb.replace(sb.length()-1, sb.length(), "");
				sb.reverse();
			}
		}
		
		System.out.println(S.equals(sb.toString()) ? "1" : "0");

	}

}
