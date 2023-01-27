import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14888_연산자끼워넣기 {
    // 순열
    static int[] cmd; // 명령어
    static int[] cmdList; // 명령어 종류
    static int N;
    static int map[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        cmd = new int[N-1];
        cmdList = new int[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            int in = Integer.parseInt(st.nextToken());
            while(in --> 0){
                cmdList[idx++] = i;
            }
        }

        /////////////
        permutation(0,0);
        System.out.println(max);
        System.out.println(min);
    }
    private static void permutation(int cnt, int flag){
        if(cnt == N-1){
            calculation(cmd);
            return;
        }

        for(int i=0; i<N-1; i++){
            if((flag&(1<<i)) != 0) continue;
            cmd[cnt] = cmdList[i];
            permutation(cnt+1, (flag | (1<<i)));
        }
    }
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;


    private static void calculation(int[] cmd){
        int total = map[0];
        for(int c=0; c<cmd.length; c++){
            switch (cmd[c]){
                case 0:
                    total += map[c+1];
                    break;
                case 1:
                    total -= map[c+1];
                    break;
                case 2:
                    total *= map[c+1];
                    break;
                case 3:
                    total /= map[c+1];
                    break;
            }
        }

        max = Math.max(total, max);
        min = Math.min(total, min);
    }
}
