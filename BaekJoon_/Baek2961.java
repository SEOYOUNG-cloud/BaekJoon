package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식_박서영 {

	static int N, min=Integer.MAX_VALUE;
	static int sinmat[], sunmat[];
//	static ArrayList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		sinmat = new int[N];
		sunmat = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			sinmat[i] = Integer.parseInt(st.nextToken());
			sunmat[i] = Integer.parseInt(st.nextToken());
		}
		
		subset();
		
		System.out.println(min);
		

	}
	private static void subset() {
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int flag=0, caseCnt = 1<<N; flag < caseCnt; flag++) { 
			list.clear();
			for(int i=0; i<N; i++)
				if( (flag & (1<<i)) != 0 ) { 
					list.add(i);
				}
//			System.out.println(list);
			
			// 인덱스 보내기
			if(list.size() != 0) calcul(list);
			
		}
	}
	
	private static void calcul(ArrayList<Integer> index) {
		int sin = 1; // 신맛 
		int sun = 0; // 쓴맛 
		
		for(int i=0; i<index.size(); i++) {
			int idx = index.get(i);
			sin *= sinmat[idx];
			sun += sunmat[idx];
		}
		
		min = Math.min(min, Math.abs(sin-sun));
	}

}
