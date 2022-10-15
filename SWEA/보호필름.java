import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.Arrays;

import java.util.StringTokenizer;

 

public class Solution {

	

	static int r,c,k;

	static int[][] map;

	static int answer;

 

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;

		

		for(int tc=1; tc<=T; tc++) {

			st = new StringTokenizer(br.readLine());

			r = Integer.parseInt(st.nextToken());

			c = Integer.parseInt(st.nextToken());

			k = Integer.parseInt(st.nextToken());

			

			map = new int[r][c];

			for(int i=0; i<r; i++) {

				st = new StringTokenizer(br.readLine());

				for(int j=0; j<c; j++) {

					map[i][j] = Integer.parseInt(st.nextToken());

				}

			}

			

//			System.out.println(Arrays.deepToString(map));

			// 입력 끝 //

			

			A = new int[c];

			B = new int[c];

			for(int i=0; i<c; i++) {

				A[i] = 0; // A

				B[i] = 1; // B

			}

			

			answer = Integer.MAX_VALUE;

			

			

			dfs(0,0);

//			check(map);

			

			sb.append("#").append(tc).append(" ").append(answer).append('\n');
			
		}

		System.out.println(sb.toString());
 

	}

	static int A[];

	static int B[];

	

	private static void dfs(int cnt, int idx) {

		// 가지치기

		if(answer < cnt) {

			return;

		}

		

		if(idx == r) {

			// 행만큼 선택 했으므로 check로 이동

			if(check(map)) {

				answer = Math.min(answer, cnt);

			}

			return;

		}

		

		int temp[] = map[idx];

		dfs(cnt, idx+1);

		map[idx] = A;

		dfs(cnt+1, idx+1);

		map[idx] = B;

		dfs(cnt+1, idx+1);

		

		map[idx] = temp;

		

	}

 

	private static boolean check(int[][] map) {	
		for(int i=0; i<c; i++) {
			
			int arr[] = new int[r];

			for(int j=0; j<r; j++) {

				arr[j] = map[j][i];

			} // 한줄 체크할 배열 만들었음
			
			// k 만큼 연속되는 수가 있다면 끝냄
			int total = 0;
			
			int cnt=1;
			int now = arr[0];
			for(int q=1; q<r; q++) {
				if(now == arr[q]) {
					// 앞과 뒤가 같다면
					cnt += 1;
				} else { // 앞뒤가 다름
					total = Math.max(total, cnt);
					now = arr[q];
					cnt = 1;
				}
			}
			
			// 마지막은 비교가 안됐을 수 있으므로 마지막 cnt와 비교
			total = Math.max(total, cnt);
			
			if(total < k) {
				return false;
			}

		}

		
		return true;

	}

 

}