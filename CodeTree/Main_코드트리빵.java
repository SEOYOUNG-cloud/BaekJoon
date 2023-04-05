package SWEA;
import java.util.*;
import java.io.*;

public class Main_코드트리빵 {
	
	static class XY implements Comparable<XY>{
		int x, y;

		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(XY o) {
			if(this.x == o.x) return Integer.compare(this.y, o.y);
			return Integer.compare(this.x, o.x);
		}
	}
	
	static int n; // 격자 크기 n 
	static int m; // 사람 수 m
	static int map[][]; // input map
	static int subway[][]; // 각 사람들이 가고자 하는 편의점 위치 
	
	static Set<Integer> basecampList; // 베이스캠프 좌표 리스트 
	static boolean[][] checkMap; // 못갈 곳 체크하는 맵
	static boolean[][][] subwayPeople;
	static Set<Integer> people; // 인간 좌표 
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());// 격자크기 
		m = Integer.parseInt(st.nextToken()); // 사람 수 
		
		map = new int[n+1][n+1]; // input map
		checkMap = new boolean[n+1][n+1];
		subwayPeople = new boolean[m+1][n+1][n+1];
		basecampList = new HashSet<>();
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				int in = Integer.parseInt(st.nextToken());
				if(in == 1) { // 베이스 캠프이면 
					int key = i*100 + j;
					basecampList.add(key);
				}
				map[i][j] = in;
			}
		}
		
		subway = new int[m+1][2]; // 각 사람이 가고싶은 편의점 위치 
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			subway[i][0] = Integer.parseInt(st.nextToken());
			subway[i][1] = Integer.parseInt(st.nextToken());
		}
		
		people = new HashSet<>();
		/* 입력 끝 */
		
		//1.격자에 있는 사람이 편의점 방향으로 움직인다.
		// 1-1. 맨 처음 사람은 basecamp에 미리 넣어놓는다. 그러고 사람(Set)이 다 없어질 때까지 돌릴거임 
		// 갈 basecamp를 찾기 위해 bfs 돌린다.
		int key = bfs(subway[1][0], subway[1][1]);
		int basecampX = key / 100;
		int basecampY = key % 100;
		
		// 점유한다.
		checkMap[basecampX][basecampY] = true; // 이제 못지나감 
		people.add(1); // 사람 추가한다. 
		basecampList.remove(key); // 이제 이 베이스캠프는 못감 
		
		queueList = new ArrayDeque[m+1]; // 편의점 갈 길을 찾을 queueList
		for(int i=1; i<=m; i++)
			queueList[i] = new ArrayDeque<>();
		
		queueList[1].offer(new XY(basecampX, basecampY));
		subwayPeople[1][basecampX][basecampY] = true;
		
		int time = 2;
		while(people.size() != 0) {
			// 1. 격자에 있는 사람이 편의점 방향으로 움직인다. 
			// people map에 있는 사람들이 이동할 방향으로 이동시켜 놓는다. (편의점인지는 체크 X)
			for(int p=1; p<=m; p++) {
				if(!people.contains(p)) continue;
				int sx = subway[p][0]; // 해당 사람이 가고싶은 편의점 좌표 
				int sy = subway[p][1];
				
				// 1-1. 가고싶은 편의점 최단거리를 구한다.
				BFS_subway(sx, sy, p);
			}
			
			// 2. 인간들이 간 자리들중에 편의점이 있었다면 queue가 비어있으므로 true처리한다.
			for(int p=1; p<=m; p++) {
				if(people.contains(p) && queueList[p].size() == 0) {
					// people 삭제
					people.remove(p);
					// 해당 편의점 true처리 
					int x = subway[p][0];
					int y = subway[p][1];
					checkMap[x][y] = true;
				}
				
			}
			
			// 3. 현재 시간이 m보다 작으면 t번째 사람이 편의점과 가까운 베이스캠프로 움직인다.
			if(time <= m) {
				int findBaseCamp = bfs(subway[time][0], subway[time][1]);
				int goBasecampX = findBaseCamp / 100;
				int goBasecampY = findBaseCamp % 100;
				
				// 베이스캠프로 갔으면 이제 그 길 못다님
				checkMap[goBasecampX][goBasecampY] = true;
				
				// 베이스캠프도 지운다.
				int makeKey = goBasecampX * 100 + goBasecampY;
				basecampList.remove(makeKey);
				
				// 사람 추가한다.
				people.add(time);
				
				// queue에도 추가한다.
				queueList[time].offer(new XY(goBasecampX, goBasecampY));
				
				// 체크도함
				subwayPeople[time][goBasecampX][goBasecampY] = true;
			}
			
			time++;
		}
		System.out.println(time-1);
	}
	
	// 최단거리를 구하면서 갈 곳을 구할 BFS
	// 0: 위, 1: 왼, 2: 오, 3: 아래 
	static int dx[] = {-1,0,0,1};
	static int dy[] = {0,-1,1,0};
	static ArrayDeque<XY>[] queueList;
	private static void BFS_subway(int x, int y, int pid) { // 가고싶은 편의점, 해당 인간 번호 
		ArrayDeque<XY> queue = new ArrayDeque<>();
		int qsize = queueList[pid].size();
		for(int i=0; i<qsize; i++) {
			queue.add(queueList[pid].poll());
		}
		
		int size = queue.size();
		while(size --> 0) {
			XY out = queue.poll();
			int outX = out.x;
			int outY = out.y;
			
			
			for(int d=0; d<4; d++) {
				int nx = outX + dx[d];
				int ny = outY + dy[d];
				
				
				if(nx < 1 || nx > n || ny < 1 || ny > n || checkMap[nx][ny] || subwayPeople[pid][nx][ny]) continue;
				if(nx == x && ny == y) {
					queueList[pid].clear();
					return;
				}
				subwayPeople[pid][nx][ny] = true;
				queue.add(new XY(nx, ny));
			}
		}
		queueList[pid] = queue;
		
	}
	
	// 편의점과 가장 가까운 베이스캠프를 찾을 BFS (3번)
	private static int bfs(int x, int y) { // 편의점 x,y 
		Queue<XY> queue = new ArrayDeque<>();
		PriorityQueue<XY> pq = new PriorityQueue<>();
		queue.offer(new XY(x, y));
		boolean[][] check = new boolean[n+1][n+1];
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size --> 0) { // depth만큼 돈다.
				XY out = queue.poll();
				int i = out.x;
				int j = out.y;
				
				check[i][j] = true;
				int key = i*100 + j;
				if(basecampList.contains(key)) {
					// 베이스캠프 찾음
					// 정차한다.!
					pq.offer(new XY(i, j));
				}
				
				for(int d=0; d<4; d++) {
					int ni = i+dx[d];
					int nj = j+dy[d];
					
					if(ni < 1 || ni > n || nj < 1 || nj > n || check[ni][nj] || checkMap[ni][nj]) continue;
					queue.add(new XY(ni, nj));
				}
			}
			if(!pq.isEmpty()) {
				XY out = pq.poll();
				int outX = out.x;
				int outY = out.y;
				
				int outKey = outX * 100 + outY;
				return outKey;
			}
		}
		return -1; // 정차할 수 있는곳이 없음 (존재하지 않음)
	}
	
}
