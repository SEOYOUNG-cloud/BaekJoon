import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length()-2);
        String str1[] = s.split("\\}.\\{");
        Arrays.sort(str1, (String a, String b) -> a.length() - b.length());
        // System.out.println(Arrays.toString(str1));

        String answer[] = new String[str1.length];
        int idx = 0;

        for(int i=0; i<str1.length; i++){
            String[] list = str1[i].split(",");
            HashSet<String> set = new HashSet<>(Arrays.asList(answer));

            for(int j=0; j<list.length; j++){
                if(!set.contains(list[j])){
                    answer[idx++] = list[j];
                    break;
                }
            }
        }

        int ans[] = new int[str1.length];
        for(int i=0; i<answer.length; i++){
            ans[i] = Integer.parseInt(answer[i]);
        }


        return ans;
    }
}