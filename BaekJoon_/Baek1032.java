package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1032 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		
		String array[] = new String[N];
		for(int i = 0; i < N; i++)
			array[i] = br.readLine();
		

		A: for(int i = 0; i < array[0].length(); i++) {
			for(int j = 1; j < N; j++) {
				if(array[j-1].charAt(i) != array[j].charAt(i)) {
					sb.append("?");
					continue A;
				}
			}
			sb.append(array[0].charAt(i));
		}
		
		System.out.println(sb);
	}

}
