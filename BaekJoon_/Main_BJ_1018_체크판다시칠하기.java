package BaekJoon;
 
import java.util.*;
import java.io.*;

public class Main_BJ_1018_체크판다시칠하기 {

	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String in = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = in.charAt(j);
			}
		}
		
		/////////
		int[][] whiteMap = new int[N][M];
		// 흰 먼저
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if((i+j)%2 == 0 && map[i][j] == 'B') { // 0 2 4 6 .. 이런 짝수자리
					whiteMap[i][j] = 1;
				} else if((i+j)%2 == 1 && map[i][j] == 'W'){ // 홀수자리
					whiteMap[i][j] = 1;
				} else {
					whiteMap[i][j] = 0;
				}
			}
		}
		
		// 검 먼저
		int[][] blackMap = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if((i+j)%2 == 0 && map[i][j] == 'W') { // 0 2 4 6 .. 이런 짝수자리
					blackMap[i][j] = 1;
				} else if((i+j)%2 == 1 && map[i][j] == 'B'){ // 홀수자리
					blackMap[i][j] = 1;
				} else {
					blackMap[i][j] = 0;
				}
			}
		}
		
		int black = Integer.MAX_VALUE;
		int white = Integer.MAX_VALUE;
		for(int i=0; i<=(N-8); i++) {
			for(int j=0; j<=(M-8); j++) {
				int cntW = 0;
				int cntB = 0;
				for(int x=i; x<i+8; x++) {
					for(int y=j; y<j+8; y++) {
						cntW += whiteMap[x][y];
						cntB += blackMap[x][y];
					}
				}
				white = Math.min(cntW, white);
				black = Math.min(cntB, black);
			}
		}
		
		int answer = 0;
		if(white < black) answer = white;
		else answer = black;
		
		System.out.println(answer);
		
		
	}

}
