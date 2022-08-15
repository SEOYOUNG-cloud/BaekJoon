package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek21318 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int fault[] = new int[N+1];
		int before = 0;
		for(int i=1; i<=N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(before > tmp)
				fault[i] = fault[i-1] + 1;
			else
				fault[i] = fault[i-1];
			before = tmp;
		}
		
		int Q = Integer.parseInt(br.readLine());
		while(Q-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			sb.append(fault[y]-fault[x]).append('\n');
		}
		
		System.out.println(sb);

	}

}
