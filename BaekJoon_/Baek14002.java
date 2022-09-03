package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek14002 {

	static int N;
	static int[] map, dp;
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int map[] = new int[N];
		for(int i=0; i<N; i++) {
			int in = Integer.parseInt(st.nextToken());
			map[i] = in;
		}
		
		int dp[] = new int[N];
		Arrays.fill(dp, 1);
		
		/// 입력 끝 ///
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer>[] ans = new ArrayList[N];
		for(int i=0; i<N; i++)
			ans[i] = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			list = new ArrayList<>();
			int now = map[i];
			int idx = i;
			
			for(int j=0; j<i; j++) {
				if(map[j] < now && dp[j] >= dp[i]) {
					dp[i] = dp[j] + 1;
					idx = j;
				}
			}
			list.addAll(ans[idx]);
			list.add(map[i]);
			
			ans[i] = list;

		}

		int length = 0;
		int index = -1;
		for(int i=0; i<N; i++)
			if(ans[i].size() > length) {
				length = ans[i].size();
				index = i;
			}
		
		sb.append(dp[index]).append('\n');
		for(int i=0; i<ans[index].size(); i++)
			sb.append(ans[index].get(i)).append(" ");
		
		System.out.println(sb);
	}

}
