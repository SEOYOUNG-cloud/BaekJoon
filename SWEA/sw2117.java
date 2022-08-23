package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class sw2117 {
	static class House{
		int x;
		int y;
		
		House(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M;
	static int map[][];
	static ArrayList<House> home;
	static int home_cnt, answer;
	static House Selected[];
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_sw2117.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			home = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					map[i][j] = tmp;
					if(tmp == 1) {
						home.add(new House(i,j));
					}
				}
			} // 입력 끝

			int answer=0;
			
			// 최악일 때 20 * 20 * 40 * 20 = 3200정도
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					 // 1~2(n-1) 까지고 K = distance + 1
					for(int distance =0; distance <= 2*(N-1); distance++) { // 거리 안에 있으면 +1하려구
						int cnt=0;
						for(int h = 0; h < home.size(); h++) { // 집마다 훑으면서 거리안에 있는지 확인!
							int d = Math.abs(i - home.get(h).x) + Math.abs(j - home.get(h).y);
							if(d <= distance) cnt+=1;
						}
						int K = distance+1;
						if((K*K + (K-1) * (K-1) <= cnt * M) && cnt > answer) {
							answer = cnt;
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
			
		}
	}
}
