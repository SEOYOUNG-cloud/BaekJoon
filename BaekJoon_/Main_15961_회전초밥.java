package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15961_회전초밥 {

	public static void main(String[] args) throws Exception{
		//Ndkc
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		
		int N = Integer.parseInt(st.nextToken()); // 접시 수 
		int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수 
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹을 수 
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 
		
		int[] map = new int[N];
		for(int i=0; i<N; i++)
			map[i] = Integer.parseInt(br.readLine());
		
		int[] sushi = new int[d+1]; // 초밥 가짓수 배열 
//		sushi[c] += 1;
		
		// 0~k까지 종류 넣어놓음 
		int cnt = 0;
		for(int i=0; i<k; i++) {
			if(sushi[map[i]] == 0) cnt += 1;
			sushi[map[i]] += 1;
		}
		if(sushi[c] == 0) cnt += 1;
		
		
//		System.out.println(cnt);
		answer = Math.max(answer, cnt);
		if(sushi[c] == 0) {
			cnt -= 1;
		}
		
//		answer = Math.max(answer, count(sushi));
		
//		System.out.println(cnt + " " + Arrays.toString(sushi));
		
		// 배열 잘라서 종류 셀거
		int start = 1;
		for(int end=k; end<N +(N-1); end++) {
			if(start == N) break;
			
			sushi[map[start-1]] -= 1;
			if(sushi[map[start-1]] == 0) {
//				System.out.println("cnt 뺌 " + cnt);
				cnt -= 1;
			}
			
			if(end >= N) end-=N;
			if(sushi[map[end]] == 0) {
//				System.out.println("cnt 더함 " + cnt);
				cnt += 1;
			}
			sushi[map[end]] += 1;
			
//			System.out.println(start + " " + map[start] + ", " + end + " " +map[end]);
			start += 1;
			
			if(sushi[c] == 0) {
				cnt += 1;
			}
			
			
			answer = Math.max(answer, cnt);
//			System.out.println(cnt + " " + Arrays.toString(sushi));
			
			if(sushi[c] == 0) {
				cnt -= 1;
			}
			
			
		}
		
//		int end = k;
//		for(int end=k; end<N +(N-1); end++) {
//			if(start == N-1) break;
//			
//			if(sushi[map[start-1]]-1 >=0)
//				sushi[map[start-1]] -= 1;
//			
//			if(end >= N) end-=N;
//			sushi[map[end]] += 1;
//			start += 1;
//			
//			answer = Math.max(answer, count(sushi));
//		}
		
		System.out.println(answer);

	}
//	private static int count(int[] sushi) {
//		int cnt = 0;
//		for(int i=1; i<sushi.length; i++) {
//			if(sushi[i] > 0) cnt += 1;
//		}
//		
//		return cnt;
//	}

}
