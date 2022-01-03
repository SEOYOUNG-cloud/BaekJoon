package greedy;

public class Joystick {
	public int solution(String name) {
        int answer = 0;
        int min = name.length() -1;
        
        String[] Falpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"};
        String[] Balpha = {"A", "Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O"};
        
        List<String> Flist = Arrays.asList(Falpha);
        List<String> Blist = Arrays.asList(Balpha);
        
        for(int i = 0; i < name.length(); i++){
            
            //상하
            if((Flist.indexOf(String.valueOf(name.charAt(i)))) != -1)
                answer += Flist.indexOf(String.valueOf(name.charAt(i)));
            else if((Blist.indexOf(String.valueOf(name.charAt(i)))) != -1)
                answer += Blist.indexOf(String.valueOf(name.charAt(i)));
            
            //좌우
            int nextIndex = i + 1;
            while(nextIndex < name.length() && name.charAt(nextIndex) == 'A')
                nextIndex++;
            
            min = Math.min(min, (i * 2) + name.length() - nextIndex);
        }
        
        answer += min;
        
        return answer;
    }
}
