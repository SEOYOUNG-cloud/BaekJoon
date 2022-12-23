package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_2606_바이러스 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N; i++)
			list.add(new ArrayList<>());
		
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		boolean visited[] = new boolean[N+1];
		
		int cnt = -1;
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(visited[now]) continue;
			visited[now] = true;
			cnt += 1;
			
			for(int i=0; i<list.get(now).size(); i++) {
				int next = list.get(now).get(i);
				if(!visited[next]) {
					q.offer(next);
				}
			}
		}
		System.out.println(cnt);
	}
		
}
