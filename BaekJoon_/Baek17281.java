package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek17281 {

	static int input[][];
	static int N;
	static ArrayList<Integer> order = new ArrayList<>();
	static int ru[] = new int[3];
	static int score = 0, answer = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		input = new int[N][9];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++)
				input[i][j] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝 //
	
		perm(0,0);
		
		System.out.println(answer);

	}

	// 출전 순서 인덱스 메소드
	private static void perm(int cnt, int flag) {
		if(cnt == 8) {
			order.add(3, 0);
//			System.out.println(order);
			// 이 순서대로 출전하자
			game();
			order.remove(3);
			
			return;
		}
		
		for(int i=0; i<9; i++) {
			if((flag & 1<<i) != 0) continue;
			if(i==0) continue;
			
			order.add(i);
			perm(cnt+1, (flag | 1<<i));
			order.remove(order.size()-1);
		}
	}
	
	private static void game() {
		int zero = 0; // 아웃 개수
		int number = 0; // 다음 타자 순서 (0~8)
		
		for(int n=0; n<N; n++){
			Arrays.fill(ru, 0);
			
			while(true) {
				int index = order.get(number);
				
				switch (input[n][index]) {
				case 0:
					zero += 1;
					break;
				case 1:
					anta();
					break;
				case 2:
					ruta2();
					break;
				case 3:
					ruta3();
					break;
				case 4:
					homerun();
					break;
				default:
					break;
				}
				number = (number+1) % 9;
				if(zero == 3) {
					zero=0;
					break;
				}
			}
		}
//		System.out.println(score);

		if(score > answer) 
			answer = score;
		score = 0;
		
		
	}
	private static void anta() {
		score += ru[2];
		ru[2] = ru[1];
		ru[1] = ru[0];
		ru[0] = 1;
	}
	private static void ruta2() {
		score += (ru[1] + ru[2]);
		ru[2] = ru[0];
		ru[1] = 1;
		ru[0] = 0;
	}
	private static void ruta3() {
		score += (ru[0] + ru[1] + ru[2]);
		ru[2] = 1;
		ru[1] = 0; 
		ru[0] = 0;
	}
	private static void homerun() {
		score += (ru[0] + ru[1] + ru[2] + 1);
		Arrays.fill(ru, 0);
	}

}
