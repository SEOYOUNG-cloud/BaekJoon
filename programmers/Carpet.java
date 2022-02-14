package algorithm;

public class Carpet {
	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		
		System.out.println("answer : " + solution(brown, yellow));
	}
	public static int[] solution(int brown, int yellow) {
	        int[] answer = new int[2];
	        int area = brown + yellow;
	        
	        for(int i = 1; i <= area; i++){
	            int x = i; // 세로
	            int y = area / x; // 가로
	            
	            if((x - 2) * (y - 2) == yellow){
	                answer[0] = y;
	                answer[1] = x;
	                return answer;
	            }
	        }
	        return answer;
	    }

}
