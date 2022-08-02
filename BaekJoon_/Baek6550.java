package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek6550 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			StringTokenizer st = new StringTokenizer(str);
			String s = st.nextToken();
			String t = st.nextToken();
			
			
			int i = 0, j = 0;
			while(i < s.length() && j < t.length()) {
				
				if(s.charAt(i) == t.charAt(j)) {
					i++;
					j++;
					continue;
				}
				else { // 다르면 t를 훑음
					j++;
					continue;
				}
			}

			System.out.println(i == s.length() ? "Yes" : "No");
			
			
		}

	}

}
