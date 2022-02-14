package BeakJoon;

public class pro_TargetNumber {
	   public static int answer = 0;
	   
	   public int solution(int[] numbers, int target) {
	       dfs(numbers, target, 0, 0);
	       
	       return answer;
	   }
	    
	   public void dfs(int[] numbers, int target, int count, int sum){
	       if(count == numbers.length){
	           if(target == sum)
	               answer++;
	       }           
	       else{
	           dfs(numbers, target, count + 1, sum + numbers[count]);
	           dfs(numbers, target, count + 1, sum - numbers[count]);
	      }

	  }
}
