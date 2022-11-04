import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 그리디하게 풀어야지
        // 두 배열의 총합을 구한다.
        long hap1=0, hap2=0;
        int size = queue1.length;
        
        // 두 배열을 큐에 넣기
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for(int i=0; i<size; i++){
            hap1 += queue1[i];
            hap2 += queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        // 만들어야 하는 수
        long goal = (hap1+hap2)/2;
        
        // 합이 홀수이면 -1출력
        if((hap1+hap2)%2 == 1){
            return -1;
        }
        
        int cnt1 = 0, cnt2 = 0; // 각각의 큐에서 빼낸 횟수 (=움직인 횟수)
        // 빼낸 횟수가 본인이 가지고 있던것보다 적어야함
        while(cnt1 <= size*2 && cnt2 <= size*2){
            // 양쪽 합이 goal과 같다면 끝낸다.
            if(hap1 == goal && hap2 == goal){
                return cnt1+cnt2;
            }     
            
            // 큰쪽에서 작은 쪽으로 움직인다.
            if(hap1 > hap2){
                int out = q1.poll();
                q2.add(out);
                hap1 -= out;
                hap2 += out;
                
                cnt1 += 1;
            } else{
                int out = q2.poll();
                q1.add(out);
                hap1 += out;
                hap2 -= out;
                
                cnt2 += 1;
            }
        }
        
        return -1;
        
    }
}