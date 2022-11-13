package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_6603_로또 {
	
	static int k;
	static int[] map;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			
			map = new int[k];
			for(int i=0; i<k; i++)
				map[i] = Integer.parseInt(st.nextToken());
			
			order = new boolean[k];
			
			recursive(0, 0);
			System.out.println();
			
		}

	}
	static boolean order[];
	static StringBuilder sb = new StringBuilder();
	
	private static void recursive(int cnt, int start) {
		if(cnt == 6) {
			for(int i=0; i<k; i++)
				if(order[i])
					System.out.print(map[i] + " ");
			System.out.println();
			return;
		}
		for(int i=start; i<k ;i++) {
			order[i] = true;
			recursive(cnt+1, i+1);
			order[i] = false;
		}
	}

}
