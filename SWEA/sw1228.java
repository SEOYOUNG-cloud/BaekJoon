package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> list;
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			while(N-->0)
				list.add(Integer.parseInt(st.nextToken()));
			
			int command_num = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < command_num; i++) {
				String l = st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				
				while(num-->0) {
					list.add(index++, Integer.parseInt(st.nextToken()));
				}
			}
			
			System.out.print("#" + tc + " ");
			for(int i = 0; i < 10; i++)
				System.out.print(list.get(i) + " ");
			
			System.out.println();
			
		}
		
	}

}
