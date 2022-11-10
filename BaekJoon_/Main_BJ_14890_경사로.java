package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_14890_경사로 {

	static int N, L;
	static int[][] map;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 지도 가로,세로 길이 N
		L = Integer.parseInt(st.nextToken()); // 경사로 길이 L\

		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		// 입력 끝 .//

		// 가로
		for(int i=0; i<N; i++) {
			// 한 줄
			int[] line = map[i];

			confirm(line);
		}

		// 세로
		for(int i=0; i<N; i++) {
			int[] line2 = new int[N];
			for(int j=0; j<N; j++) {
				line2[j] = map[j][i];
			}
			confirm(line2);
		}

		System.out.println(answer);

	}
	static int answer = 0;
	private static void confirm(int[] line) {
		// 경사로를 놨는지 확인할 배열
		boolean visited[] = new boolean[N];

		for(int l=0; l<N-1; l++) {
			// 다음꺼랑 같으면 넘어가고, 다르면 1.1 차이나는지, 2. 큰지 작은지 확인
			if(line[l] != line[l+1]) {
				// 차이가 2 이상이라면 그 줄은 볼것도 없이 X
				if(Math.abs(line[l]-line[l+1]) >= 2) return;

				// 다음거가 더 클 때
				if(line[l] < line[l+1]) {
					// 이전을 L-1개 확인해서 경사로를 놓을 수 있는지 확인
					// 경사로를 놔야하는 부분이 범위를 넘어가는지 확인
					if(l+1-L < 0) return;
					for(int r=l; r>=(l+1-L); r--) {
						if(line[r] != line[l] || visited[r]) {
							return;
						}
						visited[r] = true;
					}
				}
				// 다음거가 더 작을 때 - 뒤 확인
				else {
					if(l+L >= N) return;
					for(int r=l+1; r<=l+L; r++) {
						if(line[r] != line[l+1] || visited[r]) {
							return;
						}
						visited[r] = true;
					}
				}
			}
		}
		answer += 1;

	}

}