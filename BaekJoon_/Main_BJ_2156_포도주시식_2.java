import java.util.*;
import java.io.*;

public class Main_BJ_2156_포도주시식 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int wine[] = new int[N+1];
        for(int i=1; i<=N; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        /* 입력 끝 */
        int[] dp = new int[N+1];

        // 포도잔의 개수가 1개 or 2개라면
        if(N == 1){
            System.out.println(wine[1]);
            return;
        } else if(N == 2){
            System.out.println(wine[1] + wine[2]);
            return;
        }

        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        for(int i=3; i<=N; i++){
            // - - x
            int a = dp[i-1];

            // - x o
            int b = dp[i-2] + wine[i];

            // x o o
            int c = dp[i-3] + wine[i-1] + wine[i];

            dp[i] = Math.max(a, Math.max(b,c));
        }

        System.out.println(dp[N]);

    }
}
