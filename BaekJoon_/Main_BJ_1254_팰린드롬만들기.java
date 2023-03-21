package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1254_팰린드롬만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		StringBuilder sb = new StringBuilder(S);
		
		int i=0;
		int j=sb.length()-1;
		while(true) {
			if(j <= i) break;
			String comp1 = sb.substring(i,i+1);
			String comp2 = sb.substring(j,j+1);
			
			if(comp1.equals("?") || comp2.equals("?") || (comp1.equals(comp2))){
				i++;
				j--;
				continue;
			}
			
			i = 0;
			j = sb.length();
			sb.append("?");
		}
		
		System.out.println(sb.length());
		
	}

}
