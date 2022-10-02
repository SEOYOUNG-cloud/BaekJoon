class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String[] digit = String.valueOf(x).split("");
        
        int sum = 0;
        for(String d : digit)
            sum += Integer.parseInt(d);
        
        answer = x % sum == 0 ? true : false;
        return answer;
    }
}