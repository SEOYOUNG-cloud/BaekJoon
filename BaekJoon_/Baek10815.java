package Baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek10815 { // bufferedwriter 썼더니 메모리랑 시간 올라감 ;;
	
	static int N_arr[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		N_arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			N_arr[i] = Integer.parseInt(st.nextToken());
		}
	
		Arrays.sort(N_arr);
//		System.out.println(Arrays.toString(N_arr));
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int a = Integer.parseInt(st.nextToken());
			sb.append(find(0, N-1, a)).append(" ");
		}
	
		System.out.println(sb.toString());
//		bw.write(sb.toString());
//		bw.flush();
		br.close();
//		bw.close();
		
	}
	private static int find(int start, int end, int N) {
		
		while(start <= end) {
			int middle = (start+end) / 2;
			
			if(N > N_arr[middle]) {
				start = middle + 1;
			}
			else if(N < N_arr[middle]) {
				end = middle - 1;
			}
			else {
				return 1;
			}
		}
		return 0;
	}

}
