package Programmers;

public class FindKim { // 서울에서 김서방 찾기
	public static String solution(String[] seoul) {
        String answer = "";
        for(int i = 0; i < seoul.length; i++)
            if(seoul[i].equals("Kim")) answer += i;
        
        return "김서방은 " +  answer + "에 있다";
    }

}
