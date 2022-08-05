package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호_박서영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<String> DNA = new ArrayList<>(Arrays.asList("A", "C", "G", "T"));
//		HashMap<Character, Integer> map = new HashMap<>();
		Queue<Character> queue = new ArrayDeque<>();

		int cnt[] = new int[4]; // 필요한 ACGT 개수
		int answer = 0;
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String str = br.readLine(); // 문자열
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
//			map.put(key, value)
		}
		
		
		for(int i = 0; i < S; i++) {
			char tmp = str.charAt(i);
			queue.add(tmp);
			cnt[DNA.indexOf(String.valueOf(tmp))]-=1;
			
			if(queue.size() > P) {
				char del = queue.poll();
				cnt[DNA.indexOf(String.valueOf(del))] += 1;
			}
			if(queue.size() == P) {
				if(cnt[0] <= 0 && cnt[1] <= 0 && cnt[2] <= 0 && cnt[3] <= 0) answer+=1;
			}
	
		}
		
	
		System.out.println(answer);
		

	}

}
