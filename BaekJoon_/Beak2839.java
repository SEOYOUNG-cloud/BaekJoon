package BeakJoon;

import java.util.Scanner;

public class Beak2839 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		
		if(N >= 5) {
		
			int i = N / 5; // ¸ò

			for(int k = i; k >= 0; k--) {

				int j = N - (5 * k); // ³ª¸ÓÁö

				if(j % 3 == 0) {
					System.out.println(k + j/3);
					break;}
				else if(j == N)
					System.out.println("-1");
			}
		}
		
		else
		{
			if(N % 3 == 0)
				System.out.println(N/3);
			else
				System.out.println("-1");
		}
		
		scan.close();
	}

}
