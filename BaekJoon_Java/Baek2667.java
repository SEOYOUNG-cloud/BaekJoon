package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Baek2667 {
	public static int[][] house = new int[25][25];
	public static int[] count_house = new int[625]; // 25 * 25
	public static int N, count = 0, i = 0;  // count = 총 단지 개수, i = 단지 아파트 개수
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) { // house[][] 2차원 배열에 저장함
			String in = br.readLine();
			for(int j = 0; j < N; j++)
				house[i][j] = in.charAt(j) - '0';
		}

		
		for(int x = 0; x < N; x++) 
			for(int y = 0; y < N; y++) 
				if(block(x, y)) {
					count ++;
					i = 0;
				}
	
		System.out.println(count);
		

		Arrays.sort(count_house);  // 오름차순 해줘야함
		
		for(int i = 0; i < 625; i++)
			if(count_house[i] == 0) {}  // 오름차순 하면 비어있는 배열에 0이 들어있어서 0부터 나옴. 그래서 0 아닐때만 print
			else
				System.out.println(count_house[i]);

		
		
	}
	
	public static boolean block(int x, int y) {
		
		if(x <= -1 || x >= N || y <= -1 || y >= N) return false;
		
		if(house[x][y] == 1) {
			house[x][y] = 0;
			i++;
			block(x-1, y);
			block(x+1, y);
			block(x, y-1);
			block(x, y+1);
			count_house[count] = i;
			return true;
		}
		
		return false;
		
	}

}
