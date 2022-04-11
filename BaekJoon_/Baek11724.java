package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Baek11724 {
	public static boolean visited[] = new boolean[1000];
	public static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		for(int i = 0; i < N + 1; i++)
			arrayList.add(new ArrayList<Integer>());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int in1 = Integer.parseInt(st.nextToken());
			int in2 = Integer.parseInt(st.nextToken());
			arrayList.get(in1).add(in2);
			arrayList.get(in2).add(in1);
		}
		
		visited = new boolean[N + 1]; // 배열 크기 초기화
		
		int count = 0;
		for(int i = 1; i < N + 1; i++) {
			if(!visited[i]) { 
				dfs(i);
				count++;	
			}
		}
		
		System.out.println(count);
	}
	
	public static void dfs(int start) {
		
		if(visited[start]) return;
		
		visited[start] = true;
			
		for(int i = 0; i < arrayList.get(start).size(); i++) {
			int y = arrayList.get(start).get(i);
			if(!visited[y]) dfs(y);

		}
		
	}

}
