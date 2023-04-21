import java.util.*;
import java.io.*;

public class Main_BJ_11055_가장큰증가하는부분수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i=0; i<N; i++){
			int input = Integer.parseInt(st.nextToken());
			arr[i] = input;
			dp[i] = input;
		}


		for(int i=1; i<N; i++){
			for(int j=0; j<i; j++){
				if(arr[i] > arr[j]){
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
		}

		int ans = 0;
		for(int i=0; i<N; i++)
			ans = Math.max(ans, dp[i]);

		System.out.println(ans);
	}
}
