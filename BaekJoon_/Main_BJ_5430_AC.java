import java.util.*;
import java.io.*;
public class Main_BJ_5430_AC {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        A: for(int tc=1; tc<=T; tc++){
            char[] command = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());

            String in = br.readLine();
            in = in.substring(1, in.length()-1);

            if(n == 0) {
                // D가 있으면 error, R만 있으면 []
                for(int i=0; i<command.length; i++){
                    if(command[i] == 'D'){
                        sb.append("error").append('\n');
                        continue A;
                    }
                }
            }

            String[] temp = in.split(",");

            boolean dir = true; // 정방향
            int start = 0, end = temp.length-1;
            for(int i=0; i<command.length; i++) {
                char cmd = command[i];
                if (cmd == 'R') { // 뒤집기
                    dir = !dir;
                } else{ // 첫 번째 수 버리기
                    if(start > end){
                        sb.append("error").append('\n');
                        continue A;
                    } else{
                        if(dir) {
                            start += 1;
                        } else{
                            end -= 1;
                        }
                    }
                }
            }
            sb.append("[");
            boolean check = false;
            if(dir) {
                for (int i = start; i <= end; i++) {
                    sb.append(temp[i]).append(",");
                    check = true;
                }
            } else{
                for (int i = end; i >= start; i--) {
                    sb.append(temp[i]).append(",");
                    check = true;
                }
            }
            if(check) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("]").append('\n');

        }
        System.out.println(sb.toString());
    }
}
