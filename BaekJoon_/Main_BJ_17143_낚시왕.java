import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Shark{
		int s,d,z;

		public Shark(int s, int d, int z) {
			super();
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [s=" + s + ", d=" + d + ", z=" + z + "]";
		}
		
	}
	
	static int R, C, M;
	static Shark[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R][C];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			map[r][c] = new Shark(s, d, z);
		}
		
		// 입력 끝 //
		
		///////////////
		int answer = 0;
		// 1. 낚시꾼 움직이기: p=낚시꾼이 있는 열 번호
		for(int p=0; p<C; p++) {
			// 2. 그 열에 있는 상어 잡기
			for(int c=0; c<R; c++) {
				// 그 자리에 상어가 있다면 잡는다.
				if(map[c][p] != null) {
					answer += map[c][p].z;
					map[c][p] = null; // 그 상어 없애기.. 
					break;
				}
			}
			
			// 3. 상어 이동하기 -맵 다 훑으면서 상어 발견하면 옮겨줌
			// 새로운 map 만들어서 거기에 상어 넣어주고.. 마지막에 다시 clone해서 바꿀거임
			Shark[][] clone = new Shark[R][C];
			
			// 상어 이동 
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] == null) continue;
					int x = i;
					int y = j;
					
					
					int dir = map[i][j].d;
					int move;
					if(dir == 1 || dir == 2)
						move = map[i][j].s % (2*(R-1));
					else
						move = map[i][j].s % (2*(C-1));
					int size = map[i][j].z;
					
					for(int round=0; round<move; round++){
						
						
						switch (dir) {
						case 1:
							if(x-1 == 0) {
								x=0;
								dir = 2;
							} else if(x-1 < 0){
								x = 1;
								dir=2;
							}
							else {
								x -= 1;
							}
							break;
						case 2:
							if(x+1 == R-1) {
								x=R-1;
								dir = 1;
							} else if(x+1 > R-1) {
								x=R-2;
								dir=1;
							}
							else {
								x += 1;
							}
							
							break;
						case 3:
							if(y+1 == C-1) {
								y=C-1;
								dir = 4;
							} else if(y+1 > C-1) {
								y=C-2;
								dir=4;
							}
							else {
								y += 1;
							}
							
							break;
						case 4:
							if(y-1 == 0) {
								y=0;
								dir = 3;
							} else if(y-1 < 0) {
								y=1;
								dir=3;
							}
							else {
								y -= 1;
							}
							
							break;

						default:
							break;
						}
						

					} // 한마리 다 움직였음 
					if(clone[x][y] != null) { // 넣으려는데 이미 상어가 있다면 
						if(clone[x][y].z < size) {
							clone[x][y] = new Shark(move, dir, size);
						}
					} else { // 비어있으면 상어 그냥 넣기 
						clone[x][y] = new Shark(move, dir, size);
					}
				}
			}
			
			// 4. 상어 이동이 끝났으므로 clone -> map으로 옮김
			for(int i=0; i<R; i++)
				map[i] = clone[i].clone();
			
		}
		
		System.out.println(answer);
	}

}