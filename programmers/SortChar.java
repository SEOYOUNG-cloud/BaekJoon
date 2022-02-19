package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class SortChar {
	public static void main(String[] args) {
		String a[] = {"abce", "abcd", "cdx"};
		int b = 2;
		
		System.out.print(solution(a, b));
		
	}
	public static String[] solution(String[] strings, int n) {
        String[] answer;
        
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i < strings.length; i++)
            arrayList.add(strings[i].charAt(n) + strings[i]);
        
        Collections.sort(arrayList);
        
        answer = new String[arrayList.size()];
        
        for(int i = 0; i < arrayList.size(); i++)
            answer[i] = arrayList.get(i).substring(1);
        
        return answer;
    }

}
