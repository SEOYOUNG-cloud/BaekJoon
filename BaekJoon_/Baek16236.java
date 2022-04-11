package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BabyShark{
	int x;
	int y;
	
	public BabyShark(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Baek16236 { // 아기 상어
	public static int map[][];
	public static int dist[][]; // 거리 계산할 배열
	public static int count = 0, N;
	public static int dx[] = {0, -1, 0, 1};
	public static int dy[] = {1, 0, -1, 0};
	public static int baby_x, baby_y;
	public static int sharkSize = 2, eatingCount = 0;
	public static int minX, minY, minDist;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
	
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					baby_x = i;
					baby_y = j;
					map[i][j] = 0;
				}
			}
		}
		
		while(true) {
			//계속 초기화
			dist = new int[N][N];
			minX = Integer.MAX_VALUE;
			minY = Integer.MAX_VALUE;
			minDist = Integer.MAX_VALUE;
			
			bfs(baby_x, baby_y);
			
			if(minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) { // 뭐 먹었으면
				eatingCount++;
				map[minX][minY] = 0; // 0으로 초기화
				baby_x = minX;
				baby_y = minY; // 아기상어 위치 바꾸기
				count += dist[minX][minY]; // 거리 움직인만큼 더하기
				
				if(eatingCount == sharkSize) {
					sharkSize++;
					eatingCount = 0;
				}
			} else {break;} // 더이상 갈곳이 없으면 끝내기
		}
		
		System.out.println(count);
		
	}
	
	public static void bfs(int x, int y) {
		Queue<BabyShark> q = new LinkedList<BabyShark>();
		q.add(new BabyShark(x, y));
		
		while(!q.isEmpty()) {
			BabyShark shark = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = shark.x + dx[i];
				int ny = shark.y + dy[i];
				
				// 움직일 수 있으면
				if(isInArea(nx, ny) && isAbleToMove(nx, ny) && dist[nx][ny] == 0) {
					dist[nx][ny] = dist[shark.x][shark.y] + 1; // 이전거리 + 1
					
					if(isEatable(nx, ny)) { // 먹을 수 있으면
						if(minDist > dist[nx][ny]) { // 최소거리가 가려는 거리보다 크면
							minDist = dist[nx][ny]; //바꿈
							minX = nx;
							minY = ny;
						} else if(minDist == dist[nx][ny]) { // 최소거리가 같으면 위쪽, 왼쪽을 찾음
							if(minX == nx) {
								if(minY > ny) { 
									minX = nx;
									minY = ny;
								}
							} else if(minX > nx) {
								minX = nx;
								minY = ny;
							}
						}
						
					}
					q.add(new BabyShark(nx, ny));
				}
			}
		}
		
		
	}
	
	public static boolean isAbleToMove(int x, int y) { // 움직일 수 있는지
		return map[x][y] <= sharkSize; // 자기 몸보다 작으면 움직이기 가능
	}
	public static boolean isEatable(int x, int y) { // 먹을 수 있는지
		return map[x][y] != 0 && map[x][y] < sharkSize;
	}
	public static boolean isInArea(int x, int y) { // 배열에서 벗어나지 않는지
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
