package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1927_최소힙_heap {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] 연산 = new int[N+1];
		int idx = 1;
		
		minHeap heap = new minHeap();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int cmd = Integer.parseInt(br.readLine());
			if(cmd == 0) {
				sb.append(heap.delete()).append('\n');
			} else {
				heap.insert(cmd);
			}
		}
		
		System.out.println(sb.toString());

	}
	private static class minHeap{
		private ArrayList<Integer> heap;
		
		public minHeap() {
			heap = new ArrayList<>();
			heap.add(0); // 0번 인덱스 사용x
		}
		
		// 삽입
		public void insert(int val) {
			heap.add(val);
			int idx = heap.size() - 1; // 새로 삽입한 노드의 인덱스
			// 새로 삽입한 노드의 부모가 자식보다 크면 
			while(idx > 1 && heap.get(idx/2) > heap.get(idx)) {
				int temp = heap.get(idx/2);
				heap.set(idx/2, val);
				heap.set(idx, temp);
				
				idx /= 2;
			}
		}
		
		// 삭제
		public int delete() {
			// 힙이 비었으면 0 리턴
			if(heap.size()-1 < 1) {
				return 0;
			}
			
			// 삭제할 노드, 루트 노드
			int deleteNode = heap.get(1);
			
			// 마지막 노드를 루트에 삽입하고 마지막 노드 삭제
			heap.set(1,  heap.get(heap.size()-1));
			heap.remove(heap.size() - 1);
			
			int idx = 1; // 루트에 새로 삽입한 노드의 인덱스 정보
			
			while((idx * 2) < heap.size()) {
				int left = heap.get(idx * 2);
				int leftIdx = idx * 2;
				int rightIdx = idx * 2 + 1;
				
				// 오른쪽이 있고 왼쪽보다 작을 때 오른쪽꺼랑 바꾼다. 
				if((rightIdx < heap.size()) && (left > heap.get(rightIdx))) {
					left = heap.get(rightIdx);
					leftIdx = rightIdx;
				}
				
				// 부모가 더 작으면 멈춤 
				if(left > heap.get(idx)) break;
				
				// 부모랑 자식 교환 
				int temp = heap.get(idx);
				heap.set(idx, heap.get(leftIdx));
				heap.set(leftIdx, temp);
				idx = leftIdx;
			}
			return deleteNode;
		}
	}

}
