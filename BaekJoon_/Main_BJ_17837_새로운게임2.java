package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_17837_새로운게임2 {
	
	static class Info{
		int x, y, dir;
		
		public Info(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Info [x=" + x + ", y=" + y + ", dir=" + dir + "]";
		}
	}
	
	static int N, K; //체크판 크기, 말 개수 
	static int[][] map;
	static Map<Integer, Info> horse;
	static ArrayList<Integer>[][] list;
	static int dx[] = {0, 0,0,-1,1};
	static int dy[] = {0, 1,-1,0,0};
	
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 체크판 크기 
		K = Integer.parseInt(st.nextToken()); // 말 개수 
		
		map = new int[N+1][N+1]; // 0: white, 1: red, 2: blue
		list = new ArrayList[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				list[i][j] = new ArrayList<>();
			}
		}
		
		horse = new HashMap<>();
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			horse.put(i, new Info(x, y, d));
			list[x][y].add(i);
		}
		
		/* 입력 끝 */
		
		int turn = 0;
		A: while(turn < 1000) {
			turn += 1;
			
			// 1. 순서대로 이동한다. 
			for(int h=0; h<K; h++) {
				// 1-1. 이동하려는 말의 정보 확인 
				Info info = horse.get(h);
				int x = info.x;
				int y = info.y;
				int dir = info.dir;

				// 해당 위치에 있는 말이 몇 번째에 있는지 확인 
				int startPoint = -1;
				for(int p=0; p<list[x][y].size(); p++) {
					if(list[x][y].get(p) == h) {
						startPoint = p;
						break;
					}
				}
				
				// 해당 말 위에 같이 움직일 말 리스트 
				ArrayList<Integer> moveHorseList = new ArrayList<>();
				for(int i=startPoint; i<list[x][y].size(); i++) {
					moveHorseList.add(list[x][y].get(i));
				}
				
				
				// 1-2. 다음 이동 방향 칸 색 확인 
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				
				// 다음 이동 방향이 칸을 벗어났을 경우 파란색과 같은 경우로 간주한다. 
				if(nx <= 0 || nx >= N+1 || ny <= 0 || ny >= N+1 || map[nx][ny] == 2) {
					int nextDir = info.dir;
					// 방향 바꾸기 
					switch (nextDir) {
					case 1:
						nextDir = 2;
						break;
					case 2:
						nextDir = 1;
						break;
					case 3:
						nextDir = 4;
						break;
					case 4:
						nextDir = 3;
						break;
					default:
						break;
					}
					
					info.dir = nextDir;
					nx = x + dx[nextDir];
					ny = y + dy[nextDir];
					
					if(nx <= 0 || nx >= N+1 || ny <= 0 || ny >= N+1 || map[nx][ny] == 2) continue;
					else if(map[nx][ny] == 0) {
						for(int i=0; i<moveHorseList.size(); i++) {
							int moveHorse = moveHorseList.get(i);
							
							list[nx][ny].add(moveHorse);
							Info moveHorseInfo = horse.get(moveHorse);
							horse.put(moveHorse, new Info(nx, ny, moveHorseInfo.dir));
						}
					} 
					
					else if(map[nx][ny] == 1) {
						for(int i=moveHorseList.size()-1; i>=0; i--) {
							int moveHorse = moveHorseList.get(i);
							list[nx][ny].add(moveHorse);
							Info moveHorseInfo = horse.get(moveHorse);
							horse.put(moveHorse, new Info(nx, ny, moveHorseInfo.dir));
						}
					}
				}
				
				// 다음 이동 방향이 흰색이면 위에 있는 애들이랑 같이 이동한다. 
				else if(map[nx][ny] == 0) {
					for(int i=0; i<moveHorseList.size(); i++) {
						int moveHorse = moveHorseList.get(i);
						
						list[nx][ny].add(moveHorse);
						Info moveHorseInfo = horse.get(moveHorse);
						horse.put(moveHorse, new Info(nx, ny, moveHorseInfo.dir));
					}
				} 
				
				else if(map[nx][ny] == 1) {
					for(int i=moveHorseList.size()-1; i>=0; i--) {
						int moveHorse = moveHorseList.get(i);
						list[nx][ny].add(moveHorse);
						Info moveHorseInfo = horse.get(moveHorse);
						horse.put(moveHorse, new Info(nx, ny, moveHorseInfo.dir));
					}
				}
				
				// 1-3. 기존에 있던애들 없애기
				for(int i=list[x][y].size()-1; i>=startPoint; i--)
					list[x][y].remove(i);
				
				// 게임이 끝나는지 확인 
				if(list[nx][ny].size() >= 4) break A;
				
			} // 이동 끝 
			
		}
		
		if(turn == 1000) System.out.println("-1");
		else System.out.println(turn);
		
		

	}
}
