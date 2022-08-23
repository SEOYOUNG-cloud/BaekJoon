package Baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Baek10815_set {
	static int N_arr[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
	
//		System.out.println(Arrays.toString(N_arr));
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int a = Integer.parseInt(st.nextToken());
			sb.append(set.contains(new Integer(a)) ? 1 : 0).append(" ");
		}
	
		System.out.println(sb.toString());
		br.close();
		
	}
}
