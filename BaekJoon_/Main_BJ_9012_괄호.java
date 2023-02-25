import java.util.*;
import java.io.*;

public class Main_BJ_9012_괄호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){

            String line = br.readLine();

            Stack<Character> stack = new Stack<>();
            for(int i=0; i<line.length(); i++){
                char check = line.charAt(i);

                if(stack.isEmpty()){
                    stack.add(check);
                } else if(check == ')' && stack.peek() == '('){
                    stack.pop();
                } else{
                    stack.add(check);
                }
            }

            if(stack.isEmpty()) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }

        System.out.println(sb.toString());

    }
}
