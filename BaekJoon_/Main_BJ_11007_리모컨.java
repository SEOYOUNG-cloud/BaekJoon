import java.util.*;
import java.io.*;

public class Main_BJ_11007_리모컨 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        if(T == 0){
            int min = String.valueOf(N).length();
            System.out.println(Math.min(min, Math.abs(N-100)));
            return;
        }

        boolean[] broke = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<T; i++) // 고장난 숫자가 true
            broke[Integer.parseInt(st.nextToken())] = true;

        int answer = Math.abs(N-100);
        // 모든 숫자를 돌면서 (turn)
        // 만들려는 수 - turn = temp 에 고장난 숫자가 없는지 확인
        // 만들 수 있는 숫자라면 Math.min(자리수 + temp , N - 100)

        A: for(int i=0; i<=999999; i++){
            // 자리수
            String seat = String.valueOf(i);
            int len = seat.length();

            // 각 자리에 숫자가 고장났는지 확인 (고장났으면 X)
            for(int j=0; j<len; j++){
                int num = seat.charAt(j) - '0';
                if(broke[num])  continue A;
            }

            int min = Math.abs(N-i) + len;
            answer = Math.min(answer, min);


        }
        System.out.println(answer);

    }
}
