package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek10798 {

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char map[][] = new char[5][15];
		
		for(int i=0; i<5; i++)
			map[i] = br.readLine().toCharArray();

		for(int i=0; i<15; i++) {
			for(int j=0; j<5; j++) {
				if(map[j].length <= i) continue;
				sb.append(map[j][i]);
			}
		}
		System.out.println(sb.toString());

	}

}
