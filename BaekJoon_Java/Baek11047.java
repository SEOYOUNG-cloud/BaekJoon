package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baek11047 {
	public static void  main(String[] args) throws IOException{ // 동전0
		//동전종류 N, 합 K 띄어쓰기로 입력받고 줄바꿔서 N개의 동전의 가치가 오름차순으로 주어짐 + N >= 2이면 배수로;;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 동전 종류 개수
		int K = Integer.parseInt(st.nextToken()); // 합
				
		int coin[] = new int[N];
		
		for(int i = 0; i < N; i++) { // 동전의 종류 입력받음
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int last = K;
		int count = 0;
		
		for(int i = N-1; i >=0; i--) {
			//if(last % coin[i] != last) {  
				count += last / coin[i];   // 어차피 더 큰값이면 몫이 0이기때문에 그냥 더해주면 됨!
				last = K - coin[i] * (K/coin[i]);
				if(last == 0) break;
			//} else {continue;}
		}
		
		System.out.println(count);
		
	}

}
