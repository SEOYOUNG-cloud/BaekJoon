package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_5373_큐빙 {
	
	static char[][] front, back, up, down, left, right;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			front = new char[3][3];
			back = new char[3][3];
			up = new char[3][3];
			down = new char[3][3];
			left = new char[3][3];
			right = new char[3][3];
			
			for(int i=0; i<3; i++) {
				Arrays.fill(up[i], 'w');
				Arrays.fill(down[i], 'y');
				Arrays.fill(front[i], 'r');
				Arrays.fill(back[i], 'o');
				Arrays.fill(left[i], 'g');
				Arrays.fill(right[i], 'b');
			}

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				String command = st.nextToken();
				char dir = command.charAt(0);
				char clockDir = command.charAt(1);
				
				switch (dir) {
				case 'U':
					UpMove(clockDir);
					break;
				case 'D':
					DownMove(clockDir);
					break;
				case 'F':
					FrontMove(clockDir);
					break;
				case 'B':
					BackMove(clockDir);
					break;
				case 'L':
					LeftMove(clockDir);
					break;
				case 'R':
					RightMove(clockDir);
					break;

				default:
					break;
				}
				
			}
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					sb.append(up[i][j]);
				}
				sb.append('\n');
			}
			
		}
		System.out.println(sb.toString());

	}
	private static void BackMove(char cmd) {
		if(cmd == '-') {
			RClock(back);
			RClock(back);
		} else {
			Clock(back);
			Clock(back);
		}
		for(int i=0; i<3; i++) {
			char start = up[0][0];
			if(cmd == '-') {
				up[0][0] = left[0][0];
				left[0][0] = left[1][0];
				left[1][0] = left[2][0];
				left[2][0] = down[2][0];
				down[2][0] = down[2][1];
				down[2][1] = down[2][2];
				down[2][2] = right[2][2];
				right[2][2] = right[1][2];
				right[1][2] = right[0][2];
				right[0][2] = up[0][2];
				up[0][2] = up[0][1];
				up[0][1] = start;
			} else {
				up[0][0] = up[0][1];
				up[0][1] = up[0][2];
				up[0][2] = right[0][2];
				right[0][2] = right[1][2];
				right[1][2] = right[2][2];
				right[2][2] = down[2][2];
				down[2][2] = down[2][1];
				down[2][1] = down[2][0];
				down[2][0] = left[2][0];
				left[2][0] = left[1][0];
				left[1][0] = left[0][0];
				left[0][0] = start;
			}
		}
	}
	private static void FrontMove(char cmd) {
		if(cmd == '-') {
			RClock(front);
			RClock(front);
		} else {
			Clock(front);
			Clock(front);
		}
		for(int i=0; i<3; i++) {
			char start = up[2][0];
			if(cmd == '-') {
				up[2][0] = up[2][1];
				up[2][1] = up[2][2];
				up[2][2] = right[0][0];
				right[0][0] = right[1][0];
				right[1][0] = right[2][0];
				right[2][0] = down[0][2];
				down[0][2] = down[0][1];
				down[0][1] = down[0][0];
				down[0][0] = left[2][2];
				left[2][2] = left[1][2];
				left[1][2] = left[0][2];
				left[0][2] = start;
			}else {
				up[2][0] = left[0][2];
				left[0][2] = left[1][2];
				left[1][2] = left[2][2];
				left[2][2] = down[0][0];
				down[0][0] = down[0][1];
				down[0][1] = down[0][2];
				down[0][2] = right[2][0];
				right[2][0] = right[1][0];
				right[1][0] = right[0][0];
				right[0][0] = up[2][2];
				up[2][2] = up[2][1];
				up[2][1] = start;
				
			}
		}
	}
	private static void RightMove(char cmd) {
		if(cmd == '-') {
			RClock(right);
			RClock(right);
		} else {
			Clock(right);
			Clock(right);
		}
		for(int i=0; i<3; i++) {
			char start = down[2][2];
			if(cmd == '-') {
				down[2][2] = down[1][2];
				down[1][2] = down[0][2];
				down[0][2] = front[2][2];
				front[2][2] = front[1][2];
				front[1][2] = front[0][2];
				front[0][2] = up[2][2];
				up[2][2] = up[1][2];
				up[1][2] = up[0][2];
				up[0][2] = back[2][2];
				back[2][2] = back[1][2];
				back[1][2] = back[0][2];
				back[0][2] = start;
			}else {
				down[2][2] = back[0][2];
				back[0][2] = back[1][2];
				back[1][2] = back[2][2];
				back[2][2] = up[0][2];
				up[0][2] = up[1][2];
				up[1][2] = up[2][2];
				up[2][2] = front[0][2];
				front[0][2] = front[1][2];
				front[1][2] = front[2][2];
				front[2][2] = down[0][2];
				down[0][2] = down[1][2];
				down[1][2] = start;
			}
		}
	}
	private static void LeftMove(char cmd) {
		if(cmd == '-') {
			RClock(left);
			RClock(left);
		} else {
			Clock(left);
			Clock(left);
		}
		for(int i=0; i<3; i++) {
			char start = back[0][0];
			if(cmd == '-') {
				back[0][0] = back[1][0];
				back[1][0] = back[2][0];
				back[2][0] = up[0][0];
				up[0][0] = up[1][0];
				up[1][0] = up[2][0];
				up[2][0] = front[0][0];
				front[0][0] = front[1][0];
				front[1][0] = front[2][0];
				front[2][0] = down[0][0];
				down[0][0] = down[1][0];
				down[1][0] = down[2][0];
				down[2][0] = start;
			} else {
				back[0][0] = down[2][0];
				down[2][0] = down[1][0];
				down[1][0] = down[0][0];
				down[0][0] = front[2][0];
				front[2][0] = front[1][0];
				front[1][0] = front[0][0];
				front[0][0] = up[2][0];
				up[2][0] = up[1][0];
				up[1][0] = up[0][0];
				up[0][0] = back[2][0];
				back[2][0] = back[1][0];
				back[1][0] = start;
			}
		}
	}
	
	private static void DownMove(char cmd) {
		if(cmd == '-') {
			RClock(down);
			RClock(down);
		} else {
			Clock(down);
			Clock(down);
		}
		for(int i=0; i<3; i++) {
			char start = back[0][0];
			// 반시계
			if(cmd == '-') {
				back[0][0] = left[2][0];
				left[2][0] = left[2][1];
				left[2][1] = left[2][2];
				left[2][2] = front[2][0];
				front[2][0] = front[2][1];
				front[2][1] = front[2][2];
				front[2][2] = right[2][0];
				right[2][0] = right[2][1];
				right[2][1] = right[2][2];
				right[2][2] = back[0][2];
				back[0][2] = back[0][1];
				back[0][1] = start;
			}
			else {
				back[0][0] = back[0][1];
				back[0][1] = back[0][2];
				back[0][2] = right[2][2];
				right[2][2] = right[2][1];
				right[2][1] = right[2][0];
				right[2][0] = front[2][2];
				front[2][2] = front[2][1];
				front[2][1] = front[2][0];
				front[2][0] = left[2][2];
				left[2][2] = left[2][1];
				left[2][1] = left[2][0];
				left[2][0] = start;
			}
		}
	}
	private static void UpMove(char cmd) {
		if(cmd == '-') {
			RClock(up);
			RClock(up);
		} else {
			Clock(up);
			Clock(up);
		}
		for(int i=0; i<3; i++) {
			char start = back[2][0];
			// 반시계
			if(cmd == '-') {
				//move
				back[2][0] = back[2][1];
				back[2][1] = back[2][2];
				back[2][2] = right[0][2];
				right[0][2] = right[0][1];
				right[0][1] = right[0][0];
				right[0][0] = front[0][2];
				front[0][2] = front[0][1];
				front[0][1] = front[0][0];
				front[0][0] = left[0][2];
				left[0][2] = left[0][1];
				left[0][1] = left[0][0];
				left[0][0] = start;
			} else {
				//move
				back[2][0] = left[0][0];
				left[0][0] = left[0][1];
				left[0][1] = left[0][2];
				left[0][2] = front[0][0];
				front[0][0] = front[0][1];
				front[0][1] = front[0][2];
				front[0][2] = right[0][0];
				right[0][0] = right[0][1];
				right[0][1] = right[0][2];
				right[0][2] = back[2][2];
				back[2][2] = back[2][1];
				back[2][1] = start;
			}
		}
		
	}
	
	private static void Clock(char[][] arr) {
		char start = arr[0][0];
		arr[0][0] = arr[1][0];
		arr[1][0] = arr[2][0];
		arr[2][0] = arr[2][1];
		arr[2][1] = arr[2][2];
		arr[2][2] = arr[1][2];
		arr[1][2] = arr[0][2];
		arr[0][2] = arr[0][1];
		arr[0][1] = start;
	}
	private static void RClock(char[][] arr) {
		char start = arr[0][0];
		arr[0][0] = arr[0][1];
		arr[0][1] = arr[0][2];
		arr[0][2] = arr[1][2];
		arr[1][2] = arr[2][2];
		arr[2][2] = arr[2][1];
		arr[2][1] = arr[2][0];
		arr[2][0] = arr[1][0];
		arr[1][0] = start;
	}

}
