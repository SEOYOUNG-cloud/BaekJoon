package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int map[][] = new int[100][100];
		
		StringTokenizer st;
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			x -= 1;
			y -= 1;
			
			// 색종이가 있는 부분에 1 넣기
			for(int i = x; i < x+10; i++)
				for(int j = y; j < y+10; j++)
					map[i][j] = 1; 
			
		}
		
		// map에서 1인 값 개수 구하기
		int count = 0;
		for(int i = 0; i < 100; i++)
			for(int j = 0; j < 100; j++)
				if(map[i][j] == 1) count+=1;
		
		System.out.println(count);
	}

}
