package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14500 {
	static int map[][];
	static int N,M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		map = new int[N][M];

		// map 입력받기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());	
		}
		
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < N; j++) {
				// 인덱스 넣어서 검사하자
				int nx = i+2;
				int ny = j+2;
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) { break;
					L(i, j);
					N(i,j);
					F(i,j);
				}
			}
		
		
	}

}
