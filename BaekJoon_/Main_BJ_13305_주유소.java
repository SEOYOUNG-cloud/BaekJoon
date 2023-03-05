import java.util.*;
import java.io.*;

public class Main_BJ_13305_주유소 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] distance = new int[N-1]; // 거리
        int[] price = new int[N]; // 리터당 가격

        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalDis = 0;
        for(int i=0; i<N-1; i++){
            int dis = Integer.parseInt(st.nextToken());
            distance[i] = dis;
            totalDis += dis;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            price[i] = Integer.parseInt(st.nextToken());

        /* 입력 끝 */
        long minPrice = price[0];
        long answer = 0;
        for(int i=0; i<N-1; i++){
            if(minPrice > price[i]){
                minPrice = price[i];
            }

            answer += minPrice * distance[i];
        }

        System.out.println(answer);


    }
}
