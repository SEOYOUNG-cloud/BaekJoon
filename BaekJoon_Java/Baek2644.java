package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2644 {
	public static int n, rel1, rel2;
	public static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
	public static int visited[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		visited = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		rel1 = Integer.parseInt(st.nextToken());
		rel2 = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
				
		for(int i = 0; i < n + 1; i++)
			arrayList.add(new ArrayList<Integer>());
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int in1 = Integer.parseInt(st.nextToken());
			int in2 = Integer.parseInt(st.nextToken());
			
			arrayList.get(in1).add(in2);
			arrayList.get(in2).add(in1);
			
		}
		
		visited[rel1] = 1;
		
		System.out.println(bfs(rel1));		
		
	}
	
	public static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int out = queue.remove();
			for(int i = 0; i < arrayList.get(out).size(); i++) {
				if(visited[arrayList.get(out).get(i)] == 0) {
					visited[arrayList.get(out).get(i)] = visited[out] + 1;
					queue.add(arrayList.get(out).get(i));
				}
			}
		}
		
		if(visited[rel2] == 0) return -1;
		else return visited[rel2] - 1;
		
	}
}
