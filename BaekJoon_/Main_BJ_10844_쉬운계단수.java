import java.util.*;
import java.io.*;

public class Main_BJ_10844_쉬운계단수 {
    public static void main(String[] args) throws Exception{
        int MOD = 1000000000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] d = new long[N+1][10];
        for(int i=1; i<=9; i++)
            d[1][i] = 1;

        for(int i=2; i<=N; i++){
            for(int j=1; j<=8; j++){
                    d[i][j] = (d[i-1][j-1] + d[i-1][j+1]) % MOD;
            }
            d[i][0] = d[i-1][1] % MOD;
            d[i][9] = d[i-1][8] % MOD;
        }

        long answer = 0;
        for(int i=0; i<=9; i++)
            answer += d[N][i];

        System.out.println(answer % MOD);
    }
}
