package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 1. 2가 어딨는지 탐색
 * 2. 위로 이동 -> 0행까지
 *   - 단순히 이동하는게 아니라 2에서 출발해서 한 칸 이동했을 때 해당 좌표로부터 좌/우 탐색
 *   - 이동 시마다 왼쪽 or 오른쪽에 숫자가 1인 경우 해당 방향으로 이동
 *   - 왼쪽으로 가는데 그것보다 왼쪽 값이 0이거나 경계선일 때 멈춤. 오른쪽도 마찬가지로 오른쪽 값이 n+1열이거나 0인 경우 멈춤
 * 3. 끝나면 위로 이동..하다가 왼오 살피고 이동... 반복
 * 4. 0행이 되었을 때의 열 값 출력
 * */
public class Solution_1210_ladder1_박서영 {
	static int map[][];
	static int col = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("./input (1).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for(int tc = 0; tc < 10; tc++) {
			int t = Integer.parseInt(br.readLine()); // tc번호
			
			map = new int[100][100];
			
			// map 입력받기
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// col 초기화.
			col = 0;
			
			// 2 탐색
			for(int i = 0; i < 100; i++) {
				if(map[99][i] == 2) {
					col = i;
					break;
				}
			}
			
			// 위로 이동
			for(int row = 98; row >= 0; row--) { // n-2~
				// 왼쪽이 1인 경우 -> 왼쪽으로 이동
				if(col-1 >= 0 && map[row][col-1] == 1) moveleft(row);
				
				// 오른쪽이 1인 경우 -> 오른쪽으로 이동
				else if(col+1 < 100 && map[row][col+1] == 1) moveright(row);
			}
			
			// 이동 마치고 col값 출력
			System.out.println("#" + t + " " + col);
			
			
		}

	}
	// 오른쪽으로 이동
	private static void moveright(int row) {

		while(true) {
			col++; // 오른쪽으로 이동
			// 현재 열이 오른쪽 끝열이거나 다음 오른쪽 값이 0인 경우
			if(col == 99 || map[row][col+1] == 0 ) {
				return;
			}
		}
	}
	
	// 왼쪽으로 이동
	private static void moveleft(int row) {
		while(true) {
			col--; // 왼쪽으로 이동
			// 현재 열이 왼쪽 끝열이거나 다음 왼쪽 값이 99인 경우
			if(col == 0 || map[row][col-1] == 0 ) {
				return;
			}
		}
		
	}

}
