package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * num3,4는 N,M 사이즈가 바뀌는데 나처럼 하지 말고 map 기준으로 i,j 냅두고 map_clone의 인덱스를 변경하면
 * N,M을 바꾸지 않아도 됨.
 * map_clone만 [M][N]으로 만들어주면 된다!!!
 * 그리고 출력할 때 i은 map.length까지, j는 map[0].length까지로 설정하면 알아서 출력된다.
 * */
public class Main_BJ_16935_배열돌리기3_박서영 {
	static int N,M,R;
	static int map[][];
	static int map_clone[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		// map 입력받기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++){
			switch(Integer.parseInt(st.nextToken())) {
			case 1:
				num1();
				continue;
			case 2:
				num2();
				continue;
			case 3:
				num3();
				continue;
			case 4:
				num4();
				continue;
			case 5:
				num5();
				continue;
			case 6:
				num6();
				continue;
			}
		}
		
		///////입력 다 받았음

		
		// 답 출력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}

						
	}
	public static void num1() {
		map_clone = new int[N][M];
		
		// 연산
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map_clone[i][j] = map[N-(i+1)][j];
			}
		}			
		map = map_clone;
	}
	
	public static void num2() {
		map_clone = new int[N][M];
		
		// 연산
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map_clone[i][j] = map[i][M-(j+1)];
			}
		}			
		map = map_clone;
	}
	
	public static void num3() {
		change_size();
		map_clone = new int[N][M];
		
		change_size();
		// 연산
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map_clone[j][i] = map[N-(i+1)][j]; // 여기! 난 clone되는거 기준으로 넣었는데 map기준으로 넣으면 N,M 변경 안해줘도 된다.ㅜㅜ
			}
		}		
		
		change_size();
		map = map_clone;
	}
	
	public static void num4() {
		change_size();
		map_clone = new int[N][M];
		change_size();
		// 연산
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map_clone[j][i] = map[i][M-(j+1)];
			}
		}	
		change_size();
		map = map_clone;
	}
	
	public static void num5() {
		map_clone = new int[N][M];
		for(int i = 0; i < N/2; i++)
			for(int j = 0; j < M/2; j++)
				map_clone[i][j+M/2] = map[i][j];
		
		for(int i=0; i < N/2; i++)
			for(int j = M/2; j < M; j++)
				map_clone[i+N/2][j] = map[i][j];
		
		for(int i=N/2; i < N; i++)
			for(int j = 0; j < M/2; j++)
				map_clone[i-N/2][j] = map[i][j];
		
		for(int i=N/2; i < N; i++)
			for(int j = M/2; j < M; j++)
				map_clone[i][j-M/2] = map[i][j];
		
		map = map_clone;
	}
	public static void num6() {
		map_clone = new int[N][M];
		
		for(int i = 0; i < N/2; i++)
			for(int j = 0; j < M/2; j++)
				map_clone[i+N/2][j] = map[i][j];
		
		for(int i=0; i < N/2; i++)
			for(int j = M/2; j < M; j++)
				map_clone[i][j-M/2] = map[i][j];
		
		for(int i=N/2; i < N; i++)
			for(int j = 0; j < M/2; j++)
				map_clone[i][j+M/2] = map[i][j];
		
		for(int i=N/2; i < N; i++)
			for(int j = M/2; j < M; j++)
				map_clone[i-N/2][j] = map[i][j];
		
		map = map_clone;
	}
	
	
	public static void change_size() {
		int tmp = N;
		N = M;
		M = tmp;
	}

}
