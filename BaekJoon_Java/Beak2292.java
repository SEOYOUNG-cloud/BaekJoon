package BeakJoon;

import java.util.Scanner;

public class Beak2292 { // ¹úÁý
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int F = 2, L = 0;
		
		if(N == 1)
			System.out.println("1");
		else {
			
			for(int n = 1; n < N; n++) {
				L = F + (6*n - 1);
				if(N >= F && N <= L) {
					System.out.println(n+1);
					break;
				}
				
				F = L + 1;
			}
		}
	}
}
