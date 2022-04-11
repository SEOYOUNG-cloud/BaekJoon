import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class efficientMoney { // 瓤啦利牢 拳企 备己 DP
	
	public static void main(String[] args) throws IOException{
		int money[];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		money = new int[N];
		int d[] = new int[M + 1];
		Arrays.fill(d, 10001);
		
		d[0] = 0;
		
		for(int i = 0; i < N; i++) 
			money[i] = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) 
			for(int j = money[i]; j <= M; j++) 
				if(d[j - money[i]] != 10001)
					d[j] = Math.min(d[j], d[j - money[i]] + 1);


		if(d[M] == 10001) System.out.println(-1);
		else {
			System.out.println(d[M]);
		}
		
	}

}
