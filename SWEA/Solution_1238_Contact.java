package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact_박서영 {

	static ArrayList<ArrayList<Integer>> list;
	static int max;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_sw1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			list = new ArrayList<ArrayList<Integer>>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<101; i++) {
				list.add(new ArrayList<>());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				list.get(x).add(y);
			}
			
			// 입력 끝
			bfs(start);
			sb.append("#").append(tc).append(" ").append(max).append('\n');
		}
		System.out.println(sb.toString());
		br.close();

	}
	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean visited[] = new boolean[101];
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			max = Integer.MIN_VALUE;
			int size = queue.size();
			
			while(size --> 0) {
				int q = queue.poll();
				max = Math.max(max, q);
	
				for(int i=0; i<list.get(q).size(); i++) {
					if(visited[list.get(q).get(i)]) continue;
					
					visited[list.get(q).get(i)] = true;
					queue.offer(list.get(q).get(i));
		
				}
			}

		}

	}

}
