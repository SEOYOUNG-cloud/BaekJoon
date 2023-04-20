package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1652_누울자리를찾아라 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 가로 
		int r = 0;
		int cntR = 0;
		int c = 0;
		int cntC = 0;
		
		for(int i=0; i<N; i++) {
			cntR = 0;
			cntC = 0;
			for(int j=0; j<N; j++) {
				if(cntR >= 2 && map[i][j] != '.') {
					r+=1;
				}
				if(cntC >= 2 && map[j][i] != '.') {
					c+=1;
				}
				
				if(map[i][j] == '.') cntR += 1;
				else cntR = 0;
				
				if(map[j][i] == '.') cntC += 1;
				else cntC = 0;
			}
			if(cntR >= 2) {
				r+=1;
			}
			if(cntC >= 2) {
				c+=1;
			}
		}
		
		System.out.println(r + " " + c);

	}

}
