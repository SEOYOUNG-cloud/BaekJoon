package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_활주로건설 {
	
	static int N, X, total;
	static int[][] map;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_활주로건설.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			total = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 입력 끝 //
			
			
			for(int i=0; i<N; i++) {
				int[] send = new int[N];
				for(int j=0; j<N; j++) {
					send[j] = map[j][i]; // 확인할 배열
				}
				// 확인할 함수로 보내기
				conf(send);
				conf(map[i]);
			}
			
			sb.append("#").append(tc).append(" ").append(total).append('\n');
		}
		System.out.println(sb.toString());
		

	}

	private static void conf(int[] array) {
		boolean visited[] = new boolean[N]; // 다리가 놓아졌으면 true
		int now = array[0];
		
		for(int i=1; i<N; i++) {
			if(now == array[i]) continue;
			else if(now + 1 == array[i]) { // 다음꺼가 한칸 높음 앞에 다리 놓음
				for(int c=i-1; c>=i-X; c--) { // 앞칸이 0보다 크거나 같고 visited = false가 아닌지 확인
					if(c < 0 || visited[c]) return; // 이러면 걍 리턴
					visited[c] = true; // 다리 놓을거니까
				}
				
			} else if(now -1 == array[i]) { // 전꺼(now)가 더 작으면 한칸 낮다는 뜻이므로 뒤에 다리 놓음
				for(int c=i; c<=i+X-1; c++) { // i번째가 작아진 부분이라서 i부터 X만큼 놓음
					if(c >= N || visited[c]) return; // 이러면 걍 리턴
					visited[c] = true; // 다리 놓을거니까
					
				}
			}
			else return; // 같거나 한칸 높거나 낮지 않으면 다리도 못놔
			
			now = array[i];
		}
		total += 1;
		
		
	}

}
