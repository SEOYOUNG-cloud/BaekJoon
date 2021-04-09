package Baek;

import java.util.Scanner;

public class Beak1193 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int X = scan.nextInt();
		
		int Fcount = 0, Lcount = 0;
		
		for(int n = 1; n <= X; n++) {   
			if(n%2 != 0) { // n=Ȧ
				for(int k=n; k>0; k--) {
	
					Fcount++;
					if(Fcount == X) {
						System.out.print(k+"/");
						break;
					}
					else {}			
				}
			
				for(int k=1; k<=n; k++) {
		
					Lcount++;
					if(Lcount == X) {
						System.out.println(k);
						break;
					}
					else {}			
				}
				if(Lcount==X) break;
			} 
		
			else { // ¦
				for(int k=1; k<=n; k++) {
		
					Lcount++;
					if(Lcount == X) {
						System.out.print(k + "/");
						break;
					}
					else {}			
				}
				for(int k=n; k>0; k--) {
					
					Fcount++;
					if(Fcount == X) {
						System.out.print(k);
						break;
					}
					else {}			
				}
				if(Lcount==X) break;
			}
		}
		
		
	}			
}

