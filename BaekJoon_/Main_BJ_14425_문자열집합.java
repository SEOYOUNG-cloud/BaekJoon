package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_14425_문자열집합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		int answer = 0;
		for(int i=0; i<M; i++) {
			if(set.contains(br.readLine())) answer+=1;
		}
		
		System.out.println(answer);

	}

}
