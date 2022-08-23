package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main_BJ_17135_캐슬디펜스_박서영 {
	
	static class Monster implements Comparable<Monster>, Cloneable{
		int x;
		int y;
		
		Monster(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Monster o) {
			
			if(this.y != o.y) return this.y - o.y; // 왼쪽에 있는 적 먼저 죽이므로.. y기준 오름차순
			else
				return o.y - this.y; // x는 아래에 가까울수록 궁수와 가까워지므로 내림차순
		}
		
		@Override
		protected Monster clone() throws CloneNotSupportedException {
			return (Monster)super.clone();
		}
	}
	
	static int N,M,D,answer = Integer.MIN_VALUE;
	static int map[][];
	static int Archer_idx[] = new int[3];
	static ArrayList<Monster> monster = new ArrayList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if(tmp == 1)
					monster.add(new Monster(i,j)); // 몬스터 위치 저장
				
			}
		}
		
		
		/// 입력 끝 ///
		
		comb(0,0);
		System.out.println(answer);
	}
	// 1. 순열 MC3으로 궁수 배치 (인덱스)
	private static void comb(int cnt, int start) throws CloneNotSupportedException {
		if(cnt == 3) {
			// 궁수 배치했으니까 쏘는거 구현
			
			// monster 리스트 복사한 monster_clone 리스트 만듦
			ArrayList<Monster> monster_clone = new ArrayList<>();
			for(Monster m : monster)
				monster_clone.add(m.clone());
			
			// dfs로 보내준다
			Find_Can_Kill(monster_clone,Archer_idx, 0);

			return;
		}
		for(int i=start; i<M; i++) {
			Archer_idx[cnt] = i;
			comb(cnt+1, i+1);
			
		}
	}
	// 2. dfs로 궁수 배치한거 타고 cnt 계산
	private static void Find_Can_Kill(ArrayList<Monster> monster_list ,int[] Archer_idx, int cnt) {
		// 돌기 전에 몬스터가 0개인지 확인함 몬스터가 전진해서 없을수도 있으니까..
		if(monster_list.size() == 0) {
			if(cnt > answer) answer = cnt;
			return;
		}
		
		ArrayList<Monster> list;
		int[] kill_index[] = new int[3][];
		
		A: for(int i=0; i<3; i++) {
			list = new ArrayList<>();
			// 궁수 위치는 N, Archer_idx[i], 몬스터 위치는 monster.get()x,y
			for(int d = 1; d <= D; d++) { // 거리가 가까운것부터 찾기
				for(int j = 0; j < monster_list.size(); j++) { // 몬스터 훑기
					if(Math.abs(N - monster_list.get(j).x) + Math.abs(Archer_idx[i]- monster_list.get(j).y) == d)
						list.add(new Monster(monster_list.get(j).x, monster_list.get(j).y));
				}	
				if(list.size() != 0) {
					// 왼쪽에 있는 적을 공격해야하므로 정렬
					Collections.sort(list);
					kill_index[i] = new int[] {list.get(0).x, list.get(0).y};
					continue A;
				}
			}
		} // 여기까지 하면 kill_index에 죽일 몬스터의 x,y값 3개가 들어있거나 없음
		
		// kill_index 안에 있는 몬스터 죽이고 count+1
		for(int i=0; i<kill_index.length; i++) {
			if(kill_index[i] == null) continue; // 비어있으면 넘어감
			
			// monster 리스트에서 몬스터 훑으면서 해당하면 지운다.
			for(int m=0; m<monster_list.size(); m++) {
				if(monster_list.get(m).x == kill_index[i][0] && monster_list.get(m).y == kill_index[i][1]) {
					monster_list.remove(m);
					cnt += 1;
					break;
				}
			}
		}
		// 몬스터 해치우고 몬스터가 0개면 끝냄, 아니라면 몬스터 땡김
		if(monster_list.size() == 0) {
			if(cnt > answer) answer = cnt;
			return;
		}
				
		// 몬스터를 한칸 땡기고 다시돌아야함
		for(int m=0; m<monster_list.size(); m++) {
			int move_m = monster_list.get(m).x + 1;
			if(move_m >= N) {
				monster_list.remove(m--); // 끝에 도달했으면 몬스터 지움
				continue;
			}
			// 도달하지 않았다면 몬스터 옮김
			monster_list.get(m).x += 1;
		}
		
		Find_Can_Kill(monster_list,Archer_idx, cnt);
		
	}

}
