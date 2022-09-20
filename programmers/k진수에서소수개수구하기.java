class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        // String num = Integer.toString(n,k);
        StringBuilder sb = new StringBuilder();
        
        while(n>0){
            sb.append(n%k);
            n /= k;
        }
        sb.reverse();
        
        String[] nums = sb.toString().split("0");
        for(String nn : nums){
            if(nn.equals("")) continue;
            if(isPrime(Long.parseLong(nn))) answer+=1;
        }
        
        return answer;
    }
    private static boolean isPrime(long n){
        if(n==1) return false;
        else if(n==2) return true;
        
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0) return false; // 나누어떨어지면 소수아님
        }
        return true;
    }
}