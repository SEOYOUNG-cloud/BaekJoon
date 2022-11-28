package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_17825_주사위윷놀이 {
//	static int[] score = new int[10];
	static int[][] map = {{0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40},
						{10,13,16,19,25,30,35,40},
						{0,20,22,24,25,30,35,40},
						{30,28,27,26,25,30,35,40}};
	static HashMap<Integer, int[]> horse = new HashMap<>(); // 말 map번호, index (i,j)
	static int[] score = new int[10];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		horse.put(0, new int[] {0,0});
		horse.put(1, new int[] {0,0});
		horse.put(2, new int[] {0,0});
		horse.put(3, new int[] {0,0});
		
		for(int i=0; i<10; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		backtracking(0,0);
		
		System.out.println(answer);
		
	}
	static int answer = Integer.MIN_VALUE;
	private static void backtracking(int cnt, int total) {
//		System.out.println(cnt+"번째 total: " + total);
//		for(int i=0; i<4; i++) {
//			System.out.println(i + " " + Arrays.toString(horse.get(i)));
//		}
//		System.out.println();
		if(cnt==10) {
			answer = Math.max(answer, total);
			return;
		}
		
		for(int i=0; i<4; i++) { // i가 말 번호 
			if(!horse.containsKey(i)) continue;
			// choose horse
			int previous[] = horse.get(i);
			int p1 = previous[0];
			int p2 = previous[1];
			int h[] = horse.get(i); // 움직이려는 말의 맵 번호, 현재 idx 
			int nextRoot = h[0];
			int nextIdx = h[1];
			nextIdx = nextIdx + score[cnt];
			if(nextRoot == 0 && nextIdx == 5) {
				nextRoot = 1;
				nextIdx = 0;
			} else if(nextRoot == 0 && nextIdx == 10) {
				nextRoot = 2;
				nextIdx = 1;
			} else if(nextRoot == 0 && nextIdx == 15) {
				nextRoot = 3;
				nextIdx = 0;
			}
			if(nextIdx >= map[nextRoot].length) {
				horse.remove(i);
				backtracking(cnt+1, total);
				horse.put(i, new int[] {p1,p2});
				continue;
			}
			
			// 무조건 갈 수 있는 경우: '도착'에 도착해서 이동을 마치는 경우 
			//can't go: there's a horse where it want to go...
			if(confirm(i, new int[] {nextRoot,nextIdx})) { // 놓을 수 있다면 
				horse.put(i, new int[] {nextRoot,nextIdx});
				backtracking(cnt+1, total+map[nextRoot][nextIdx]);
				horse.put(i, new int[] {p1,p2});
			}
		}
	}
	private static boolean confirm(int horseCnt, int[] h) { // 현재 놓으려는 말 번호, []
		int horseRoot = h[0];
		int horseIdx = h[1];
		
		// 다른 말과 위치가 같은지 확인 
		// 빨간색 루트일 경우 다른 맵과 겹치는지 확인 ㄴㄴ 
		// 파란색 루트일 경우 map1,2,3과 서로 겹치는지 확인해야함 
		for(int i=0; i<4; i++) {
			if(i == horseCnt || !horse.containsKey(i)) continue;
			int other[] = horse.get(i);
			int root = other[0];
			int idx = other[1];
			
			// 같은 루트임 
			if(horseRoot == root) {
				if(horseIdx == idx) return false;
			}
			// 둘 다 파란색 루트 
			else if(horseRoot != 0 && root != 0) {
				// 인덱스 4 이상일 때 겹치는지 확인 
				if(horseIdx >= 4 && idx >= 4) {
					if(horseIdx == idx) return false;
				}
			}
			// 40일 때는 인덱스가 달라서 따로 빼줭 
			else if(map[horseRoot][horseIdx] == 40 && map[root][idx]==40) return false;
		}
		return true;
	}

}
