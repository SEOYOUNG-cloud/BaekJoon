package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임_박서영 {
	static boolean isVisited[] = new boolean[9];
	static int number[] = new int[9];
	static int in[], gu[];
	static int win = 0, lose = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc = 1; tc <= T; tc++) {
			gu = new int[9];
			in = new int[9];
			
			lose = 0; win = 0;
			
			// 규영이 카드 받아
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++) {
				gu[i] = Integer.parseInt(st.nextToken());
			}
			
			// 인영이 카드에 뭐뭐 들어가니
			int ary[] = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
			for(int i = 0; i < 9; i++) {
				ary[gu[i]-1] = 0;
			}
			int index = 0;
			for(int i = 0; i < 18; i++)
				if(ary[i] != 0)
					in[index++] = ary[i];
	
			perm(0);
			System.out.println("#" + tc + " " + win + " " + lose);
		}
	}
	
	public static void perm(int cnt) { // 9!가지 순열 만들기
		if(cnt == 9) {
			game(number);
			return;
		}
		for(int i = 0; i < 9; i++) {
			if(isVisited[i]) continue;
			number[cnt] = in[i];
			
			isVisited[i] = true;
			perm(cnt+1);
			isVisited[i] = false;
		}
	}
	
	public static void game(int in[]) {
		int gu_score = 0;
		int in_score = 0;
		for(int i = 0; i < 9; i++)
			if(gu[i] > in[i]) gu_score += (gu[i] + in[i]);
			else
				in_score += (gu[i] + in[i]);
		
		if(gu_score > in_score) win+=1;
		else
			lose +=1;
	}
}
