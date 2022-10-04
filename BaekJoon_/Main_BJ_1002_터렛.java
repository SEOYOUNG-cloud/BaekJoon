package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1002_터렛 {

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			/// 입력 끝 ///
			
			// 규현이와 승환이 사이의 거리 제곱
			int dis = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
			//  r1+r2
			int plus = (r1+r2)*(r1+r2);
			// r1-r2
			int minus = (r1-r2)*(r1-r2);
			
			// 1. 무한일 때 - 원이 같음
			if(x1 == x2 && y1 == y2 && r1 == r2) {
				sb.append(-1).append('\n');
			}
			
			// 2. 0개 - ㅇ ㅇ or ◎
			else if(dis > plus || dis < minus) {
				sb.append(0).append('\n');
			}
			
			// 3. 1개
			else if(dis == minus || dis == plus) {
				sb.append(1).append('\n');
			}
			
			// 4. 2개
			else if(dis < plus) {
				sb.append(2).append('\n');
			}
		}
		
		System.out.println(sb.toString());

	}

}
