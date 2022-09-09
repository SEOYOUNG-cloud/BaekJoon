class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = (long)num;
        
        while(n != 1){
            if(answer == 500){
                return -1;
            }
            if(n % 2 == 0) // 짝수라면
                n /= 2;
            else
                n = n*3 + 1;
            
            answer+=1;
        }
        return answer;
    }
}