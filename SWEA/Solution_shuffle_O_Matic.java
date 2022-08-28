package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_shuffle_O_Matic {

	static int N;
	static int[] map, map_clone;
	static int answer;
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N];
			map_clone = new int[N];
			answer=Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++)
				map[i] = Integer.parseInt(st.nextToken());
			
			
			//입력 끝//
			// 첫번째로 입력받은 수가 오름차순/내림차순인지 확인
			dfs(0, map);
			
			if(answer == Integer.MAX_VALUE) answer = -1;
			
			sb.append("#").append(tc).append(" ").append(answer).append('\n');
		}
		
		System.out.println(sb.toString());

	}
	private static int[] shuffle(int x, int[] left, int[] right) {
		int[] next = new int[N];
		int idx = 0;
		int leftIdx = 0;
		int rightIdx = 0;
		
		while(leftIdx < N/2 - x) {
			next[idx++] = left[leftIdx++];
		}
		
		int order = 0;
		while(leftIdx < N/2) {
			next[idx++] = order % 2 == 0 ? right[rightIdx++] : left[leftIdx++];
			order+=1;
		}
		
		while(rightIdx < N/2) {
			next[idx++] = right[rightIdx++];
		}
		
		return next;
	}
	
	private static void dfs(int cnt, int[] cards) {
		if(cnt > 5) return;
		if(cnt >= answer) return;
		
		// 1. 오름차순/내림차순인지 확인
		if(conf(cards)) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		// 2. 섞기 위해 왼쪽, 오른쪽 나누기
		int[] left = new int[N/2];
		int[] right = new int[N/2];
		
		for(int i=0; i<N/2; i++)
			left[i] = cards[i];
		
		for(int i=N/2; i<N; i++)
			right[i - N/2] = cards[i];
		
		// 3. 카드 섞어야지
		for(int x=0; x<N; x++) {
			int[] next = x<N/2? shuffle(x, left, right) : shuffle(x-N/2, right, left);
			dfs(cnt+1, next);
		}
	}
	
	// 오름차순/내림차순인지 확인하는 함수
	private static boolean conf(int[] map_clone) {
		boolean up = true;
		boolean down = true;
		for(int i=0; i<N-1; i++) {
			if(map_clone[i] >= map_clone[i+1]) up = false;
			if(map_clone[i] <= map_clone[i+1]) down = false;
			
			
		}
		if(up || down) {
			return true;
			
		}
		return false;

	}
//	private static boolean isSorted(int[] cards) {
//		boolean isUp = true;
//		boolean isDown = true;
//		for(int i=0; i<N; i++) {
//			if(cards[i] != i+1) isUp = false;
//			if(cards[i] != N-i) isDown = false;
//			
//			if(!isUp && !isDown) return false;
//		}
//		
//		return true;
//	}
	

}
