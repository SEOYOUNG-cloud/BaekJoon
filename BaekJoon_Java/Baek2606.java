package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Baek2606 {
	public static ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
	public static boolean[] visited = new boolean[101];
	public static int count = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int com = Integer.parseInt(br.readLine());
		int couple = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < 10001; i++)
			array.add(new ArrayList<Integer>()); // 초기화 
			
		
		for(int i = 0; i < couple; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			array.get(x).add(y);
			array.get(y).add(x);
		}
		
		for(int i = 0; i < com + 1; i++)
			Collections.sort(array.get(i)); // 오름차순 정렬
		
		if(dfs(1)) System.out.println(count - 1);  //맨 처음 시작점 1을 제외하기 위해 -1 해줌
		
	}
	
	public static boolean dfs(int x) {
		visited[x] = true;
		count ++;
		
		for(int i = 0; i < array.get(x).size(); i++) {
			int y = array.get(x).get(i);
			if(!visited[y]) {
				dfs(y);
			}
		}
		return true;
	}
}
