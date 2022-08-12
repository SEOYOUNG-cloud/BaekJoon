package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek1991 {
	static char map[][];
	static ArrayList<Character> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st; 
		map = new char[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = st.nextToken().charAt(0);
			map[i][1] = st.nextToken().charAt(0);
			map[i][2] = st.nextToken().charAt(0);
		}
		Arrays.sort(map, Comparator.comparingInt(o1->o1[0])); // 정렬...!
//		System.out.println(Arrays.deepToString(map));
				
		list = new ArrayList<>();
		Pre('A');
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i));
		System.out.println();
		list = new ArrayList<>();
		
		In('A');
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i));
		System.out.println();
		list = new ArrayList<>();
		
		Post('A');
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i));
		System.out.println();
		
	}
	private static void Pre(char value) {
		if(value == '.') return;
		list.add(value);
		Pre(map[value-65][1]);
		Pre(map[value-65][2]);
	}
	
	private static void In(char value) {
		if(list.contains(value) || value == '.') return;

		In(map[value-65][1]);
		list.add(value);
		In(map[value-65][2]);
	}
	
	private static void Post(char value) {
		if(list.contains(value) || value == '.') return;
		
		Post(map[value-65][1]);
		Post(map[value-65][2]);
		list.add(value);
	}

}
