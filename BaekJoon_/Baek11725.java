package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baek11725 {
	public static int T;
	public static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
	public static int visited[];
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		visited = new int[T+1]; // 1~T까지
		
		for(int i = 0; i <= T+1; i++)
			arrayList.add(new ArrayList<Integer>());
		
		for(int i = 1; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int in1 = Integer.parseInt(st.nextToken());
			int in2 = Integer.parseInt(st.nextToken());
			
			arrayList.get(in1).add(in2);
			arrayList.get(in2).add(in1);
		}
		
		visited[1] = 1;
		
		bfs(1);
		
		for(int i = 2; i < T+1; i++)
			System.out.println(visited[i]);
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int out = queue.remove();
			
			for(int i = 0; i < arrayList.get(out).size(); i++) {
				int y = arrayList.get(out).get(i);
				if(visited[y] == 0) {
					visited[y] = out;
					queue.add(y);
				}
			}
		}
		
	}

}
