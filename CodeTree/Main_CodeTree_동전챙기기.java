import java.util.*;
import java.io.*;

public class Main_CodeTree_동전챙기기 {

	static int N;
	static char[][] map;
	static Map<Integer, int[]> CoinSeat = new HashMap<>();
	static ArrayList<Integer> coin = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	static int SX, SY, EX, EY;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				char in = line.charAt(j);
				if(in >= '1' && in <= '9') { // 동전이면
					CoinSeat.put(in-'0', new int[] {i,j}); // 동전 숫자를 키로 자리 저장
					coin.add(in-'0'); // 동전만 따로 list에 저장함 (order 구할 때 찾을거)
				} else if(in == 'S') {
					SX = i;
					SY = j;
				} else if(in == 'E') {
					EX = i;
					EY = j;
				}
				
				map[i][j] = in;
			}
		}
		
		// coin list 정렬
		Collections.sort(coin);
		
		// 입력 끝 //
		
		// 2. 3가지 동전 순서를 정할 조합 만들기
		order = new int[3];
		nC3(0, 0);
		
		if(answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);

	}

	static int order[];
	private static void nC3(int cnt, int start) {
		if(cnt == 3) {
			// 3. bfs로 순서대로 갈 수 있는지 확인하기
			int total = 0;
			// 3-1. S->order[0] 확인
			int conf = bfs(SX, SY, CoinSeat.get(order[0])[0], CoinSeat.get(order[0])[1]);
			if(conf > 0) {
				total += conf;
			} else {
				return;
			}
			
			// 3-2. order[0] -> order[1] 확인
			conf = bfs(CoinSeat.get(order[0])[0], CoinSeat.get(order[0])[1], CoinSeat.get(order[1])[0], CoinSeat.get(order[1])[1]);
			if(conf > 0) {
				total += conf;
			} else {
				return;
			}
			
			// 3-3. order[1] -> order[2]
			conf = bfs(CoinSeat.get(order[1])[0], CoinSeat.get(order[1])[1], CoinSeat.get(order[2])[0], CoinSeat.get(order[2])[1]);
			if(conf > 0) {
				total += conf;
			} else {
				return;
			}
			
			// 3-4. order[2] -> E
			conf = bfs(CoinSeat.get(order[2])[0], CoinSeat.get(order[2])[1], EX, EY);
			if(conf > 0) {
				total += conf;
			} else {
				return;
			}
			
			answer = Math.min(answer, total);
			
			return;
		}
		
		for(int i=start; i<coin.size(); i++) {
			order[cnt] = coin.get(i);
			nC3(cnt+1, i+1);
		}
		
	}
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	
	private static int bfs(int startX, int startY, int endX, int endY) {
		boolean visited[][] = new boolean[N][N];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {startX, startY});
		
		int cnt=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			cnt += 1;
			
			while(size --> 0) {
				int out[] = queue.poll();
				int x = out[0];
				int y = out[1];
					
				for(int d=0; d<4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] == '#') continue;
					
					if(nx == endX && ny == endY) {
						return cnt;
					}
					
					visited[nx][ny] = true;
					queue.add(new int[] {nx,ny});
					
				}
			}
		}
		
		return -1;
		
	}

}
