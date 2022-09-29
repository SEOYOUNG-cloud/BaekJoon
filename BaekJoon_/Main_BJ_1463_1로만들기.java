package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_1463_1로만들기 {

	static int[] d;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		d = new int[X+1];
		Arrays.fill(d, X);
		d[X] = 0;
		recursive(X);
		
//		System.out.println(Arrays.toString(d));
		System.out.println(d[1]);

	}
	private static void recursive(int x) {
		if(x<1) {
			return;
		}	
		if(x%3 == 0) {
			if(d[x]+1 <= d[x/3]) {
				d[x/3] = d[x]+1;
				recursive(x/3);
			}
		}
		if(x%2 == 0) {
			if(d[x]+1 <= d[x/2]) {
				d[x/2] = d[x]+1;
				recursive(x/2);
			}
		}
		if(d[x]+1 <= d[x-1]) {
			d[x-1] = d[x]+1;
			recursive(x-1);
		}
		
		
		
		
	}

}
