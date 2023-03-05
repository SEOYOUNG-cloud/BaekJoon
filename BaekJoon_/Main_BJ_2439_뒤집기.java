import java.util.*;
import java.io.*;

public class Main_BJ_2439_뒤집기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();

        int zero = 0;
        int one = 0;
        boolean zeroCheck = false;
        boolean oneCheck = false;
        for(int i = 0; i<S.length; i++){
            if(S[i] == '0'){
                if(!zeroCheck){
                    zero += 1;
                    zeroCheck = true;
                }
                oneCheck = false;
            } else{
                if(!oneCheck){
                    one += 1;
                    oneCheck = true;
                }
                zeroCheck = false;
            }
        }

        System.out.println(Math.min(zero, one));

    }
}
