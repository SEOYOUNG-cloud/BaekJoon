package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합_박서영 {
	
	static int n,m;
	static int node[];

	public static void main(String[] args) throws Exception{
//		Set<Integer>[] set = new Set[5];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
		
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			// 값 넣어놓음
			node = new int[n+1];
			for(int i=1; i<=n; i++)
				node[i] = i;
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			while(m-->0) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch (cmd) {
				case 0:
					Union(a,b);
					break;
				case 1:
					if(Conf(a,b)) sb.append("1");
					else sb.append("0");
					break;
				default:
					break;
				}
			}
			
			System.out.println(sb.toString());
		}
		

	}
	private static int Find(int n) {
		if(node[n] == n) return n;
		
		return node[n] = Find(node[n]);
	}
	
	private static void Union(int a, int b) {
		if(Find(a) == Find(b)) return;
		
		node[Find(a)] = Find(b);
	}
	
	private static boolean Conf(int a, int b) {
		if(Find(a) == Find(b)) return true;
		else return false;
	}

}
