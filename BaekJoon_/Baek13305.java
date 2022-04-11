package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek13305 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int city = Integer.parseInt(br.readLine());
		StringTokenizer st;
		long count = 0;
		
		
		long[] liter = new long[city];
		long[] need = new long[city - 1];
		
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i =  0; i < city-1; i++) {
			
			need[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i =  0; i < city; i++) {
			
			liter[i] = Long.parseLong(st.nextToken());
		}
		
		long min = liter[0]; // ù��° ������ ���ʹ� ������ min���� ����
		for(int i = 0; i < city - 1; i++) {
			if(min > liter[i]) min = liter[i];
			
			count += (min * need[i]);
		}
		
		System.out.println(count);
		
	}
}
