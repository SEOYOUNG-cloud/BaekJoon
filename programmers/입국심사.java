import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 1000000000;
        long left = 0, right = 1000000000, mid = 0;
        
        if(n <= 2) return 0;
        
        Arrays.sort(times);
        right = (long)n * times[times.length - 1];
        
        while(left <= right){
            long person = 0;
            mid = (left + right) / 2; // 걸리는 시간
            System.out.println(left + " " + mid + " " + right);
            
            for(int i=0; i<times.length; i++){ // 한 심사대에서 그 시간 안에 받을 수 있는 사람 수 더함
                person += mid / times[i];
            }
            System.out.println(person);
            
            if(person >= n){ // 심사대에서 받을 수 있는 사람 수가 많으면 시간을 줄여야지
                right = mid-1;
                answer = mid;
                
            } else{
                left = mid+1;
            }
            
        }
        return answer;
    }
}