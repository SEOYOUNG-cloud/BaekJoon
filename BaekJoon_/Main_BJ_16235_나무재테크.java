package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_16235_나무재테크 {
	
	static class Tree{
		int x, y, age;

		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Tree [x=" + x + ", y=" + y + ", age=" + age + "]";
		}
	}
	
	static List<Tree> tree; // 나무가 있는 map
	static int[][] nut; // 양분 map
	static int[][] A; // 겨울마다 늘어나는 양분
	static int[][] dieNut; // 죽은 나무 양분될..
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // NxN
		int M = Integer.parseInt(st.nextToken()); // M개의 줄에 나무 위치
		int K = Integer.parseInt(st.nextToken()); // K년 후
		
		tree = new LinkedList<Tree>();
		
		nut = new int[N+1][N+1];
		// 시작할 때 양분 5로 시작!
		for(int i=0; i<=N; i++)
			Arrays.fill(nut[i], 5);
		
		A = new int[N+1][N+1];
		dieNut = new int[N+1][N+1];
		
		// 겨울마다 늘어날 양분map 입력받음
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 존재하는 나무들 입력받음
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 나무위치 x
			int y = Integer.parseInt(st.nextToken()); // 나무위치 y
			int z = Integer.parseInt(st.nextToken()); // 나이
			
			tree.add(new Tree(x, y, z));
		}
		/* 입력 끝 */
		
//		 어린애부터 양분을 주기 위해 정렬한다.
//		Collections.sort(tree, (o1, o2) -> Integer.compare(o1.age, o2.age));
		
		for(int year=1; year<=K; year++) {
			Collections.sort(tree, (o1, o2) -> Integer.compare(o1.age, o2.age));
			// 봄
			spring();
			// 여름
			summer();
			dieNut = new int[N+1][N+1];
			// 가을
			fall();
			// 겨울
			winter();
		}
		
		int answer = 0;
		answer += tree.size();
		
		System.out.println(answer);
	}
	
	private static void winter() {
		// 4. 땅에 양분 추가
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				nut[i][j] += A[i][j];
			}
		}
		
	}

	private static void fall() {
		// 3. 나이가 5의 배수면 번식함
		int[][] addTree = new int[N+1][N+1]; // 번식된 나무 저장해놓을 배열
		
		// 돌면서 나이가 5의 배수인지 확인
		int[] dx = {1,0,-1,0,1,1,-1,-1};
		int[] dy = {0,1,0,-1,1,-1,1,-1};
		Iterator<Tree> itor = tree.iterator();
		while(itor.hasNext()) {
			Tree tree = itor.next();
			int i = tree.x;
			int j = tree.y;
			int age = tree.age;
			// 나이가 5의 배수이면
			if(age % 5 == 0) {
				// 애기 8방에 뿌림
				for(int d=0; d<8; d++) {
					int ni = i+dx[d];
					int nj = j+dy[d];
					
					if(ni < 1 || ni > N || nj < 1 || nj > N) continue;
					addTree[ni][nj]++;
				}
			}
		}
		
		// 애기 나무배열에 넣음
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(addTree[i][j] == 0) continue;
				for(int t=0; t<addTree[i][j]; t++)
					tree.add(new Tree(i, j, 1));
			}
		}
	}

	private static void summer() {
		// 2. 죽은애가 양분됨
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				nut[i][j] += dieNut[i][j];
			}
		}
	}
	
	private static void spring() {
		// 1. 나무가 자기 나이만큼 양분먹기
		// 어린애부터, 양분이 부족하면 그냥 die
		
		// 돌면서 양분주기 시작!
		Iterator<Tree> itor = tree.iterator();
		while(itor.hasNext()) {
			Tree tree = itor.next();
			int need = tree.age; // 필요한 양분 (=현재나이)
			int i = tree.x;
			int j = tree.y;
			
			int hasNut = nut[i][j]; // 가지고 있는 양분
			// 가진 양분이 필요한 양분보다 적으면
			if(hasNut < need) {
				// 양분 저장해놓기
				dieNut[i][j] += need/2;
				// 나무 죽음
				itor.remove();
			} else {
				// 있으면 양분삭제하기
				nut[i][j] = hasNut - need;
				// 나이 한살 먹음
				tree.age ++;
			}
		}
	}
}
