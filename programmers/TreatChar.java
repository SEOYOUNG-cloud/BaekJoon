package Programmers;

public class TreatChar { // 문자열 다루기 기본
	public static void main(String[] args) {
		String s = "1234";
		
		System.out.println(solution(s));
		
	}
	public static boolean solution(String s) {
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9' && (s.length() == 4 || s.length() == 6))
                continue;
            else
                return false;
        }
        return true;
    }
}
