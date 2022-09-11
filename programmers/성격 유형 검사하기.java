import java.util.Arrays;
class Solution {
    static int[] score = {0,3,2,1,0,1,2,3}; // 점수
    static int[] result = {0,0,0,0,0,0,0,0}; // R T C F J M A N
    
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
       
        for(int i=0; i<survey.length; i++){
            int num = score[choices[i]];
            if(choices[i] < 4) add_score(survey[i].charAt(0), num);
            else if(choices[i] > 4) add_score(survey[i].charAt(1), num);
        }
        
        String[] str = {"R", "T", "C", "F", "J", "M", "A", "N"};
        for(int i=0; i<8; i+=2){
            if(result[i] >= result[i+1])
                answer.append(str[i]);
            else
                answer.append(str[i+1]);
        }
        
        return answer.toString();
    }
    static void add_score(char str, int num){
        
        switch(str){
            case 'R':
                result[0] += num;
                break;
            case 'T':
                result[1] += num;
                break;
            case 'C':
                result[2] += num;
                break;
            case 'F':
                result[3] += num;
                break;
            case 'J':
                result[4] += num;
                break;
            case 'M':
                result[5] += num;
                break;
            case 'A':
                result[6] += num;
                break;
            case 'N':
                result[7] += num;
                break;
        }
    }
}