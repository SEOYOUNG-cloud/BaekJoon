package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek2792 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] map = new int[M];
		int right = Integer.MIN_VALUE, left=1, mid=-1, answer=0;
		
		for(int i=0; i<M; i++) {
			int in = Integer.parseInt(br.readLine());
			map[i] = in;
			right = Math.max(right, in);
		}
		
		while(left <= right) {
			int sum = 0; // 나눠줄 수 있는 사람 수
			mid = (left + right) / 2; // 나눠줄 보석 개수
			
			for(int i=0; i<M; i++) {
				sum += map[i]/mid;
				if(map[i] % mid != 0) sum +=1;
			}
			
			if(sum <= N) { // 나눠줄 사람이 실제 사람 수보다 작거나 같으면 보석을 몇명 안줬다는거 보석 덜주고 사람 늘리기
				right = mid-1;
				answer = mid; // 현재 mid값이 답일 수 있음
			}
			else { // 나눠줄 사람이 실제보다 많다는건 보석을 많은 사람에게 준거.. 보석 한명당 더주기
				left = mid+1;
			}
		}
		
		System.out.println(answer);
		
		
	}

}
