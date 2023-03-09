import java.util.*;
import java.io.*;

public class Main_BJ_1629_곱셈 {

    static int A, B, C;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A,B));
    }
    private static long pow(int a, int b){ // a^b
        if(b==1) return a % C;

        long temp = pow(a, b/2);
        // b가 짝수일 때
        if(b % 2 == 0) {
            return (temp * temp)%C;
        } else{
            return (temp * temp % C) * a %C;
        }
    }
}
