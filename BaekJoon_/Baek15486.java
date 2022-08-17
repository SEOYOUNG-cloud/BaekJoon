package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek15486 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int date[] = new int[N+1];
		int money[] = new int[N+1];
		int dp[] = new int[N+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			date[i] = Integer.parseInt(st.nextToken());
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE; // 현재까지 최대 수익
		for(int i=0; i<=N; i++) {
//			if(i >= N || i+date[i] >= N ) continue;
			
			if(max < dp[i]) max = dp[i];
			
			if(i + date[i] <= N)
				dp[i+date[i]] = Math.max(dp[i+date[i]], max + money[i]);
		}
		
		System.out.println(max);

	}

}
