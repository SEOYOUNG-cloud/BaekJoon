package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Baek1026 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		Integer[] B = new Integer[N]; // 내림차순 정렬 해줘야해서 int말고 Integer라고 선언해줌
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			B[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
		
		int count = 0;
		
		for(int i = 0; i < N; i++)
			count += (A[i] * B[i]);
		
		System.out.println(count);
	}

}
