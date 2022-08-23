package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수_박서영 {

	static int N,M;
	static int parents[];
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_sw7465.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 마을 사람 수(정점 수)
			M = Integer.parseInt(st.nextToken()); //  간선 수
			
			// 정점 부모 넣어놓기
			parents = new int[N+1];
			for(int i=1; i<=N; i++)
				parents[i] = i;
			
			// 아는 사람끼리 합하기
			while(M-->0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			
			// 부모표시 안된게 있을 수 있으므로 훑었음
			for(int i=1; i<=N; i++)
				find(i);
			
			// 부모 개수 세기
			Set<Integer> set = new HashSet<>();
			for(int i=1; i<=N; i++)
				set.add(parents[i]);
			
			sb.append("#").append(tc).append(" ").append(set.size()).append('\n');
		}
		
		System.out.println(sb.toString());
		
		

	}
	// 부모 찾는 함수
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	// 아는 사람끼리 union
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;
		parents[bRoot] = aRoot;
	}

}
