package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1931 {

	static class Room implements Comparable<Room>{
		int x;
		int y;
		
		Room(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Room o) { // 오름차순 정렬
			if(this.y != o.y) return this.y - o.y;
			return this.x - o.x;
		}
	}
	
	static int answer=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		Room map[] = new Room[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = new Room(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		// 입력 끝
		
		Arrays.sort(map);

		int x = map[0].x;
		int y = map[0].y;
		int cnt = 1;
		
		for(int i=1; i<N; i++) {
			if(map[i].x >= y) {
				cnt+=1;
				x = map[i].x;
				y = map[i].y;
			}
		}
		System.out.println(cnt);

	}
}
