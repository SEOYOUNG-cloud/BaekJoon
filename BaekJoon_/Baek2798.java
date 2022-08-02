package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2798 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int card[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			card[i] = Integer.parseInt(st.nextToken());
		
		int gap = M; // M이랑 3장 더한 수의 간극
		int total = 0; // 간극이 최소일 때 3장의 합
		//3장 뽑아야지...
		for(int i = 0; i < N-2; i++)
			for(int j = i+1; j < N-1; j++)
				for(int k = j+1; k < N; k++) {
					int sum = card[i] + card[j] + card[k];
					if(M-sum < 0) continue;
					if(M-sum >= 0 && gap > M-sum) {
						total = sum;
						gap = M-sum;
					}
				}
					
		System.out.println(total);

	}

}
