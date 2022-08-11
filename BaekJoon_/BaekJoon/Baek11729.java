package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek11729 {
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		
		sb.append((int)Math.pow(2, N) - 1 +"\n");
		
		Hanoi(N, 1,2,3);
//		System.out.println(sb);
		bw.write(String.valueOf(sb));
		
		br.close();
		bw.flush();

	}
	public static void Hanoi(int N, int start, int mid, int end) {
		if(N == 1) {
			
			sb.append(start + " " + end + "\n");
			return;
		}
		Hanoi(N-1, start, end, mid);
		sb.append(start + " " + end + "\n");
		Hanoi(N-1, mid, start, end);
	}

}
