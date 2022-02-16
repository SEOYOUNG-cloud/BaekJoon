package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

class DivisableArrayOfNumber {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for(int i : arr)
            if(i % divisor == 0) arrayList.add(i);
        
        
        if(arrayList.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            answer = new int[arrayList.size()];
            int index = 0;
            for(int i : arrayList){
                answer[index++] = i;
            }
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}
