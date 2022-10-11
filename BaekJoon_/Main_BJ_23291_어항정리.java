package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_23291_어항정리 {
	
	static int N,K;
	static ArrayList<ArrayList<Integer>> fishbowl;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		fishbowl = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<N; i++)
			fishbowl.add(new ArrayList<>());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			fishbowl.get(0).add(Integer.parseInt(st.nextToken()));
		
		/////// 입력 끝 //////////
		
		int answer = 0;
		while(true) {
			answer += 1;
			if(FishbowlCleanup() <= K) {
				break;
			}
		}
		
		System.out.println(answer);
		
	}
	// 어항 정리
	private static int FishbowlCleanup() {
		// 1. 물고기의 수가 적은 어항에 물고기 한 마리 넣기
		int less = Integer.MAX_VALUE;
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			if(less > fishbowl.get(0).get(i)) {
				less = fishbowl.get(0).get(i);
				set.clear();
				set.add(i);
			} else if(less == fishbowl.get(0).get(i))
				set.add(i);
		}
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			int next = (int) iter.next();
			fishbowl.get(0).set(next, fishbowl.get(0).get(next) + 1);
		}

		
		// 2. 가장 왼쪽에 있는 어항을 그 오른쪽 어항 위에 올려놓기
		int left = fishbowl.get(0).get(0);
		fishbowl.get(0).remove(0); // 왼쪽꺼 없앰
		fishbowl.get(1).add(left); // 그 오른쪽 위에 붙임
		
		// 3. 2개 이상 쌓인 어항을 떼고 90도 회전해서 어항 위에 놓기
		Turn90AndPut();
		
		// 4. 물고기 수 조절
		// 4-1. 인접한 물고기 수 차이 / 5 > 0 이면 그 몫만큼 보내기 (동시에) = BFS
		MoveFish();
		
		// 5. 일렬로 놓기
		MoveLine();
		
		// 6. 반으로 접어서 위에 올리기 (180도) 2번
		Turn180AndPut();
		Turn180AndPut();
		
		// 7. 물고기 조절작업
		MoveFish();
		
		// 8. 일렬로 놓기
		MoveLine();
		
		// 9. 물고거기 가장 많은 어항과 적은 어항 수 차이가 K 이하면 끝내기
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			max = Math.max(fishbowl.get(0).get(i), max);
			min = Math.min(fishbowl.get(0).get(i), min);
		}
		
		return max - min;
			
		
	}
	private static void Turn180AndPut() {
		Stack<Integer> stack = new Stack<>();
		int size = fishbowl.get(0).size()/2;
		int height = 0;
		for(int i=0; i<N; i++) {
			if(fishbowl.get(i).size() == 0) break;
			for(int j=0; j<size; j++) {
				stack.add(fishbowl.get(i).get(0));
				fishbowl.get(i).remove(0);
			}
			height += 1;
		}
		for(int i=height; i<height + height; i++)
			for(int j=0; j<size; j++)
				fishbowl.get(i).add(stack.pop());
		
	}
	private static void MoveLine() {
		int height = 0;
		int width = fishbowl.get(1).size();
		for(int i=0; i<N; i++) {
			if(fishbowl.get(i).size() == 0) break;
			height += 1;
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=0; i<fishbowl.get(0).size(); i++) {
			if(i < width) {
				for(int j=0; j<height; j++)
					queue.add(fishbowl.get(j).get(i));
			} else {
				queue.add(fishbowl.get(0).get(i));
			}
		}
		
		for(int i=0; i<N; i++)
			fishbowl.get(i).clear();
		
		int size = queue.size();
		for(int i=0; i<size; i++)
			fishbowl.get(0).add(queue.poll());
			
		
	}
	private static void Turn90AndPut() {
		// 2개 이상 쌓인 인덱스가 어디까지인지 찾기
		int idx = fishbowl.get(1).size(); // 너비(width) = 인덱스
		
		// 높이 재기
		int height = 0;
		for(int i=0; i<N; i++) {
			if(fishbowl.get(i).size() == 0) {
				break;
			}
			height ++;
		}
		if(height > fishbowl.get(0).size() - (idx)) return;
		
		// 떼어내서 큐에 넣어놓음
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=idx-1; i>=0; i--) {
			for(int j=0; j<height; j++)
				queue.add(fishbowl.get(j).get(i));
		}
//		System.out.println(queue);
		
		// 떼어낸 부분 삭제
		for(int i=0; i<idx; i++)
			for(int h=0; h<height; h++)
				fishbowl.get(h).remove(0);
		
		// 큐에 넣은거 붙이기
		for(int i=1; i<idx+1; i++)
			for(int j=0; j<height; j++)
				fishbowl.get(i).add(queue.poll());
		
		Turn90AndPut();
		
	}
	
	static int[] dx = {1,0}; // 오른쪽, 아래만 검사하자
	static int[] dy = {0,1};
	private static void MoveFish() {
		ArrayList<ArrayList<Integer>> clone = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<N; i++)
			clone.add(new ArrayList<>());
		for(int i=0; i<N; i++)
			for(int j=0; j<fishbowl.get(i).size(); j++)
				clone.get(i).add(j,fishbowl.get(i).get(j));
		
		
		// 오른쪽, 아래 검사하면서 fishbowl 값 변경
		int down = 0;
		for(int i=0; i<N; i++) {
			if(clone.get(i).size() == 0) break;
			down += 1;
		}
		int down_right = clone.get(1).size();
		
		for(int i=0; i<N; i++) {
			if(clone.get(i).size() == 0) break; // 검사하려는 높이가 비어있다면 끝냄
			int right = clone.get(i).size(); // 이 줄의 개수
			for(int j=0; j<right-1; j++) { // 오른쪽 검사
				int num = Math.abs(clone.get(i).get(j) - clone.get(i).get(j+1)) / 5;
				if(num > 0) {
					if(clone.get(i).get(j) > clone.get(i).get(j+1)) { // j가 더 큼
						fishbowl.get(i).set(j, fishbowl.get(i).get(j) - num);
						fishbowl.get(i).set(j+1, fishbowl.get(i).get(j+1) + num);
					} else { // j가 더 작음
						fishbowl.get(i).set(j+1, fishbowl.get(i).get(j+1) - num);
						fishbowl.get(i).set(j, fishbowl.get(i).get(j) + num);
					}
				}
			} // 오른쪽 다 옮김
			
			// 아래 옮기기
			if(i <= down-2) {
				for(int j=0; j<down_right; j++) {
					int num = Math.abs(clone.get(i+1).get(j) - clone.get(i).get(j)) / 5;
					if(num > 0) {
						if(clone.get(i+1).get(j) > clone.get(i).get(j)) { // i+1번째가 더 큼
							fishbowl.get(i+1).set(j, fishbowl.get(i+1).get(j) - num);
							fishbowl.get(i).set(j, fishbowl.get(i).get(j) + num);
						} else { // i번째가 더 큼
							fishbowl.get(i).set(j, fishbowl.get(i).get(j) - num);
							fishbowl.get(i+1).set(j, fishbowl.get(i+1).get(j) + num);
						}
					}
				}
			} // 아래부분 끝
			
		}
		
	}

}
