package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5644_무선충전_박서영 {
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/input_5644.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 총 이동시간
			int A = Integer.parseInt(st.nextToken()); // BC의 개수
			
			// A,B 인간 이동 받음
			int moveA[] = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++)
				moveA[i] = Integer.parseInt(st.nextToken());
			int moveB[] = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++)
				moveB[i] = Integer.parseInt(st.nextToken());
			
			// BC 정보 입력받음
			int BC[][] = new int[A][4];
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++)
					BC[i][j] = Integer.parseInt(st.nextToken());
			}
			
			//// 입력 끝
			
			//A,B 좌표 집어넣기
			int mapA[][] = new int[M+1][2];
			int mapB[][] = new int[M+1][2];
			mapA[0] = new int[] {0,0};
			mapB[0] = new int[] {9,9};
			int a_x = 0, a_y = 0;
			int b_x = 9, b_y = 9;
			for(int i=0; i<M; i++) {
				switch(moveA[i]) {
				case 0:
					break;
				case 1:
					a_x -= 1;
					break;
				case 2:
					a_y += 1;
					break;
				case 3:
					a_x += 1;
					break;
				case 4:
					a_y -= 1;
					break;
				}
				mapA[i+1] = new int[] {a_x, a_y};
			}
			for(int i=0; i<M; i++) {
				switch(moveB[i]) {
				case 0:
					break;
				case 1:
					b_x -= 1;
					break;
				case 2:
					b_y += 1;
					break;
				case 3:
					b_x += 1;
					break;
				case 4:
					b_y -= 1;
					break;
				}
				mapB[i+1] = new int[] {b_x, b_y};
			}
//			System.out.println("A: " + Arrays.deepToString(mapA));
//			System.out.println("B: " + Arrays.deepToString(mapB));
			
			// 각 BC들 좌표 넣기~ (최대 8개 존재함)
			ArrayList<ArrayList<int[]>> arrayList = new ArrayList<ArrayList<int[]>>();
			for(int c=0; c<A; c++) { // BC의 개수만큼....
				ArrayList<int[]> list = new ArrayList<>();
				int x = BC[c][1]-1;
				int y = BC[c][0]-1;
				int dis = BC[c][2];
				
				for(int i=0; i<10; i++)
					for(int j=0; j<10; j++)
						if(Math.abs(x-i) + Math.abs(y-j) <= dis) {
							list.add(new int[] {i,j});
						}
				arrayList.add(list);
			} // 좌표 넣기 끝
			
			int total = 0;
			// M번 이동하는동안 충전량 구해야함
			for(int i=0; i<=M; i++) {
				ArrayList<Integer> A_chargeNum = new ArrayList<>();
				ArrayList<Integer> B_chargeNum = new ArrayList<>();
				
				for(int m=0; m<A; m++) {
					for(int a=0; a<arrayList.get(m).size(); a++) {
						if(Arrays.toString(mapA[i]).equals(Arrays.toString(arrayList.get(m).get(a)))) A_chargeNum.add(m);
						if(Arrays.toString(mapB[i]).equals(Arrays.toString(arrayList.get(m).get(a)))) B_chargeNum.add(m);
					}
				} // m=i일 때 A,B 각각에 BC와 닿는다면 인덱스 넣었음
				
				// 충전량 큰걸로 정해서 더해야함
				if(A_chargeNum.size() == 0 && B_chargeNum.size() == 0) ;

				else if(B_chargeNum.size() == 0) {
					int max = Integer.MIN_VALUE;
					for(int a=0; a<A_chargeNum.size(); a++)
						if(max < BC[A_chargeNum.get(a)][3]) max = BC[A_chargeNum.get(a)][3];
					total += max;
				} else if(A_chargeNum.size() == 0) {
					int max = Integer.MIN_VALUE;
					for(int b=0; b<B_chargeNum.size(); b++)
						if(max < BC[B_chargeNum.get(b)][3]) max = BC[B_chargeNum.get(b)][3];
					total += max;
				}				
				else {
					int max = Integer.MIN_VALUE;
		
					for(int a=0; a<A_chargeNum.size(); a++) {
						for(int b=0; b<B_chargeNum.size(); b++) {
							int count=0;
							if(A_chargeNum.get(a) == B_chargeNum.get(b)) {
								count = BC[A_chargeNum.get(a)][3];
							}
							else {
								count = BC[A_chargeNum.get(a)][3] + BC[B_chargeNum.get(b)][3];
							}
							
							max = Math.max(max, count);
						}
												
					}
					
					total += max;
				}
				
			}			
			
			System.out.println("#" + tc + " " + total);
		}


	}

}
