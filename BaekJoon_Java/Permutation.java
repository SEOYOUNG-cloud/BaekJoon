package algorithm;

public class Permutation {
	static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) 
	   // arr[] = {1,2,3}
	   // output[] = 만들어진 원소 ex) {2,1,3} 등
	   // visited[] = 위 그림에서 output[0] = 1이고 나머지는 비어있다면 
	   //           [0]은 들른거임 그래서 output[1]에 원소 넣는 식으로 진행
	   // depth = 그림을 보면 알 수 있는 깊이를 나타낸다. 원소에 넣을 순서를 나타내기도 함
	   // n = arr.length , r = 다들 알겠지


	   {
		if(depth == r) {
			System.out.println(output[0] + output[1] + output[1] + r); // 만들어진 원소 출력
			return;
		}

		for(int i = 0; i < n; i++) {
			if(visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				permutation(arr, output, visited, depth + 1, n, r);    
				visited[i] = false; // 방문한곳 리셋
			}
		}
	}
}
