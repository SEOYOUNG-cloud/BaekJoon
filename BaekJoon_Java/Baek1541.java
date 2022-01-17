package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baek1541 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] sub = br.readLine().split("-");
		
		int sum = Integer.MAX_VALUE; // 정수 중 가장 큰 값인 2147483647
		
		for(int i = 0; i < sub.length; i++) {
			int temp = 0;
			
			String[] add = sub[i].split("\\+"); // for문 돌 때마다 초기화
			
			for(int j = 0; j < add.length; j++)
				temp += Integer.parseInt(add[j]); // String 배열이라 int화 해줘야함
			
			if(sum == Integer.MAX_VALUE) // 가장 앞에있는 수만 +
				sum = temp;
			else {  // 그 뒤는 다 -
				sum -= temp;
			}		
		}
		
		System.out.println(sum);
				
		
	}

} // 1+2-3+4+5-10+5

