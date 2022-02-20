public class PandY { // 문자열 내 p와 y의 개수
	boolean solution(String s) {
        boolean answer = true;

        int p = 0, y = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'P' || s.charAt(i) == 'p') p++;
            else if(s.charAt(i) == 'Y' || s.charAt(i) == 'y') y++;
        }
        
        if(p == y) answer = true;
        else answer = false;

        return answer;
    }

}
