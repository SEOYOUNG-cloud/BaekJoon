package BeakJoon;

import java.util.ArrayList;

class MockTest {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int st1 = 0, st2 = 0, st3 = 0;
        
        for(int i = 0; i < answers.length; i++){
            if(student1[i % student1.length] == answers[i]) st1++;
            if(student2[i % student2.length] == answers[i]) st2++;
            if(student3[i % student3.length] == answers[i]) st3++;
        }
        
        int max = Math.max(Math.max(st1, st2), st3);
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(max == st1) arrayList.add(1);
        if(max == st2) arrayList.add(2);
        if(max == st3) arrayList.add(3);
        
        answer = new int[arrayList.size()];
        
        int size = 0;
        for(int temp : arrayList)
            answer[size++] = temp;
        
        return answer;
    }
}
