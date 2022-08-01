package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek17478 {
	static int N;
	static String underBar = "____";
	static String talk[] = {"\"재귀함수가 뭔가요?\"", 
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""};
	static String end_talk[] = {"\"재귀함수가 뭔가요?\"", "\"재귀함수는 자기 자신을 호출하는 함수라네\""};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String start_talk = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";		
		System.out.println(start_talk);

		
		fibo(0);
		
		// end_talk 출력하는 구간
		String attach = "";
		for(int i = 0; i < N; i++) {
			attach += underBar;
		}
		for(int i = 0; i < end_talk.length; i++) 
			System.out.println(attach + end_talk[i]);
		
		// 라고 답변하였지
		end_fibo(N);
	}
	public static void fibo(int n) {
		if (n == N) return;
		String attach = "";
		for(int i = 0; i < n; i++) {
			attach += underBar;
		}
		
		for(int i = 0; i < talk.length; i++) 
			System.out.println(attach + talk[i]);
		
		n++;
		fibo(n);
		
	}
	public static void end_fibo(int n) {
		if(n < 0) return;
		String attach = "";
		for(int i = 0; i < n; i++) {
			attach += underBar;
		}
		
		System.out.println(attach + "라고 답변하였지.");
		
		n--;
		end_fibo(n);
	}
}
