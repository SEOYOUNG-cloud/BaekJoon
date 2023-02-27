import java.util.*;
import java.io.*;
public class Main_BJ_1003_피보나치함수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;

        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());

            for(int i=1; i<=N; i++){
                dp[i][0] = dp[i-1][1];
                dp[i][1] = dp[i-1][0] + dp[i-1][1];
            }

            System.out.printf("%d %d\n", dp[N][0], dp[N][1]);
        }
    }
}
