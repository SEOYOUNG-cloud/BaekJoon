package BaekJoon;

import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class Main_BJ_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> num = new HashMap<>();
		Map<String, Integer> str = new HashMap<>();
		
		for(int i=1; i<=N; i++) {
			String in = br.readLine();
			num.put(i, in);
			str.put(in, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String in = br.readLine();
			if(Pattern.matches("^[0-9]*$", in)) { // 숫자면
				sb.append(num.get(Integer.parseInt(in))).append('\n');
			} else {
				sb.append(str.get(in)).append('\n');
			}
		}
		System.out.println(sb.toString());

	}

}
