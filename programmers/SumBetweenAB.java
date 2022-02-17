package Programmers;

public class SumBetweenAB {
	public static long solution(int a, int b) {
        long answer = 0;
        
        if(a > b){
            int i = a;
            a = b;
            b = i;
        }
        
        for(long i = a; i <= b; i++)
            answer += i;
        
        return answer;
    }
}
