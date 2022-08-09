package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제_박서영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 1; i <= N; i++)
			list.add(i);
		
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while(!list.isEmpty()) {
			index += K-1;
			while(index >= list.size()) {
				index -= list.size();
			}
			sb.append(", ").append(list.get(index));
			list.remove(index);
		}
		System.out.print("<" + sb.substring(2) + ">");

	}

}
