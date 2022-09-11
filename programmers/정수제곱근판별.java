class Solution {
    public long solution(long n) {
        long answer = 0;
        long l = (long)Math.sqrt(n);
        
        if(l == Math.sqrt(n))
            answer = (l+1) * (l+1);
        else
            answer = -1;
        
        return answer;
    }
}