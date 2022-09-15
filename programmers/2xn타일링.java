class Solution {
    
    static int[] dp = new int[60001];
    
    public int solution(int n) {
        dp[1] = 1;
        dp[2] = 1;
        
        return fibo(n+1);
    }
    
    public static int fibo(int n){
        if(n == 1 || n == 2) return 1;

        if(dp[n] > 0) return dp[n];
        return dp[n] = (fibo(n-1) + fibo(n-2)) % 1000000007;
    }
}