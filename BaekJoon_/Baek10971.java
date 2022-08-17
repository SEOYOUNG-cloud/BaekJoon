package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek10971 {
	static int number[], map[][];
	static int min = Integer.MAX_VALUE, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		number = new int[N+1];
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		Permutation(0,0);
		System.out.println(min);

	}
	private static void Permutation(int cnt, int flag) {
		if(cnt == N) {
			number[N] = number[0];
			Distance(number);
			return;
		}
		for(int i=0; i<N; i++) {
			if((flag & 1<<i) != 0) continue;
			
			number[cnt] = i;
			Permutation(cnt+1, flag | 1<<i);
		}
	}
	private static void Distance(int number[]) {
		int distance = 0;
		for(int i=0; i<N; i++) {
			if(map[number[i]][number[i+1]] == 0) return;
			distance += map[number[i]][number[i+1]];
		}
		
		min = Math.min(min, distance);
	}
	

}
