package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int x, y, like, empty;

	public int compareTo(Node o) {
		if(this.like != o.like) return o.like - this.like; // 내림차순
		if(this.empty != o.empty) return o.empty - this.empty; // 내림차순
		if(this.x != o.x) return this.x - o.x; // ㅗㅇ름차순
		else
			return this.y - o.y; // 오름차순
	}
}

public class Baek21608 {
	
	
	static int N;
	static int like[][], empty[][], map[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static ArrayList<Node> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		like = new int[N*N][5];
		map = new int[N][N];
		
		for(int i=0; i<N*N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++)
				like[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		// 빈칸 개수 넣어줌
		empty = new int[N][N];
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++) {
				int c = 4;
				if(i == 0) c--;
				if(j == 0) c--;
				if(i == N-1) c--;
				if(j == N-1) c--;
				empty[i][j] = c;
			}
		
//		System.out.println(Arrays.deepToString(empty));
		
		for(int i=0; i<N*N; i++) {
			add(i);
			Collections.sort(list); // 오버라이드 한대로 정렬
			
			Node seat = list.get(0); // 첫번재꺼에 넣어야지
			map[seat.x][seat.y] = like[i][0];
//			System.out.println(seat.x + " " +  seat.y + " " + like[i][0]);
			for(int d=0; d<4; d++) {
				int nx = seat.x + dx[d];
				int ny = seat.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				empty[nx][ny]--;
			}
		}
		
//		System.out.println(Arrays.deepToString(map));

		System.out.println(calcul());

				
	}
	private static void add(int idx) {
		// 자리에 넣어주기 위해.. Node에 행,열,빈곳개수,근처좋아하는애 수 담아서 list에 넣어줌
		list = new ArrayList<>();
//		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int count = 0;
				
				if(map[i][j] != 0) continue;
				Node node = new Node();
				node.x = i;
				node.y = j;
				node.empty = empty[i][j];
				
				for(int d=0; d<4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if(map[nx][ny] == like[idx][1] || map[nx][ny] == like[idx][2] || map[nx][ny] == like[idx][3]
							|| map[nx][ny] == like[idx][4])
						count += 1;
				}
				node.like = count;
				list.add(node);
			}
		}
	}
	private static int calcul() {
		int total=0;
		Arrays.sort(like, Comparator.comparingInt(o1 -> o1[0]));
//		System.out.println(Arrays.deepToString(like));
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int count = 0;
				for(int d=0; d<4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if(map[nx][ny] == like[map[i][j]-1][1] || map[nx][ny] == like[map[i][j]-1][2] || map[nx][ny] == like[map[i][j]-1][3]
							|| map[nx][ny] == like[map[i][j]-1][4])
						count += 1;
				}
				if(count == 1) total += 1;
				else if(count == 2) total += 10;
				else if(count == 3) total += 100;
				else if(count == 4) total += 1000;
			}
		}
		
		return total;
	}

}
