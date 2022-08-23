package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek14888 {

	static int N;
	static int[] A;
	static String mix_operator[], operator[];
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		
		for(int i=0; i<N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		int idx = 0;
		operator = new String[N-1]; 
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			while(tmp-->0) {
				switch (i) {
				case 0:
					operator[idx++] = "+";
					break;
				case 1:
					operator[idx++] = "-";
					break;
				case 2:
					operator[idx++] = "*";
					break;
				case 3:
					operator[idx++] = "/";
					break;
				default:
					break;
				}
			}
		} // 연산자 입력 끝
		mix_operator = new String[N-1];
		// 입력 끝 // 
		
		perm(0,0);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	private static void perm(int cnt, int flag) {
		if(cnt == N-1) {
			System.out.println(Arrays.toString(mix_operator));
			calcul(mix_operator);
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			if((flag & 1<<i) != 0) continue;
			mix_operator[cnt] = operator[i];
			
			perm(cnt+1, (flag | 1<<i));
		}
	}
	
	private static void calcul(String[] operator) {
		
		int a = A[0];
		for(int i=0; i<N-1; i++) {
			switch (operator[i]) {
			case "+":
				a = a + A[i+1];
				break;
			case "-":
				a = a - A[i+1];
				break;
			case "*":
				a = a * A[i+1];
				break;
			case "/":
				a = a / A[i+1];
				break;
			default:
				break;
			}
		}
		
		if(a > max) max = a;
		if(a < min) min = a;
	}
}
