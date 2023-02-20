import java.util.*;
import java.io.*;

public class Main_BJ_11054_가장긴바이토닉부분수열 {
    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열 A의 크기
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /* 입력 끝 */

        // 앞에서부터 증가하는 배열
        int upArr[] = new int[N];
        Arrays.fill(upArr, 1);
        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && upArr[j]+1 > upArr[i]){
                    upArr[i] = upArr[j] + 1;
                }
            }
        }

        // 뒤에서부터 증가하는 배열
        int downArr[] = new int[N];
        Arrays.fill(downArr, 1);
        for(int i=N-2; i>=0; i--){
            for(int j=N-1; j>i; j--){
                if(arr[i] > arr[j] && downArr[j]+1 > downArr[i]){
                    downArr[i] = downArr[j] + 1;
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int i=0; i<N-1; i++){
            int big = 0;
            for(int j=i+1; j<N-1; j++){
                if(upArr[i] != downArr[j])
                    big = Math.max(big, downArr[j]);

                answer = Math.max(answer, upArr[i] + big);
            }
        }

        if(N == 1 || answer == Integer.MIN_VALUE) System.out.println("1");
        else
            System.out.println(answer);
    }
}
