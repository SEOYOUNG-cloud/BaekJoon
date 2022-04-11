package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2869 { // Scanner -> time out
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		
		if((V-B) % (A-B) == 0)
			System.out.println((V-B) / (A-B));
		else
			System.out.println((V-B) / (A-B) + 1);

		
			
			/*int count = 0, day = 0;
			while(1) {
				day += A;
				count++;
				if(day >= V) break;
				else {
					day -= B;
				}	
			}
			System.out.println(count); Intuitive code -> timeout */

				
	}
}
