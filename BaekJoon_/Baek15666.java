package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek15666 {
	static int N,M;
	static int number[];
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int in = Integer.parseInt(st.nextToken());
			if(list.contains(in)) continue;
			list.add(in);
		}
		Collections.sort(list);
		
		combination(0,0);
		
	}
	private static void combination(int cnt, int start) {
		if(cnt == M) {
			for(int i=0; i<M; i++)
				System.out.print(number[i] + " ");
			System.out.println();
			
			return;
		}
		for(int i=start; i<list.size(); i++) {
			number[cnt] = list.get(i);
			combination(cnt+1, i);
		}
	}

}
