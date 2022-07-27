package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek1546 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int scores[] = new int[N]; // 점수 넣어놓을 배열
		int max = Integer.MIN_VALUE; // 제일 높은 점수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(st.nextToken()); // 배열에 넣고
			max = Math.max(max, scores[i]); // 최대값 구하기
		}
		double avg = 0; // 평균
		
		for(int score : scores) {
			avg += (score*100.0 / max); // 새로운 성적 만들고 더하기
		}
		
		System.out.println(avg/N);	
		
	}

}
