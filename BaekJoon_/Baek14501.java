package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14501 {
	static int plan[][];
	static int N;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		plan = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			plan[i][0] = Integer.parseInt(st.nextToken());
			plan[i][1] = Integer.parseInt(st.nextToken());
		}
		calcul(0, 0);
		System.out.println(max);

	}
	public static void calcul(int index, int total) {
		if(index >= N) {
			max = Math.max(max, total);
			return;
		}
		
		if(index + plan[index][0] <= N) // 이날 일하면 
			calcul(index + plan[index][0], total + plan[index][1]);
		else // 일 안하면 
			calcul(index + plan[index][0], total);
		
		calcul(index+1, total); // 일 안하고 다음 인덱스로 
	}

}
