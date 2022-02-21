import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AntWorrier { // 개미전사 DP
	public static void main(String[] args) throws IOException{
		
		int warehouse[];
		int d[] = new int[100];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		warehouse = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			warehouse[i] = Integer.parseInt(st.nextToken());
		
		
		d[0] = warehouse[0];
		d[1] = Math.max(warehouse[0], warehouse[1]);
		
		for(int i = 2; i < N; i++)
			d[i] = Math.max(d[i - 1], d[i - 2] + warehouse[i]);
		
		System.out.println(d[N - 1]);
		
		
	}

}
