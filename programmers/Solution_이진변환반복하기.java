package programmers;

import java.util.*;
import java.io.*;

public class Solution_이진변환반복하기 {

    public int[] solution(String s) {
        int answer[] = new int[2];

        while(!s.equals("1")){
            answer[0] += 1;
            // 1. 0 제거
            int pre = s.length();
            s = s.replace("0", "");
            answer[1] += pre - s.length();

            // 2. 자리 수를 2진법으로 변환
            StringBuilder sb = new StringBuilder();
            int temp = s.length();
            while(temp != 0){
                sb.append(temp%2);
                temp /= 2;
            }
            s = sb.reverse().toString();
        }
        return answer;
    }
}
