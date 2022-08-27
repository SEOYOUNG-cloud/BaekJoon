package Study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_낚시터자리잡기 {
	
	static int N;
	static int map[], order[];
	static int entrance[], Fisher[]; // 문 위치배열, 문 위치당 낚시꾼 수 배열
	static int answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_낚시터.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine()); // 낚시터 개수(5~60)
			map = new int[N+1]; // 낚시터
			order = new int[4]; // 문 순서배열
			entrance = new int[3];
			Fisher = new int[3];
			answer=Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			entrance[0] = Integer.parseInt(st.nextToken()); // 입구 위치
			Fisher[0] = Integer.parseInt(st.nextToken()); // 낚시꾼 수(1~20)
			st = new StringTokenizer(br.readLine());
			entrance[1] = Integer.parseInt(st.nextToken());
			Fisher[1] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			entrance[2] = Integer.parseInt(st.nextToken());
			Fisher[2] = Integer.parseInt(st.nextToken());
			
			
			// 입력 끝 // 
			perm(0,0);
			sb.append("#").append(tc).append(" ").append(answer).append('\n');
		}
		System.out.println(sb.toString());
		

	}
	private static void perm(int cnt, int flag) { // 문에 들어갈 순서 순열
		if(cnt == 3) {
			
			// 순서배열 : order[3]
			// 순서를 정했으니 낚시꾼을 넣어주자
			enter(map, entrance[order[0]], Fisher[order[0]], 0, 0);
			Arrays.fill(map, 0);
			return;
		}
		for(int i=0; i<3; i++) {
			if((flag & 1<<i) != 0) continue;
			order[cnt] = i;
			perm(cnt+1, (flag | 1<<i));
		}
	}
	
	private static void enter(int[] map, int door, int fisher, int cnt, int total) {	
		if(cnt == 3) {
			// 여기서 계산

			answer = Math.min(answer, total);
			return;
		}

		while(fisher--> 1) {
			int min_idx = -1;
			int min = Integer.MAX_VALUE;
			
			for(int i=1; i<=N; i++) {
				int dis = distance(door, i);
				if(dis < min && map[i] == 0) {
					min_idx = i;
					min = dis;
				}
			}
			total += distance(door, min_idx);
			map[min_idx] = door;
		}

		// 마지막 낚시꾼은 선택지가 두가지일 수 있음
		ArrayList<Integer> list = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		
		for(int i=1; i<=N; i++) {
			int dis = distance(door, i);
			if(dis < min && map[i] == 0) {
				list.clear();
				list.add(i);
				min = dis;
			} else if(dis == min && map[i] == 0) {
				list.add(i);
			}
		}
		
		if(list.size() == 1) {
			map[list.get(0)] = door;
			total += distance(door, list.get(0));
			enter(map, entrance[order[cnt+1]], Fisher[order[cnt+1]], cnt+1, total);
		}
		else {
			int copy[] = map.clone();
			copy[list.get(0)] = door;
			
			
			total += distance(door, list.get(0));
			enter(copy, entrance[order[cnt+1]], Fisher[order[cnt+1]], cnt+1, total);
			total -= distance(door, list.get(0));

			
			int copy2[] = map.clone();
			copy2[list.get(1)] = door;

			
			total += distance(door, list.get(1));
			enter(copy2, entrance[order[cnt+1]], Fisher[order[cnt+1]], cnt+1, total);
		}

	}

	private static int distance(int a, int b) {
		return Math.abs(a-b)+1;
	}

}
