package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트_박서영 {
	static int N, L, index, answer = 0;
	static int TK[][];
	static boolean isSelected[];
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) { // 테스트케이스
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			TK = new int[N][2];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				TK[i][0] = Integer.parseInt(st.nextToken());
				TK[i][1] = Integer.parseInt(st.nextToken());
			}
					
			//////// 입력 다 받음
			answer=0;
			
			//subset 돌리기
			isSelected = new boolean[N];
			Subset(0);
			
			System.out.println("#" + tc + " " + answer);
		}
	

	}
	public static void Subset(int cnt) {
		if(cnt == N) {
			int taste = 0, cal = 0;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					taste += TK[i][0];
					cal += TK[i][1];
				}
			}
			if(cal <= L)
				answer = Math.max(answer, taste);
			
			
			return;
		}
		
		isSelected[cnt] = true;
		Subset(cnt+1);
		isSelected[cnt] = false;
		Subset(cnt+1);	
	}

}
