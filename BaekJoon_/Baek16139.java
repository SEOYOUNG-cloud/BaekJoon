package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek16139 {
	static String str;
	static int alpha_count[][];
	static char alpha;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		str = br.readLine();
		int tc = Integer.parseInt(br.readLine());
		alpha_count = new int[26][str.length()+1];
		
		calcul_alpha_count();
		
		for(int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			alpha = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(alpha_count[alpha-97][end+1] - alpha_count[alpha-97][start]).append('\n');
			
		}

		System.out.println(sb);

	}
	public static void calcul_alpha_count() {
		for(int i = 0; i < str.length(); i++) { // str 훑기
			for(int j = 0; j < 26; j++) { // index
				if(str.charAt(i) == (char)(j+97)) {
					alpha_count[j][i+1] = alpha_count[j][i] + 1;
				} else {
					alpha_count[j][i+1] = alpha_count[j][i];
				}
			}	
		}
		////
	}

}
