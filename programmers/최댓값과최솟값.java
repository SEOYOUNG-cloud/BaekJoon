class Solution {
    public String solution(String s) {
        String[] answer = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<answer.length; i++){
            if(Integer.parseInt(answer[i]) > max)
                max = Integer.parseInt(answer[i]);
            
            if(Integer.parseInt(answer[i]) < min)
                min = Integer.parseInt(answer[i]);
        }
            
        
        return min + " " + max;
    }
}