package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_2607_비슷한단어 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String original = br.readLine();
		HashMap<Character, Integer> originalMap = new HashMap<>();
		for(int i=0; i<original.length(); i++) {
			char key = original.charAt(i);
			int value = originalMap.getOrDefault(key, 0);
			originalMap.put(key, value+1);
		}
		
		int answer = 0;
		for(int i=0; i<T-1; i++) {
			// original map clone
			HashMap<Character, Integer> compareMap = new HashMap<>();
			for(Character key : originalMap.keySet()) {
				compareMap.put(key, originalMap.get(key));
			}
			
			int cnt = 0; // 현재 알파벳이 원본에 없을 경우 +1
			int cnt2 = 0; // 현재 알파벳을 다 제했는데 원본에는 글자가 남아있을 경우 +1
			
			// check
			// 현재 알파벳을 원본에서 뺀다.
			String checkStr = br.readLine();
			for(int c=0; c<checkStr.length(); c++) {
				char key = checkStr.charAt(c);
				Integer value = compareMap.get(key);
				
				if(value == null || value == 0) {
					cnt += 1;
				} else {
					compareMap.put(key, value-1);
				}
				
				if(cnt > 1) {
					break;
				}
			}
			
			// 원본에 글자가 남아있음 (=두 단어가 같은 구성이 아닌경우)
			for(Character key : compareMap.keySet()) {
				if(compareMap.get(key) >= 1) cnt2+=1;
			}

			
			if((cnt+cnt2 <= 1) || cnt==1&&cnt2==1) {
				answer += 1;
			}
		}
		
		System.out.println(answer);
	}
}
