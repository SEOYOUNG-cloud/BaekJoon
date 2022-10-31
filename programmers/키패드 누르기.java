import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[][] location = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,2}};
        int left = 10; // *
        int right = 11; // #

        for(int n : numbers){
            if(n == 1 || n == 4 || n == 7){
                answer.append("L");
                left = n;
            } else if(n==3 || n==6 || n==9){
                answer.append("R");
                right = n;
            } else{
                int leftDir = Math.abs(location[n][0] - location[left][0]) + Math.abs(location[n][1] - location[left][1]);
                int rightDir = Math.abs(location[n][0] - location[right][0]) + Math.abs(location[n][1] - location[right][1]);

                if(leftDir < rightDir){ // 왼손이 더 가까우면
                    //왼손이 이동
                    answer.append("L");
                    left = n;
                } else if(leftDir > rightDir){ // 오른손이 더 가까우면
                    //오른손이 이동
                    answer.append("R");
                    right = n;
                } else{ // 거리가 같으면
                    // hand 손으로 이동
                    if(hand.equals("right")){
                        answer.append("R");
                        right = n;
                    } else{
                        answer.append("L");
                        left = n;
                    }
                }
            }

        }

        return answer.toString();

    }
}