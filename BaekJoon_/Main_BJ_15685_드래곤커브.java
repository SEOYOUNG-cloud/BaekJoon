package BaekJoon;

import java.util.*;
import java.io.*;

// 오 위 왼 아래 -> 위 왼 아래 오
public class Main_BJ_15685_드래곤커브 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int dx[] = {0,-1,0,1};
		int dy[] = {1,0,-1,0};
		int[][] map = new int[101][101];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); // 시작 방향: 오 위 왼 아래
			int g = Integer.parseInt(st.nextToken()); // 세대
			
			ArrayList<Integer> dir = new ArrayList<>();
			dir.add(d);
			for(int gen=0; gen<g; gen++) {
				for(int i=dir.size()-1; i>=0; i--) {
					int now = dir.get(i);
					dir.add((now+1)%4);
				}
			}
			
			map[x][y] = 1;
			for(int i=0; i<dir.size(); i++) {
				int direction = dir.get(i);
				x += dx[direction];
				y += dy[direction];
				
				if(x < 0 || x >= 101 || y < 0 || y >= 101) continue;
				map[x][y] = 1;
			}
		}
		
		int answer = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				// (99, 99)까지만 봐야지
				if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1 && map[i+1][j+1] == 1)
					answer += 1;
			}
		}
		System.out.println(answer);

	}

}
