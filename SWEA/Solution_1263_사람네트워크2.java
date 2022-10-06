package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_사람네트워크2.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			
			// 플로이드 워샬 써보기
			int[][] distance = new int[N][N];
			int INF = N+1;
			
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					if(i!=j && map[i][j] == 0) distance[i][j] = INF;
					else distance[i][j] = map[i][j];
			
			
			// 3중 for문 돌면서 최소 인접 구하기 
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					if(i==k) continue;
					for(int j=0; j<N; j++) {
						if(i==j || j==k) continue;
						if(distance[i][j] > distance[i][k] + distance[k][j])
							distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
			
			// 답 구하기
			int total = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				int cnt = 0;
				for(int j=0; j<N; j++) {
					cnt += distance[i][j];
				}
				if(cnt < total) {
					total = cnt;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(total).append('\n');
			
		}
		
		System.out.println(sb.toString());
		
	}

}
