package BaekJoon;

import java.util.*;
import java.io.*;

// 필요한 것: 물고기 위치 hashmap(number:seat), map, 상어위치seat
// 0. 상어 위치 (0,0) 저장 - Seat
//  물고기 위치 저장: haspmap, map
// 1. 물고기 움직이기
// 2. 상어 움직이기 - 먹을 물고기가 없으면 끝냄

public class Main_BJ_19236_청소년상어 {
	
	static class Seat{
		int x,y,dir;

		public Seat(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Seat [x=" + x + ", y=" + y + ", dir=" + dir + "]";
		}
	}

	static HashMap<Integer, Seat> fish;
	static Seat shark;
	static int map[][];
	static int dx[] = {0,-1,-1,0,1,1,1,0,-1};
	static int dy[] = {0,0,-1,-1,-1,0,1,1,1};
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[4][4]; // 물고기 번호와 상어 위치(-1)를 저장할 배열
		fish = new HashMap<>(); // 물고기 번호 : 자리+방향
		int startNum = 0;
		
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				if(i == 0 && j == 0) {
					shark = new Seat(i, j, dir);
					startNum = num;
					map[i][j] = 0;
					continue;
				}
				map[i][j] = num;
				fish.put(num, new Seat(i, j, dir));
			}
		}
		Move(startNum, map, fish, shark);
		System.out.println(answer);
	}
	private static void Move(int total, int[][] map, HashMap<Integer, Seat> fish, Seat shark) {
		answer = Math.max(answer, total);
		// 물고기를 움직이기 전 상태를 저장해놓음
		int map_copy[][] = new int[4][4];
		for(int i=0; i<4; i++)
			map_copy[i] = map[i].clone();
		
		
		HashMap<Integer, Seat> fish_copy = (HashMap<Integer, Seat>) fish.clone();
		
		ArrayList<Integer> keySet = new ArrayList<>(fish_copy.keySet());
		Collections.sort(keySet);
		
		for(int key : keySet) {
			Seat fishSeat = fish_copy.get(key);
			int x = fishSeat.x;
			int y = fishSeat.y;
			int dir = fishSeat.dir;
			
			// 1-2. 물고기 이동하자.
			for(int d=dir; d<dir+9; d++) {
				int di = d%9;
				if(di == 0) continue;
				int nx = x + dx[di]; // 이동하려는 칸 x
				int ny = y + dy[di]; // 이동하려는 칸 y
				// 이동하려는 칸에 상어가 없고 공간 경계 안쪽이라면
				if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && !(nx == shark.x && ny == shark.y)) {
					// 이동하려는 칸에 아무것도 없다면 그냥 이동시킨다.
					if(map_copy[nx][ny] == 0) {
						map_copy[nx][ny] = key;
						map_copy[x][y] = 0;
						fish_copy.put(key, new Seat(nx, ny, di));
					} 
					// 이동하려는 칸에 물고기가 있다면 자리를 바꾼다.
					else {
						swipe(key, di, map_copy[nx][ny], map_copy, fish_copy); // 양쪽 자리의 key값(number)을 보냄
					}
					break;
				} else {
					continue;
				}
			}

		}
		
		// 상어의 x,y,dir
		int x = shark.x;
		int y = shark.y;
		int dir = shark.dir;

		while(true) {
			x += dx[dir];
			y += dy[dir];
			
			if(x < 0 || x >= 4 || y < 0 || y >= 4) break;
			if(map_copy[x][y] == 0) continue;
			int fishNum = map_copy[x][y];
			int fishDir = fish_copy.get(fishNum).dir;
			
			// O
			map_copy[x][y] = 0;
			fish_copy.remove(fishNum);
			
			Move(total + fishNum, map_copy, fish_copy, new Seat(x,y,fishDir));				
			
			// 백트래킹으로 되돌리기
			map_copy[x][y] = fishNum;
			fish_copy.put(fishNum, new Seat(x, y, fishDir));

			
		}
		answer = Math.max(answer, total);
	}
	private static void swipe(int key1, int d, int key2, int[][] map_copy, HashMap<Integer, Seat> fish_copy) {
		Seat seat1 = fish_copy.get(key1);
		Seat seat2 = fish_copy.get(key2);
		
		int x1 = seat1.x;
		int y1 = seat1.y;
		int dir1 = d;
		
		int x2 = seat2.x;
		int y2 = seat2.y;
		int dir2 = seat2.dir;
		
		// 바꿀 것: map자리, fish에서의 자리
		map_copy[x1][y1] = key2;
		map_copy[x2][y2] = key1;
		
		fish_copy.put(key1, new Seat(x2, y2, dir1));
		fish_copy.put(key2, new Seat(x1, y1, dir2));
		
	}

}
