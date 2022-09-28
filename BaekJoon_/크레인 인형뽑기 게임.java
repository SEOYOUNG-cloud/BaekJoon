import java.util.*;

class Solution {
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
		Stack<Integer> stack = new Stack<>();
        int[] location = new int[board.length+1];
        
        // 제일 위에 있는 인덱스 location[] 배열에 담음
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board.length; j++)
                if(board[j][i] != 0) {
                    location[i+1]=j;
                    break;
                }
        // System.out.println(Arrays.toString(location));
        
        
        
        for(int i : moves){
            // System.out.println(stack);
            if(location[i] == board.length) continue; // board안 인형이 없음 = board 범위 넘어갔을 때
            if(stack.isEmpty()) // 스택이 비었으면 추가
                stack.push(board[location[i]][i-1]);
            else{ // 스택이 비지 않았다면 제일 위에 있는 인형과 비교
                if(stack.peek() == board[location[i]][i-1]){ // 넣으려는 인형과 같은 인형이면
                    stack.pop(); // pop시킴
                    answer += 2;
                }
                else // 넣으려는 인형과 다른 인형이면
                    stack.push(board[location[i]][i-1]); // 스택에 넣는다
            }
            location[i] += 1; // 인형을 꺼낼 위치 업데이트함
        }
        
        return answer;
	}
}