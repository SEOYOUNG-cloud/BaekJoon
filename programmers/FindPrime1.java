package Programmers;

public class FindPrime1 { // 소수 찾기 level1
	public int solution(int n) {
        int answer = 0;
        boolean number[] = new boolean[n+1];
        
        for(int i = 2; i <= n; i++){
            if(number[i]) continue;
            
            for(int j = i * 2; j <= n; j += i)
                number[j] = true;
        }
        
        for(int i = 2; i <= n; i++) // 0,1은 소수 아니니까 2부터..
            if(!number[i]) answer++;
        
        return answer;
        
    }

}
