package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1182 {

	static int N,S;
	static int map[];
	static int answer=0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //개수 
		S = Integer.parseInt(st.nextToken()); // 합 
		map = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			map[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(map); // 정렬 
		
		dfs(0,0);
		if(S == 0) answer-=1;
		
		System.out.println(answer);
	}

	private static void dfs(int start, int total) {
		if(start == N) {
			if(total == S) {
				answer+=1;
			}
			return;
		}

		
		dfs(start+1,total+map[start]);
		dfs(start+1,total);
	}

}
