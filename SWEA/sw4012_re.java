package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw4012 {
	static int N, min;
	static int map[][];
	static boolean index[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/input_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			index = new boolean[N];
			min=Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			
			System.out.println("#" + tc + " " + min);
		}

	}
	private static void comb(int cnt, int start) {
		if(cnt == N/2) {
//			System.out.println(Arrays.toString(index));
			calcul();
			return;
		}
		for(int i=start; i<N; i++) {
			index[i] = true;
			comb(cnt+1, i+1);
			index[i] = false;
		}
	}
	private static void calcul() {
		int a=0, b=0;
		for(int i=0; i<N-1; i++)
			for(int j=i; j<N; j++)
				if(index[i] && index[j]) {
					a += map[i][j] + map[j][i];
				}else if(!index[i] && !index[j])
					b += map[i][j] + map[j][i];
		
		min = Math.min(min, Math.abs(a-b));
	}

}
