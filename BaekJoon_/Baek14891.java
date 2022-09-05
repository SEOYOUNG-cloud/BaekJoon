package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek14891 {

	static char map[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new char[4][8];
		
		map[0] = br.readLine().toCharArray();
		map[1] = br.readLine().toCharArray();
		map[2] = br.readLine().toCharArray();
		map[3] = br.readLine().toCharArray();
		
		int K = Integer.parseInt(br.readLine());
		while(K --> 0) {
			ArrayList<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			number-=1;
			int dir = Integer.parseInt(st.nextToken());
			
			boolean oe = true;
			if(number == 0 || number == 2) {
				oe = true; // 짝수
			} else
				oe = false; // 홀수
			

			for(int i=number; i>0; i--) { // i번째가 6, i-1번째가 2
				if(map[i][6] == map[i-1][2]) // 같은 방향이면
					break;
				else
					list.add(i-1);
			}
			
			for(int i=number; i<3; i++) {
				if(map[i][2] == map[i+1][6])
					break;
				else
					list.add(i+1);
			}
			
			if(dir == 1) clock(map[number]); // 1이면 시계방향
			else reclock(map[number]); // -1이면 반시계방향			
			
			for(int i=0; i<list.size(); i++) {
				if(oe) { // 짝수면 홀수가 dir 반대방향, 짝수는 같은 방향
					if(list.get(i)%2 == 0) // 짝수고
						reDir(dir, list.get(i));
					else // 홀수면 반대방향
						reDir(dir*(-1), list.get(i));
				} else { // 홀수면 홀수가 같은 방향, 짝수가 반대 방향
					if(list.get(i)%2 == 0)
						reDir(dir*(-1), list.get(i));
					else
						reDir(dir, list.get(i));
					
				}
			}

		}
		
		// 0이면 N극이므로 9점, 1이면 S극이므로 1,2,4,8점
		int answer = 0;
		for(int i=0; i<4; i++)
			if(map[i][0] == '1') {
				answer += Math.pow(2, i);
			}
		
		System.out.println(answer);
	}
	
	private static void reDir(int dir, int number) {
		if(dir == -1) reclock(map[number]); // 시계방향이면 반시계로 돌기
		else clock(map[number]); // 반시계면 시계방향으로 돌기
			
	}
	
	private static void clock(char array[]) {
		char tmp = array[7];
		for(int i=7; i>=1; i--)
			array[i] = array[i-1];
		array[0] = tmp;
	}
	private static void reclock(char array[]) {
		char tmp = array[0];
		for(int i=0; i<=6; i++)
			array[i] = array[i+1];
		array[7] = tmp;
	}

}
