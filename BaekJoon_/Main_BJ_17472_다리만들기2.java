package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17472_다리만들기2_박서영 {
	
	static class Node implements Comparable<Node>{
		int a, b, weight;

		public Node(int a, int b, int weight) {
			super();
			this.a = a;
			this.b = b;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [a=" + a + ", b=" + b + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}
	
	static int N, M;
	static int[][] input, map;
	static ArrayList<int[]>[] island;
	static ArrayList<Node> list;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				input[i][j] = Integer.parseInt(st.nextToken());
		}
		
//		for(int i=0; i<N; i++)System.out.println(Arrays.toString(input[i]));
		/// 입력 끝  ///
		
		// 섬 나눠놓을 배열 만들기
		map = new int[N][M];
		int num = 1;
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				if(input[i][j] == 1 && map[i][j] == 0)
					make_island(i,j, num++); // 섬 나눴음
		
//		for(int i=0; i<N; i++)System.out.println(Arrays.toString(map[i]));
		
		// 섬을 넣어 놓을 배열 island
		island = new ArrayList[num];
		for(int i=0; i<num; i++)
			island[i] = new ArrayList<int[]>();
		
		// 각 섬의 x,y값을 섬no에 해당하는 인덱스에 넣기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++)
				if(map[i][j] != 0)
					island[map[i][j]].add(new int[] {i,j});
		}
		
//		for(int i=1; i<num; i++) {
//			for(int j=0; j<island[i].size(); j++)
//				System.out.print(island[i].get(j)[0] + " " + island[i].get(j)[1] + " , ");
//			System.out.println();
//		}
		
		// 섬 정보를 넣어놓을 리스트
		list = new ArrayList<>();
		
		// 각 섬에서 갈 수 있는 섬 확인하기
		for(int i=1; i<num; i++) {
			for(int j=0; j<island[i].size(); j++) {
					for(int d=0; d<4; d++) {
						int x = island[i].get(j)[0];
						int y = island[i].get(j)[1];
						int cnt = 0;
						while(true) {
							x += dx[d];
							y += dy[d];
							// 
							if(x < 0 || x >= N || y < 0 || y >= M) break;
							if(map[x][y] == map[island[i].get(j)[0]][island[i].get(j)[1]]) break;
							if(map[x][y] != 0) {
								if(cnt != 1) {
									list.add(new Node(map[island[i].get(j)[0]][island[i].get(j)[1]], map[x][y], cnt));
								}
								break;
							}
							cnt++;
						}
					}
			}
		}
		Collections.sort(list);
		
		// 크루스칼을 사용하기 위한 union find
		parent = new int[num];
		for(int i=0; i<num; i++)
			parent[i] = i;
		
		int answer = 0;
		int cnt = 0;
		for(Node node : list) {
			if(union(node.a, node.b)) {
				answer += node.weight;
				if(++cnt==num-2) break;
			}
		}
		if(cnt==num-2)
			System.out.println(answer);
		else
			System.out.println(-1);
		
	}
	static int[] parent;
	
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) return false;
		
		if(x<=y) parent[y] = x;
		else parent[x] = y;
		return true;
	}

	private static int find(int x) { // 부모 찾기
		if(parent[x] == x) return x;
		return find(parent[x]);
	}

	// 섬 나누기 BFS
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	
	private static void make_island(int x, int y, int num) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int[] out = queue.poll();
			int i = out[0];
			int j = out[1];
			
			map[i][j] = num;
			
			for(int d=0; d<4; d++) {
				int nx = i + dx[d];
				int ny = j + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 0) continue;
				if(input[nx][ny] == 1)
					queue.add(new int[] {nx, ny});
			}
		}
	}
}
