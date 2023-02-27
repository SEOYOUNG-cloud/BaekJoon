import java.util.*;
import java.io.*;
public class Main_BJ_11727_2xn타일링2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=N; i++){
            dp[i] = (2 * dp[i-2] + dp[i-1]) % 10007;
        }

        System.out.println(dp[N]);

    }
}
