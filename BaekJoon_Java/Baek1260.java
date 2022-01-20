package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baek1260 {
	public static ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
	public static boolean visited_dfs[] = new boolean[1001];
	public static boolean visited_bfs[] = new boolean[1001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < 10000; i++)
			array.add(new ArrayList<Integer>()); // 초기화
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			array.get(x).add(y);
			array.get(y).add(x); // 1 2 이면 2 1도 연결되어 있는 것이니까 반대로도 넣어준다.
		}
		for(int i = 0; i < M+1; i++)
			Collections.sort(array.get(i));  // 번호가 작은 곳부터 들러야 하므로 오름차순 정렬 해준다.
		
		dfs(V);
		System.out.println();
		bfs(V);
		
	}
	
	public static void dfs(int x) {
		visited_dfs[x] = true;
		System.out.print(x + " ");
		
		for(int i = 0; i < array.get(x).size(); i++) {
			int y = array.get(x).get(i);
			if(!visited_dfs[y]) dfs(y);
		}	
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited_bfs[start] = true;
		
		while(!queue.isEmpty()) { // queue가 빌 때까지
			int x = queue.poll();
			System.out.print(x + " ");
			
			for(int i = 0; i < array.get(x).size(); i++) {
				int y = array.get(x).get(i);
				if(!visited_bfs[y]) {
					queue.offer(y);
					visited_bfs[y] = true;
				}
			}
		}
		
	}
	
}
