package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_5052_전화번호목록 {

    static int n;
    static String[] callList;
    static boolean checkConsist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=t; tc++) {
            n = Integer.parseInt(br.readLine());
            callList = new String[n];

            for(int i=0; i<n; i++) {
                String number = br.readLine();
                callList[i] = number;
            }

            /* 입력 끝 */
            checkConsist = true; // 일관성이 있다고 본다.

            Arrays.sort(callList);
            for(int i=0; i<n-1; i++) {
                if(callList[i].length() >= callList[i+1].length() && callList[i].substring(0, callList[i+1].length()).equals(callList[i+1])) {
                    checkConsist = false;;
                    break;
                } else if(callList[i].length() < callList[i+1].length() && callList[i+1].substring(0, callList[i].length()).equals(callList[i])) {
                    checkConsist = false;;
                    break;
                }
            }


            if(checkConsist) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');


        }
        System.out.println(sb.toString());

    }

}
