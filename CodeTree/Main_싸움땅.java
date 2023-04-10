import java.util.*;
import java.io.*;

public class Main_싸움땅 {
	
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	
	static class HaveGunDir{
		int x, y, gun, dir; // 현재방향x,y, 가진 총, 현재 방향

		public HaveGunDir(int x, int y, int gun, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.gun = gun;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "HaveGunDir [x=" + x + ", y=" + y + ", gun=" + gun + ", dir=" + dir + "]";
		}
	}
	static Map<Integer, HaveGunDir> player; // PID, (x, y, 가진총, 현재방향)
	static int[][] map; // 플레이어 위치 저장할 맵
	static Map<Integer, ArrayList<Integer>> gunList; // 총위 위치, 총 리스트
	
	static int n; // 격자크기
	static int m; // 인간 수
	static int k; // 라운드 수
	static int initPower[]; // 인간 당 초기 능력치
	static int answer[]; // 획득점수(출력해야할 답)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 격자크기
		m = Integer.parseInt(st.nextToken()); // 인간 수
		k = Integer.parseInt(st.nextToken()); // 라운드 수
		
		initPower = new int[m+1]; // 인간 당 초기 능력치, 인간pid는 1부터 시작
		answer = new int[m+1];
		player = new HashMap<>();
		map = new int[n+1][n+1]; // 플레이어 위치 저장할 맵, 1부터 시작함
		gunList = new HashMap<>(); // 총 리스트
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				int in = Integer.parseInt(st.nextToken());
				//총의 정보 입력받음. 0:빈칸, 1:총의 공격력
				int key = i * 100 + j;
				ArrayList<Integer> value = new ArrayList<>();
				if(in == 0) {
					gunList.put(key, value);
				} else {
					value.add(in);
					gunList.put(key, value);
				}
			}
		}
		
		for(int i=0, playerIdx = 1; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			// 플레이어 정보 입력받음. x,y,d,s
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			player.put(playerIdx, new HaveGunDir(x, y, 0, d));
			map[x][y] = playerIdx;
			initPower[playerIdx++] = s;
		}
		
		/* 입력 끝  */
		for(int round=1; round<=k; round++) {
			// 1. 순차적으로 방향대로 움직인다.
			for(int p=1; p<=m; p++) {
				HaveGunDir out = player.get(p);
				int nowX = out.x;
				int nowY = out.y;
				int nowGun = out.gun;
				int nowDir = out.dir;
				
				// 맵에서 먼저 지운다.
				map[nowX][nowY] = 0;
				
				// 만약 다음에 움직이려고 했는데 격자를 벗어나면
				if((nowX + dx[nowDir]) < 1 || (nowX + dx[nowDir]) > n || (nowY + dy[nowDir]) < 1 || (nowY + dy[nowDir]) > n) {
					// 반대방향으로 바꾼다.
					if(nowDir < 2) nowDir += 2;
					else nowDir -= 2;
				}
				
				// 다음 좌표
				int nx = nowX + dx[nowDir];
				int ny = nowY + dy[nowDir];
				int location = nx * 100 + ny;
				player.put(p, new HaveGunDir(nx, ny, nowGun, nowDir));
				
				// 1-1) 다음 좌표에 플레이어가 없다면
				if(map[nx][ny] == 0) {
					// 좌표에 있는 총을 획득한다. (있다면)
					// 다음에 인간이 들 총 구한다. 좌표에 있는 총들과 내가 가진 총들을 비교한다.
					int nextGun = StrongGun(nowGun, location);
					
					// 변경할 사항: 플레이어 위치(map), player정보(위치, 가진 총, 방향)
					map[nx][ny] = p;
					
					player.put(p, new HaveGunDir(nx, ny, nextGun, nowDir));
				}
				// 1-2) 다음 좌표에 플레이어가 있다면!!!!!!!
				else {
					// 싸운다!
					// 원래 있던애가 몇번인지 확인
					int otherPID = map[nx][ny];
					map[nx][ny] = 0;
					
					// 움직이려던 애의 초기 능력치 + 갖고 있는 총의 공격력 합
					int myTotal = initPower[p] + nowGun;
					// 상대의 초기 능력치 + 갖고 있는 총의 공격력 합
					int otherTotal = initPower[otherPID] + player.get(otherPID).gun;
					
					int addScore = Math.abs(myTotal - otherTotal);
					// 만약 비겼다면
					if(myTotal == otherTotal) {
						if(initPower[p] > initPower[otherPID]) {
							// my가 이김
							loserResult(otherPID, location);
							
							winnerResult(p, addScore, location);
							map[nx][ny] = p;
							
						} else {
							// other가 이김
							loserResult(p, location);
							
							winnerResult(otherPID, addScore, location);
							map[nx][ny] = otherPID;
							
						}
					} else if(myTotal > otherTotal) { // my가 이겼다면
						loserResult(otherPID, location);
						
						map[nx][ny] = p;
						winnerResult(p, addScore, location);
						
					} else { // other가 이겼다면
						loserResult(p, location);
						
						map[nx][ny] = otherPID;
						winnerResult(otherPID, addScore, location);
					}
				}
			}
		}
		for(int i=1; i<=m; i++)
			System.out.print(answer[i] + " ");
	}
	private static int StrongGun(int have, int nowLocation) {
		// 해당 자리에 놓인 총 리스트 가져오기
		ArrayList<Integer> putList = gunList.get(nowLocation);
		// 해당 자리에 총이 없으면 그냥 리턴함
		if(putList.size() == 0) return have;
		
		// 새로운 리스트 만듦
		ArrayList<Integer> list = new ArrayList<>();
		
		// have = 0이면 총을 가지고 있지 않았다는 뜻임
		if(have != 0) list.add(have);
		
		for(int i=0; i<putList.size(); i++) {
			list.add(putList.get(i));
		}
		
		// 오름차순 정렬
		Collections.sort(list);
		
		// 제일 큰거 저장해놓음 (내가 가질거)
		int max = list.get(list.size()-1);
		
		// 내가 가질거 삭제
		list.remove(list.size()-1);
		
		// 다시 내려놓는다.
		gunList.put(nowLocation, list);
		
		return max;
	}
	
	private static void winnerResult(int pid, int addScore, int location) {
		// 이겼다면 addScore만큼 점수를 획득한다.
		answer[pid] += addScore;
		
		// 총 쏀거 가진다.
		HaveGunDir info = player.get(pid);
		int strongGun = StrongGun(info.gun, location);
		
		player.put(pid, new HaveGunDir(info.x, info.y, strongGun, info.dir));
	}
	private static void loserResult(int pid, int nowLocation) {
		// 변경할 사항: 플레이어 위치(map), player정보(위치, 가진 총, 방향)
		// 졌다면
		// 1. 총을 내려놓는다.
		HaveGunDir info = player.get(pid);
		int x = info.x;
		int y = info.y;
		int gun = info.gun;
		int dir = info.dir;
		
		// 총 내려놓기
		ArrayList<Integer> nowGunList = gunList.get(nowLocation);
		nowGunList.add(gun);
		gunList.put(nowLocation, nowGunList);
		
		gun = 0; // 내가 가진 총 없애기
		
		// 2. 원래 방향으로 한 칸 움직일 수 있는지 확인하기
		int c=4;
		while(c --> 0) {
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			
			// 갈 수 없는 방향이라면
			if(nx < 1 || nx > n || ny < 1 || ny > n || map[nx][ny] != 0) {
				dir = (dir+1) % 4;
				continue;
			}
			// 갈 수 있는 방향이라면
			// 3. 총이 있으면 쎈거 가지기
			int nextLocation = nx * 100 + ny;
			int strongGun = StrongGun(0, nextLocation);
			map[nx][ny] = pid;
			player.put(pid, new HaveGunDir(nx, ny, strongGun, dir));
			break;
		}
	}
}
