package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1339_단어수학 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] alpha = new int[26];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<line.length(); j++) {
				alpha[line.charAt(j) - 'A'] += (int)Math.pow(10, line.length()-(j+1));
			}
		}
		
		Arrays.sort(alpha);
		int answer = 0;
		for(int i=25, num=9; i>=0 && num>=0; i--) {
			if(alpha[i] == 0) break;
			answer += alpha[i] * num--;
		}
		
		System.out.println(answer);

	}

}
