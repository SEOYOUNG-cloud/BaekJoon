package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2805 {
		static StringTokenizer st;
		static int map[][];
		static int  N, middle;
		
		public static void main(String[] args) throws NumberFormatException, IOException {
			System.setIn(new FileInputStream("./input (5).txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			
			for(int tc = 1; tc <= T; tc++) {
				N = Integer.parseInt(br.readLine());
				map = new int[N][N];
							
				// map 입력받기
				for(int i = 0; i < N; i++) {
					String temp = br.readLine();
					for(int j = 0; j < N; j++)
						map[i][j] = temp.charAt(j) - '0';
				}
				
				System.out.println("#" + tc + " " + calcul());
			
			
			}

		}
		public static int calcul() {
			int middle = N/2;
			int total = 0;
			int conf = -1;
			for(int i = 0; i < N; i++) {
				if(i <= middle) conf+=1;
				else conf-=1;
				
				for(int gap = -1*conf; gap <= 1*conf; gap++) {
					total += map[i][middle+gap];
				}
			}
			
			return total;
			
		}

}
