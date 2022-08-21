package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11053 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A[] = new int[N];
		for(int i=0; i<N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		// 입력 끝
		int dp[] = new int[N];
		dp[0] = 1;
		int answer = 1;
		
		for(int i = 1; i < N; i++) {
			int max = 1;
			for(int j=i-1; j>=0; j--) {
				if(A[j] < A[i] && max <= dp[j])
					max = dp[j] + 1;
			}
			dp[i] = max;
			if(max > answer) answer = max;
		}
		System.out.println(Arrays.toString(dp));		
		System.out.println(answer);

	}

}
