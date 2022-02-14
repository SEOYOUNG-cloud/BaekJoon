package algorithm;


public class Year2016 {
	  public String solution(int a, int b) {
	     String answer[] = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
	     int date[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	        
	     int count = 0;
	     for(int i = 0; i < a; i++){
	          count += date[i];
	     }
	     count += b;       
	        
	     return answer[count % 7];
	  }
}

