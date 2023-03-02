import java.util.*;
import java.io.*;

public class Main_BJ_10610_30 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] N = br.readLine().toCharArray();

        int total = 0;
        boolean zero = false;
        for(int i=0; i<N.length; i++){
            total += N[i] - '0';
            if(N[i] == '0' && !zero) zero = true;
        }

        StringBuilder sb = new StringBuilder();
        if(zero && total%3 == 0){
            Arrays.sort(N);
            for(int i=N.length-1; i>=0; i--)
                sb.append(N[i]);

            System.out.println(sb.toString());
        } else{
            System.out.println("-1");
        }



    }
}
