import java.util.*;
import java.io.*;

public class Main_BJ_4949_균형잡힌세상 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true){
            String line = br.readLine();
            if(line.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            for(int i=0; i<line.length(); i++){
                char one = line.charAt(i);
                if(one == '(' || one == '[')
                    stack.add(one);
                else if(stack.isEmpty() && (one == ')' || one == ']')){
                    stack.add(one);
                    break;
                }
                else if(one == ')'){
                    if(stack.peek() == '(') stack.pop();
                    else break;
                } else if(one == ']'){
                    if(stack.peek() == '[') stack.pop();
                    else break;
                }
            }

            if(stack.isEmpty()) sb.append("yes").append('\n');
            else sb.append("no").append('\n');
        }

        System.out.println(sb.toString());

    }
}
