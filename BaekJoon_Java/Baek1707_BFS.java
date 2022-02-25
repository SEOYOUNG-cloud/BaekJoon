package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1707_BFS { // BFS
	public static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
	public static int[] visited;
	public static boolean ans = false;
	public static String answer[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		String[] answer = new String[K];
		int index = 0;
		
		while(K-- > 0) {
			ans = false;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			visited = new int[V + 1];
			arrayList = new ArrayList<ArrayList<Integer>>();
			
			for(int i = 0; i <= V; i++)
				arrayList.add(new ArrayList<Integer>());
			
			while(E-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				int in1 = Integer.parseInt(st.nextToken());
				int in2 = Integer.parseInt(st.nextToken());
				
				arrayList.get(in1).add(in2);
				arrayList.get(in2).add(in1);
			}
			for(int i = 1; i <= V; i++)
				if(visited[i] == 0)
					bfs(i);
					
			if(ans) answer[index] = "NO";
			else answer[index] = "YES";
			index++;
			
		}
		for(String i : answer)
			System.out.println(i);
	}
	
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited[n] = 1;
		
		
		while(!q.isEmpty()) {
			int index = q.poll();
			
			for(int i = 0; i < arrayList.get(index).size(); i++) {
				int z = arrayList.get(index).get(i);
				if(visited[z] == 0) {
					visited[z] = visited[index] * -1;
					q.add(z);
				}
				
				if(visited[index] == visited[z]) {
					ans = true;
					return;
				}
			}
		}
			
	}
}
