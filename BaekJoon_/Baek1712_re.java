package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1712 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
//		int N = A/(B-C)+1;
//		if(N<0)
//			System.out.println("-1");
//		else
//			System.out.println(N);
		if(C-B <= 0)
			System.out.println("-1");
		else
			System.out.println(A/(C-B)+1);

	}

}
