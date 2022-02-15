package Programmers;

import java.util.Stack;

public class HateSameNumber {
	public static void main(String[] args) {
		int arr[] = {1, 1, 3, 3, 0, 1, 1};
		
		System.out.println(solution(arr));
	}
	
	public static int[] solution(int []arr) {
        int[] answer;
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++)
            if(stack.peek() != arr[i])
                stack.push(arr[i]);
        
        answer = new int[stack.size()];
        
        int index = 0;
        for(int i : stack)
            answer[index++] = i;
       
        return answer;
    }

}
