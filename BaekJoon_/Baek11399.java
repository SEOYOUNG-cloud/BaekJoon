package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek11399 { // ATM
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> time = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		for(int i = 0; i < N; i++)
			time.add(i, Integer.parseInt(st.nextToken()));
		
		Collections.sort(time);
		int result = sum(time);
		System.out.println(result);
		
		
	}
	
	public static int sum(ArrayList<Integer> time) {
		int sum = 0;
		int change = time.get(0);
		for(int i=0; i<time.size(); i++) {
			if(i == 0) sum += time.get(0);
			else {
				change += time.get(i);
				sum += change;
			}
		}
		
		return sum;
		
		
	}

}
