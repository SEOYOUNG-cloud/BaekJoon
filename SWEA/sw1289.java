package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1289_원재의메모리복구하기_박서영 {
	static int length;
	static int answer = 0;

	public static void main(String[] args) throws NumberFormatException, IOException, FileNotFoundException {
		System.setIn(new FileInputStream("./input (3).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc <= test_case; tc++) {
			char end[] = br.readLine().toCharArray();
			length = end.length;
			int initial[] = new int[length];
			answer=0;

			while(!(Arrays.toString(end).equals(Arrays.toString(initial)))) {
				for(int i = 0; i < length; i++) {
					if(end[i] - '0' == initial[i]) {continue;}
					else {
						initial = change_number(i, initial);
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);

		}

	}
	public static int[] change_number(int n, int[] initial) {
		for(int i = n; i < length; i++)
			if(initial[i] == 0)
				initial[i] = 1;
			else initial[i] = 0;
		
		answer++;
		return initial;
	}

}
