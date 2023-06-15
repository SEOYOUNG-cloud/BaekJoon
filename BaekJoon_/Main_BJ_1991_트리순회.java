package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1991_트리순회 {
	
	static int N;
	static char[][] node;
	static HashSet<Character> set;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		node = new char[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			node[i][0] = st.nextToken().charAt(0);
			node[i][1] = st.nextToken().charAt(0);
			node[i][2] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(node, (o1,o2) -> Character.compare(o1[0], o2[0]));
		
		set = new HashSet<>();
		
		Pre('A');
		sb.append('\n');
		
		set = new HashSet<>();
		In('A');
		sb.append('\n');
		
		set = new HashSet<>();
		Post('A');
		
		System.out.println(sb.toString());
		
		
	}
	private static void Pre(char now) {
		if(set.contains(now) || now == '.') return;
		sb.append(now);
		set.add(now);
		Pre(node[now-65][1]);
		Pre(node[now-65][2]);
	}
	
	private static void In(char now) {
		if(set.contains(now) || now == '.') return;
		In(node[now-65][1]);
		sb.append(now);
		set.add(now);
		In(node[now-65][2]);
	}
	
	private static void Post(char now) {
		if(set.contains(now) || now == '.') return;
		Post(node[now-65][1]);
		Post(node[now-65][2]);
		sb.append(now);
		set.add(now);
	}
	

}
