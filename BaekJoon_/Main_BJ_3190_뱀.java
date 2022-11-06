package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_3190_뱀 {
	
	static int dx[] = {0,1,0,-1}; // 오른쪽 방향
	static int dy[] = {1,0,-1,0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[N][N]; // 맵에 표시할 것: 뱀의 몸통
		int K = Integer.parseInt(br.readLine());
		Set<Integer> apple = new HashSet<>(); // 사과 위치
		
		StringTokenizer st;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int key = (Integer.parseInt(st.nextToken())-1) * 1000 + (Integer.parseInt(st.nextToken())-1);
			apple.add(key);
		}
		
		int L = Integer.parseInt(br.readLine());
		Map<Integer, String> turn = new HashMap<>(); // 초:방향
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			
			turn.put(num, dir);
		}
		
		/// 입력 끝 ////
		int answer = 0;
		ArrayList<int[]> snake = new ArrayList<>(); // 뱀 몸통 저장
		snake.add(new int[] {0,0});
		map[0][0] = true;
		int dir = 0; // 오른쪽: (dir+1)%4, 왼쪽: (dir+3)%4
		
		while(true) {
			
			answer += 1; // 1초 지남
			// 1. 몸의 길이를 늘려 머리를 다음칸에 위치시킨다.
			int out[] = snake.get(snake.size()-1);
			// 현재 머리 위치
			int x = out[0];
			int y = out[1];
			
			// 다음 머리 위치
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny]) break;
			
			map[nx][ny] = true;
			snake.add(new int[] {nx,ny});
			
			// 2. 이동한 칸에 사과가 있는지 확인한다.
			int key = nx*1000+ny;
			if(!apple.contains(key)) { // 사과가 없는 칸이라면
				// 꼬리가 위치한 칸을 비워준다.
				int outTail[] = snake.get(0);
				// 꼬리가 있는 x,y
				int tx = outTail[0];
				int ty = outTail[1];
				
				map[tx][ty] = false;
				snake.remove(0);
			} else { // 사과가 있는 칸이라면
				apple.remove(key); // 사과 없어짐
			}
			
			// 0. 방향을 바꾸는 구간이라면 방향을 바꾼다.
			if(turn.containsKey(answer)) {
				String d = turn.get(answer);
				if(d.equals("L")) dir = (dir+3)%4;
				else dir = (dir+1)%4;
			}
			
		} // while문 끝
		
		System.out.println(answer);

	}

}
