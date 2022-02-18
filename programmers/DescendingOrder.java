package Programmers;

import java.util.Arrays;
import java.util.Collections;

public class DescendingOrder {
	class Solution {
	    public String solution(String s) {
	        String answer = "";
	        String character[] = s.split("");

	        
	        Arrays.sort(character, Collections.reverseOrder());
	        for(int i = 0; i < character.length; i++)
	            answer += character[i];
	        
	        return answer;
	    }
	}

}
