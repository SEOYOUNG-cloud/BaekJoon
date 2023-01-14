package BaekJoon;

import java.util.*;
import java.io.*;
public class Main_BJ_13023_ABCDE {
	
	static int N;
	static int M;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 사람 수 N
		M = Integer.parseInt(st.nextToken()); // 친구 관계 수 M
		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<N; i++)
			list.add(new ArrayList<>());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			
			list.get(to).add(from);
			list.get(from).add(to);
		}
		
		for(int i=0; i<N; i++) {
			if(answer == 1) break;
			dfs(i, new boolean[N], 1);
		}
		
		System.out.println(answer);
	}
	
	static int answer = 0;
	private static void dfs(int now, boolean[] visited, int cnt) {
		if(cnt == 5) {
			answer = 1;
			return;
		}
		
		visited[now] = true;
		for(int i=0; i<list.get(now).size(); i++) {
			int next = list.get(now).get(i);
			
			if(!visited[next]) {
				dfs(next, visited, cnt+1);
			}
		}
		visited[now] = false;
	}
	

}
