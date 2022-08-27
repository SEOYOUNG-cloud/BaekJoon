package Study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class sw_헌터 {

	static int N, count; // 맵 길이, 몬스터+의뢰인 수
	static int[] number, order;
	static ArrayList<Seat> monster, monster_order;
	static int hunter_x=0, hunter_y=0;
	static int answer;
	
	static class Seat implements Comparable<Seat>{
		int no, x, y;

		public Seat(int no, int x, int y) {
			super();
			this.no = no;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Seat o) {
			return this.no - o.no;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_헌터.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			monster = new ArrayList<>();
			monster_order= new ArrayList<>();
			answer = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int in = Integer.parseInt(st.nextToken());
					if(in != 0) {
						monster.add(new Seat(in, i, j));
					}
				}
			}
			Collections.sort(monster);
			count = monster.size();
			order = new int[count];
			number = new int[count];
			
			// 입력 끝  //
			for(int i=0; i<count/2; i++)
				order[i] = i-count/2;
			for(int i=count/2; i<count; i++)
				order[i] = (i-count/2+1);
			
			
			
//			System.out.println(Arrays.toString(order));
			perm(0,0);
			sb.append("#").append(tc).append(" ").append(answer).append('\n');
			
		}
		System.out.println(sb.toString());
	}
	private static void perm(int cnt, int flag) {
		if(cnt == count) {
//			System.out.println(Arrays.toString(number));
			Set<Integer> set = new HashSet<>();
			for(int i=0; i<count; i++)
				if(number[i] > 0)
					set.add(number[i]);
				else {
					if(!set.contains(-1 * number[i])) return;
				}
//			System.out.println(Arrays.toString(number));
//			for(Seat s:monster_order)
//				System.out.println(s.no + " " + s.x + " " + s.y);
//			System.out.println();
			
			getDistance(monster_order);
			return;
		}
		for(int i=0; i<count; i++) {
			if((flag & 1<<i) != 0) continue;
			number[cnt] = order[i];
			monster_order.add(monster.get(i));
			
			perm(cnt+1, (flag | 1<<i));
			monster_order.remove(monster_order.size()-1);
		}
	}
	private static void getDistance(ArrayList<Seat> list) {
		int x = hunter_x;
		int y = hunter_y;
		int total = 0;
		
		for(int i=0; i<count; i++) {
			total += Math.abs(x - list.get(i).x) + Math.abs(y - list.get(i).y);
			x = list.get(i).x;
			y = list.get(i).y;
		}
		
		answer = Math.min(answer, total);
		
	}

}
