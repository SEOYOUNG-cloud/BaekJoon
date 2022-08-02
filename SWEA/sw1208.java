package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1208_flatten_박서영 {
	static int height[];

	public static void main(String[] args) throws IOException, NumberFormatException {
		System.setIn(new FileInputStream("./input (2).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			
			int dump_count = Integer.parseInt(br.readLine());
			
			height = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 100; i++)
				height[i] = Integer.parseInt(st.nextToken());
			
			while(dump_count --> 0) {
				int min_index = 0, max_index = 0;
				
				for(int i = 0; i < 100; i++) {
					if(height[i] > height[max_index]) {
						max_index = i;
					}
					if(height[i] < height[min_index]) {
						min_index = i;
					}
				}
				
				height[min_index] += 1;
				height[max_index] -= 1;
			}
			
			int min_index = 0, max_index = 0;
			
			for(int i = 0; i < 100; i++) {
				if(height[i] > height[max_index]) {
					max_index = i;
				}
				if(height[i] < height[min_index]) {
					min_index = i;
				}
			}
			
			System.out.println("#" + tc + " " + (height[max_index] - height[min_index]));
			
			
		}
	}

}
