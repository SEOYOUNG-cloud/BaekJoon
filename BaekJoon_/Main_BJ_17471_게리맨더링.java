package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BJ_17471_게리맨더링_박서영 {

	static ArrayList<Integer> number;
	static int[][] map;
	static int N;
	static int[] input = {1,2,3,4,5};
	static int score[];
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		score = new int[N];
		for(int i=0; i<N; i++)
			score[i] = Integer.parseInt(st.nextToken());
		
		map = new int[N][];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			int line[] = new int[num];
			for(int j=0; j<num; j++)
				line[j] = Integer.parseInt(st.nextToken()) - 1;
			
			map[i] = line;
			
		}
		
		number = new ArrayList<>();
		////// 입력  끝 //////
		
		subset(0,0);
		
		if(answer == Integer.MAX_VALUE)
			answer = -1;
		
		System.out.println(answer);
		
	}

	// 구역을 결정할 부분집합
	private static void subset(int cnt, int start) {
		if(cnt == N) {
			if(connect(number)) calcul(number);
			return;
		}
		
		for(int i=start; i<N; i++) {
			number.add(i);
			subset(cnt+1, i+1);
			number.remove(number.size()-1);
			subset(cnt+1, i+1);
		}
		
	}


	private static void calcul(ArrayList<Integer> number) {
		int a = 0, b=0;
		for(int i : number) {
			a += score[i];
		}
		
		for(int i : number2)
			b += score[i];
		
		answer = Math.min(answer, Math.abs(a-b));
	}


	// 각 구역이 하나로 연결되어있는지 확인
	static ArrayList<Integer> number2;
	private static boolean connect(ArrayList<Integer> number1) {
		if(number1.size() == 0 || number1.size() == N) return false;
		
		number2 = new ArrayList<>(); // 반대구역
		// 반대 구역 구하기
		for(int i=0; i<N; i++)
			if(!number1.contains(i))
				number2.add(i);
		
		
		// 각 구역이 연결되어 있는지 확인하기
		// number1 구역이 연결되어 있는지 확인
		Set<Integer> check = new HashSet<>(number1);
		
		if(number1.size() != 1) {
			if(!bfs(number1.get(0), check, number1)) return false;
		}
		
		// number2 구역이 연결되어 있는지 확인
		
		if(number2.size() != 1) {
			check = new HashSet<>(number2);
			
			if(!bfs(number2.get(0), check, number2)) return false;
		}
		
		return true;
		
	}
	private static boolean bfs(int in, Set<Integer> check, ArrayList<Integer> list) {
		boolean visited[] = new boolean[N];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(in);
		
		while(!queue.isEmpty()) {
			int out = queue.poll();
			visited[out] = true;
			if(check.contains(out)) check.remove(out);
			
			for(int j = 0; j < map[out].length; j++) {
				if(!visited[map[out][j]] && list.contains(map[out][j])) queue.add(map[out][j]);
			
					
			}
		}
		
		if(check.size() == 0) return true;
		else return false;
		
	}
	

}
