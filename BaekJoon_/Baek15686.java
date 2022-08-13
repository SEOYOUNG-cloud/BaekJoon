package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
}

public class Main_15686_치킨배달_박서영 {
	static int N,M, store,home, answer=Integer.MAX_VALUE;
	static int map[][], chicken[][];
	static int distance_map[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int combination_store[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 도시 크기
		M = Integer.parseInt(st.nextToken()); // 최대 치킨집 개수
		
		map = new int[N][N];
		
		store = 0;
		home = 0;
		ArrayList<int[]> chicken_index = new ArrayList<>();
		ArrayList<int[]> home_index = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) { // 집 개수, 위치 저장
					home += 1;
					home_index.add(new int[] {i,j});
				}
				else if(map[i][j] == 2) { // 치킨집 개수, 위치 저장
					store += 1;
					chicken_index.add(new int[] {i,j});
				}
			}
		}
		chicken = new int[store][home]; // 가로: 치킨집, 세로 : 집
		////입력 끝
		
		for(int c = 0; c < chicken_index.size(); c++) {
			for(int h = 0; h < home_index.size(); h++) {
				distance_map = new int[N][N]; // 초기화
				distance_map[chicken_index.get(c)[0]][chicken_index.get(c)[1]] = -1; // 치킨집에 -1넣음
				distance_map[home_index.get(h)[0]][home_index.get(h)[1]] = 0; // 집은 0 왜냐면 다음칸부터 거리 1이니까
				
				chicken[c][h] = bfs(home_index.get(h)[0], home_index.get(h)[1]); // 가로: 치킨집 인덱스, 세로: 집마다 치킨집까지의 거리
			}
		}
		
		combination_store = new int[M];
		combination(0,0);
		
		System.out.println(answer);

	}
	private static int bfs(int x, int y) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(x,y));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			x = node.getX();
			y = node.getY();
			
			for(int d=0; d<4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(distance_map[nx][ny] == -1) {
					return distance_map[x][y] + 1;
				} else if(distance_map[nx][ny] == 0) {
					distance_map[nx][ny] = distance_map[x][y] + 1;
					queue.add(new Node(nx, ny));
				}

			}
		}
		return 0;
	}
	private static void combination(int cnt, int start) { // 치킨집 2곳 조합하기
		if(cnt == M) {
			calcul(combination_store);	
			return;
		}
		
		for(int i = start; i < store; i++) {
			combination_store[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	private static void calcul(int[] chicken_index_array) {
		int total = 0;
		
		// 집에서 가장 가까운 치킨집 선택!
		for(int i = 0; i < home; i++) {
			int min_dis = Integer.MAX_VALUE;
			for(int j = 0; j < chicken_index_array.length; j++) {
				min_dis = Math.min(min_dis, chicken[chicken_index_array[j]][i]);
			}
			total += min_dis;
		}
		answer = Math.min(answer, total);
	}

}
