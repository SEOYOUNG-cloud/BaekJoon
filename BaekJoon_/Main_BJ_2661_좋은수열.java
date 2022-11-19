package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_2661_좋은수열 {

	static int N;
	static String[] answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = new String[N];
		answer[0] = "1";
		
		recursive(1);

	}
	private static void recursive(int cnt) {
		if(cnt == N) {
			System.out.println(String.join("", answer));
			System.exit(0);
		}
		
		for(int i=1; i<=3; i++) {
			answer[cnt] = String.valueOf(i);
			if(conf(cnt+1, String.join("", answer))) {
				recursive(cnt+1);
			}
		}
	}
	private static boolean conf(int C, String str) {
		String prefix = "";
		String suffix = "";
				
		for(int i=1; i<=C/2; i++) {
			suffix = str.substring(C-i, C);
			prefix = str.substring(C-i-i, C-i);
			
			if(suffix.equals(prefix)) return false;
		}
		
		return true;
	}

}
