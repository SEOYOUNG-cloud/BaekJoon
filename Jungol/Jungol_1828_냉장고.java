package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_jungol_1828_냉장고_박서영 {
	
	static class Refri implements Comparable<Refri>{
		int x;
		int y;
		
		public Refri(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Refri o) {
			return this.x != o.x ? this.x-o.x : this.y-o.y; // 시작점을 기준으로 정렬
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		Refri map[] = new Refri[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = new Refri(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		// 정렬
		Arrays.sort(map);
		
		int between_x = map[0].x; // 겹치는 부분 앞자리
		int between_y = map[0].y; // 겹치는 부분 뒷자리
		int answer = 1; // 첫번째꺼 무조건 1개는 필요
		for(int i=1; i<N; i++) {
			if(map[i].x >= between_x && map[i].x <= between_y) { // 앞자리 수가 겹치는 부분 사이에 있다면
				between_x = between_x-map[i].x >= 0 ? between_x : map[i].x;
				between_y = between_y-map[i].y >= 0 ? map[i].y : between_y;
			} else { // 겹치지 못한다면
				between_x = map[i].x;
				between_y = map[i].y;
				answer += 1;
			}
		}
		
		System.out.println(answer);
	}

}
