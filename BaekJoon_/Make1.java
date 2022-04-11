import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Make1 { // 1로 만들기 DP
	
	public static int d[] = new int[30001]; // DP 테이블, 연산의 횟수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		for(int i = 2; i <= X; i++) {
			
			// -1을 하는 경우
			d[i] = d[i - 1] + 1;
			
			// ÷2 하는 경우
			if(i % 2 == 0)
				d[i] = Math.min(d[i], d[i / 2] + 1);
			
			// ÷3 하는 경우
			if(i % 3 == 0)
				d[i] = Math.min(d[i], d[i / 3] + 1);
			
			// ÷5 하는 경우
			if(i % 5 == 0)
				d[i] = Math.min(d[i], d[i / 5] + 1);
		}
		
		System.out.println(d[X]);
	}

}
