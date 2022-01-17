package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek1931 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int meeting = Integer.parseInt(br.readLine());
		int[][] time = new int[meeting][2];
		int count = 0;
		int pre_time = 0;
		
		for(int i = 0; i < meeting; i++) {
			st = new StringTokenizer(br.readLine(), " ");			
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, new Comparator<int[]>(){
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1] == o2[1])
					return o1[0] - o2[0]; // 끝나는 시간이 같으면 시작 시간이 작은것부터 정렬
				
				return o1[1] - o2[1]; // 끝나는 시간이 작은 것부터 정렬
			}
		});
		
		for(int i = 0; i < meeting; i++) {
			if(pre_time <= time[i][0]) {
				pre_time = time[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}
}
