package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek13458 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int room[] = new int[N];
		
		for(int i = 0; i < N; i++)
			room[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long cnt = N;
		for(int i = 0; i < N; i++) {
			if(room[i]-B <= 0) continue;
			cnt += (int)Math.ceil((double)(room[i]-B) / (double)C);
		}
		
		System.out.println(cnt);

	}

}
