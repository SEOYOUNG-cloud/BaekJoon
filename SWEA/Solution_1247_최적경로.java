package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1247_최적경로_박서영 {
	
	static int N;
	static int company_x, company_y, home_x, home_y; // 회사, 집 좌표
	static int[][] customer; // 고객 좌표
	static int[] number; // 고객 좌표 순열 돌린 인덱스
	static int answer;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_sw1247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			customer = new int[N][2];
			number = new int[N];
			answer=Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			company_x = Integer.parseInt(st.nextToken());
			company_y = Integer.parseInt(st.nextToken());
			home_x = Integer.parseInt(st.nextToken());
			home_y = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				customer[i][0] = x;
				customer[i][1] = y;
			}
			
//			System.out.println(Arrays.deepToString(customer));
			
			// 입력 끝 //
			perm(0,0);
			System.out.println("#" + tc + " " + answer);
		}
		

	}
	private static void perm(int cnt, int flag) {
		if(cnt == N) {
			// 거리 재서 더하기
			
			int dis = distance(number);
			if(answer > dis) {
				answer = dis;
			}
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			if((flag & 1<<i) != 0) continue;
			number[cnt] = i;
			
			perm(cnt+1, (flag | 1<<i));
		}
	}
	
	private static int distance(int[] number_idx) {
		int distance = 0;
		
		for(int i=0; i<N-1; i++) {
			int idx1 = number_idx[i];
			int idx2 = number_idx[i+1];
			
			distance += Math.abs(customer[idx1][0] - customer[idx2][0]) + Math.abs(customer[idx1][1] - customer[idx2][1]);
					
		}
		
		distance += Math.abs(company_x - customer[number_idx[0]][0]) + Math.abs(company_y - customer[number_idx[0]][1]);
		distance += Math.abs(home_x - customer[number_idx[N-1]][0]) + Math.abs(home_y - customer[number_idx[N-1]][1]);
		
		return distance;
		
	}

}
