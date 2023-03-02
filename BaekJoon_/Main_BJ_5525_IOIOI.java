package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_5525_IOIOI {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        int answer = 0;
        int cnt = 0;
        for(int i=1; i<M-1; i++) {
            if(S[i] == 'O' && S[i+1] == 'I') {
                cnt += 1;

                if(cnt == N) {
                    if(S[i - (2*N - 1)] == 'I') answer += 1;

                    cnt -= 1;
                }
                i+=1;
            } else {
                cnt = 0;
            }
        }

        System.out.println(answer);
    }

}
