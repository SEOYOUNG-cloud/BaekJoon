package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2740 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int mapA[][] = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				mapA[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		st.nextToken();
		int K = Integer.parseInt(st.nextToken());
		int mapB[][] = new int[M][K];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<K; j++)
				mapB[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 입력 끝
		
		// mapB를 오른쪽으로 90도 회전하고 각 열 reverse
		int N_mapB[][] = new int[K][M];
		for(int i=0; i<M; i++)
			for(int j=0; j<K; j++)
				N_mapB[j][i] = mapB[i][j];
		
//		System.out.println(Arrays.deepToString(N_mapB));
		
		// 행렬곱 계산
		StringBuilder sb = new StringBuilder();
		for(int A=0; A<N; A++) {
			for(int B=0; B<K; B++) {
				int value=0;
				for(int i=0; i<M; i++) {
					value += mapA[A][i] * N_mapB[B][i];
				}
				sb.append(value).append(" ");
			}
			sb.append('\n');
		}
		
		// 답 출력

		System.out.println(sb.toString());

	}

}
