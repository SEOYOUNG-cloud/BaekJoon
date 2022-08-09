package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw9229 {
	static int N, M;
	static Integer input[];
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int max = -1;
			
			input = new Integer[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				input[i] = Integer.parseInt(st.nextToken());
			
			
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					if(input[i] + input[j] <= M && max < input[i] + input[j]) {
						max = input[i] + input[j];
					}
				}
			}
			
			if(max == Integer.MIN_VALUE) max = -1;
			System.out.println("#" + tc + " " + max);
		}	

	}

}
