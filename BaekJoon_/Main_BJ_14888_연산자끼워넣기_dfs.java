import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14888_연산자끼워넣기_dfs {
    // 백트래킹
    static int[] cmd; // 명령어
    static int[] cmdCnt; // 명령어 개수
    static int N;
    static int map[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        cmd = new int[N-1];
        cmdCnt = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            cmdCnt[i] = Integer.parseInt(st.nextToken());
        }

        /////////////
        dfs(1, map[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    private static void dfs(int cnt, int total){
        if(cnt == N){
            max = Math.max(total, max);
            min = Math.min(total, min);
            return;
        }
        for(int i=0; i<4; i++){
            if(cmdCnt[i] == 0) continue;
            cmdCnt[i] -= 1;
            switch (i){
                case 0:
                    dfs(cnt+1, total+map[cnt]);
                    break;
                case 1:
                    dfs(cnt+1, total-map[cnt]);
                    break;
                case 2:
                    dfs(cnt+1, total*map[cnt]);
                    break;
                case 3:
                    dfs(cnt+1, total/map[cnt]);
                    break;
            }
            cmdCnt[i] += 1;
        }
        
    }
}
