package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사_박서영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input (1).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		char save[][];
		
		A: for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			save = new char[N][];
			int answer = 1; // 디폴트 계산 가능
			
//			int idx = 1;
//			for(int i = 0; i <= 8; i++)
//				if(N < Math.pow(2, i)) idx= i-1;
//			int a = N-(int)Math.pow(2, idx)/2 + (int)Math.pow(2, idx-1); // 까지 연산자
			
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				char in = st.nextToken().charAt(0);
				
				if(st.hasMoreTokens()) {			
					char tmp[] = new char[] {in, '1', '1'};
					save[i] = tmp;
				}	
				else {
					char tmp[] = new char[1];
					save[i] = tmp;
				}
			}
			
			for(int i = 0; i < N; i++) {
				if(save[i].length == 3 && save[i][0] >= '0' && save[i][0] <= '9') {
					answer = 0;
					System.out.println("#" + tc + " " + answer);
					continue A;
					
				}
				if(save[i].length == 1 && (save[i][0] == '/' || save[i][0] == '+' || save[i][0] =='-' || save[i][0] == '*')){
					answer = 0;
					System.out.println("#" + tc + " " + answer);
					continue A;
				}
			}
			
			System.out.println("#" + tc + " " + answer);

		}

	}

}
