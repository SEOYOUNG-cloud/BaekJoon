package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_2800_괄호제거 {
	
	static int cnt;
	static char[] input;
	static int[][] bracket;
	static Set<String> answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		answer = new HashSet<>();

		cnt=0;
		for(int i=0; i<input.length; i++) {
			if(input[i] == '(') cnt++;
		}
		bracket = new int[cnt][2];
		
		/**/
		Stack<Integer> stack = new Stack<>();
		for(int i=0, idx=0; i<input.length; i++) {
			if(input[i] == '(') {
				stack.add(i);
			} else if(input[i] == ')') {
				bracket[idx][0] = stack.pop();
				bracket[idx++][1] = i;
			}
		}
		
		
		////
		for(int i=1; i<=cnt; i++) {
			select(i, 0, 0, new int[i]);
		}
		
		ArrayList<String> ans = new ArrayList<>(answer);
		Collections.sort(ans);
		for(int i=0; i<answer.size(); i++) {
			System.out.println(ans.get(i));
		}

	}
	// 조합
	private static void select(int N, int start, int count, int[] order) {
		// N개 삭제하고 answer에 저장 
		if(count == N) {
			remove(order);
			return;
		}
		for(int i=start; i<cnt; i++) {
			order[count] = i;
			select(N, i+1, count+1, order);
		}
	}
	
	private static void remove(int[] order) {
		StringBuilder sb = new StringBuilder();
		
		Set<Integer> removeList = new HashSet<>();
		for(int i=0; i<order.length; i++) {
			int o = order[i]; // 삭제시킬 인덱스 
			removeList.add(bracket[o][0]);
			removeList.add(bracket[o][1]);
		}
		
		// 삭제 ㄱ ㄱ
		for(int i=0; i<input.length; i++) {
			if(!removeList.contains(i)) sb.append(input[i]);
		}
		
		answer.add(sb.toString());
	}
	

}
