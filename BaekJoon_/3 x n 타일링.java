class Solution {   
    public int solution(int n) {
        if(n<2) return 0;
        
        long[] dp = new long[n+1];
        
        dp[0] = 1;
        dp[2] = 3;
        
        long new_arrange=0;
        
        for(int i=4; i<=n; i+=2){
            new_arrange += (dp[i-4] * 2) % 1000000007;
            dp[i] = (dp[i-2] * 3 + new_arrange) % 1000000007;     
        }
        
        return (int)dp[n];
    }
}