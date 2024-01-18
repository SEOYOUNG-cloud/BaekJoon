package programmers;

import java.util.*;
import java.io.*;

class Solution_JadenCase문자열만들기 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        answer.append(String.valueOf(s.charAt(0)).toUpperCase());

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1) == ' '){
                answer.append(String.valueOf(s.charAt(i)).toUpperCase());
            } else{
                answer.append(String.valueOf(s.charAt(i)).toLowerCase());
            }
        }

        return answer.toString();
    }
}
