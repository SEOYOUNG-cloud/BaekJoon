package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14888_dfs {

	static int N;
	static int A[];
	static int operator[];
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		operator = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++)
			operator[i] = Integer.parseInt(st.nextToken());
		
		// 입력 끝 //
		dfs(A[0],1);
		
		System.out.println(max);
		System.out.println(min);
		

	}
	private static void dfs(int answer, int cnt) {
		if(cnt == N) {
			max = Math.max(max, answer);
			min = Math.min(min, answer);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operator[i] > 0) {
				operator[i] -= 1;
				
				switch (i) {
				case 0:
					dfs(answer + A[cnt], cnt+1);
					break;
				case 1:
					dfs(answer - A[cnt], cnt+1);
					break;
				case 2:
					dfs(answer * A[cnt], cnt+1);
					break;
				case 3:
					dfs(answer / A[cnt], cnt+1);
					break;
				default:
					break;
				}
				
				operator[i] += 1;
			}
			
		}
	}

}
