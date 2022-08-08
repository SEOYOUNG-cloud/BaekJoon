package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek7568 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int map[][] = new int[N][2];
		
		// 다 입력받아놓기 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			int cnt = 1;
			for(int j = 0; j < N; j++)
				if(map[i][0] < map[j][0] && map[i][1] < map[j][1]) cnt+=1;
			
			sb.append(cnt + " ");
		}
		
		System.out.println(sb);
	}

}
