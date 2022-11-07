package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_12100_2048Easy {

	static int N;
	static int[][] map;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//입력 끝 //
		// -최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값
		// 1. 중복순열로 상하좌우 중 5개 고른다.
		// 1-1. 상 하 좌 우 순서 (0,1,2,3)
		// 2. 그 순서대로 움직이면서 움직이는것마다 한줄씩 땡겨서 합침
		// 3. 땡겨서 합친 후 움직인 모양쪽으로 붙임
		
		permutation(0);
		System.out.println(answer);

	}
	static int order[] = new int[5];
	private static void permutation(int cnt) {
		if(cnt == 5) {
			combine(order);
			return;
		}
		
		for(int i=0; i<4; i++) {
			order[cnt] = i;
			permutation(cnt+1);
		}
	}
	private static void combine(int[] order) {
		int newMap[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			newMap[i] = map[i].clone();
		}
		
		for(int o=0; o<5; o++) {
			int dir = order[o]; // 방향 -0: 상, 1: 하, 2: 좌, 3: 우
			
			switch (dir) {
			case 0:
				up(newMap);
				break;
			case 1:
				down(newMap);
				break;
			case 2:
				left(newMap);
				break;
			case 3:
				right(newMap);
				break;

			default:
				break;
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				if(max < newMap[i][j])
					max = newMap[i][j];
		
		answer = Math.max(max, answer);
		
	}
	private static void up(int[][] map) {
		
		// 계산하는 맵
		int nmap[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			nmap[i] = map[i].clone();
		}
		
		// 위로 다 올린다다다다...
		for(int i=0; i<N; i++) {
			Queue<Integer> list = new ArrayDeque<>();
			for(int j=0; j<N; j++) {
				if(nmap[j][i] != 0) {
					list.add(nmap[j][i]);
					nmap[j][i] = 0;
				}
			}
			
			for(int j=0; j<N; j++) {
				if(list.size() == 0) break;
				nmap[j][i] = list.poll();
			}
		}
		
		// 위에서 땡겨야함
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				if(nmap[j][i] == nmap[j+1][i] && nmap[j][i] != 0) {
					nmap[j][i] *= 2;
					nmap[j+1][i] = 0;
				}
			}
		}
		
		// 위로 다 올린다다다다...
		for(int i=0; i<N; i++) {
			Queue<Integer> list = new ArrayDeque<>();
			for(int j=0; j<N; j++) {
				if(nmap[j][i] != 0) {
					list.add(nmap[j][i]);
					nmap[j][i] = 0;
				}
			}
			
			for(int j=0; j<N; j++) {
				if(list.size() == 0) break;
				nmap[j][i] = list.poll();
			}
		}
		
		for(int i=0; i<N; i++)
			map[i] = nmap[i].clone();
		
	}
	
	private static void down(int[][] map) {
		// 계산하는 맵
		int nmap[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			nmap[i] = map[i].clone();
		}
		
		// 아래로 내림
		for(int i=0; i<N; i++) {
			Queue<Integer> list = new ArrayDeque<>();
			for(int j=N-1; j>=0; j--) {
				if(nmap[j][i] != 0) {
					list.add(nmap[j][i]);
					nmap[j][i] = 0;
				}
			}
			
			for(int j=N-1; j>=0; j--) {
				if(list.size() == 0) break;
				nmap[j][i] = list.poll();
			}
		}
		
		// 아래에서 위로가면서 땡겨야함
		for(int i=0; i<N; i++) {
			for(int j=N-1; j>=1; j--) {
				if(nmap[j][i] == nmap[j-1][i] && nmap[j][i] != 0) {
					nmap[j][i] *= 2;
					nmap[j-1][i] = 0;
				}
			}
		}
		
		// 아래로 내림
		for(int i=0; i<N; i++) {
			Queue<Integer> list = new ArrayDeque<>();
			for(int j=N-1; j>=0; j--) {
				if(nmap[j][i] != 0) {
					list.add(nmap[j][i]);
					nmap[j][i] = 0;
				}
			}
			
			for(int j=N-1; j>=0; j--) {
				if(list.size() == 0) break;
				nmap[j][i] = list.poll();
			}
		}
		
		for(int i=0; i<N; i++)
			map[i] = nmap[i].clone();
	}
	
	private static void right(int[][] map) {
		// 계산하는 맵
		int nmap[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			nmap[i] = map[i].clone();
		}
		
		// 오른쪽으로 붙여
		for(int i=0; i<N; i++) {
			Queue<Integer> list = new ArrayDeque<>();
			for(int j=N-1; j>=0; j--) {
				if(nmap[i][j] != 0) {
					list.add(nmap[i][j]);
					nmap[i][j] = 0;
				}
			}
			
			for(int j=N-1; j>=0; j--) {
				if(list.size() == 0) break;
				nmap[i][j] = list.poll();
			}
		}
		
		// 오른쪽에서 땡기기
		for(int i=0; i<N; i++) {
			for(int j=N-1; j>=1; j--) {
				if(nmap[i][j] == nmap[i][j-1] && nmap[i][j] != 0) {
					nmap[i][j] *= 2;
					nmap[i][j-1] = 0;
				}
			}
		}
		
		// 오른쪽으로 붙여
		for(int i=0; i<N; i++) {
			Queue<Integer> list = new ArrayDeque<>();
			for(int j=N-1; j>=0; j--) {
				if(nmap[i][j] != 0) {
					list.add(nmap[i][j]);
					nmap[i][j] = 0;
				}
			}
			
			for(int j=N-1; j>=0; j--) {
				if(list.size() == 0) break;
				nmap[i][j] = list.poll();
			}
		}
		
		for(int i=0; i<N; i++)
			map[i] = nmap[i].clone();
		
	}
	
	private static void left(int[][] map) {
		// 계산하는 맵
		int nmap[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			nmap[i] = map[i].clone();
		}
		
		// 왼쪽으로 붙여
		for(int i=0; i<N; i++) {
			Queue<Integer> list = new ArrayDeque<>();
			for(int j=0; j<N; j++) {
				if(nmap[i][j] != 0) {
					list.add(nmap[i][j]);
					nmap[i][j] = 0;
				}
			}
			
			for(int j=0; j<N; j++) {
				if(list.size() == 0) break;
				nmap[i][j] = list.poll();
			}
		}
		
		// 왼쪽에서 땡기기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				if(nmap[i][j] == nmap[i][j+1] && nmap[i][j] != 0) {
					nmap[i][j] *= 2;
					nmap[i][j+1] = 0;
				}
			}
		}
		
		// 왼쪽으로 붙여
		for(int i=0; i<N; i++) {
			Queue<Integer> list = new ArrayDeque<>();
			for(int j=0; j<N; j++) {
				if(nmap[i][j] != 0) {
					list.add(nmap[i][j]);
					nmap[i][j] = 0;
				}
			}
			
			for(int j=0; j<N; j++) {
				if(list.size() == 0) break;
				nmap[i][j] = list.poll();
			}
		}
		
		for(int i=0; i<N; i++)
			map[i] = nmap[i].clone();
		
	}
}
