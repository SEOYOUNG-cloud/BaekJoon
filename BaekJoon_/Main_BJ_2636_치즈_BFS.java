import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /**
     * 1. 가장자리부터 0인 부분 칠하기
     * 2. 그거 개수 세서 1인데 팔방이 2개 이상이면 바깥쪽으로 취급
     * */

    static int N, M; // 세로, 가로
    static int[][] map;
    static int one, before, time;
    static int[] dx = {1,0,-1,0,1,1,-1,-1};
    static int[] dy = {0,1,0,-1,1,-1,1,-1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int in = Integer.parseInt(st.nextToken());
                map[i][j] = in;
                if(in == 1) one += 1; // 치즈 개수
            }
        }

        // 입력 끝 //
        // 1. padding 부분 2로 채우기
        round(0,0);

        System.out.println(sb.toString());
    }

    // 0일 때 4방 탐색해서 1이 있으면 바꾸기
    private static void round(int i, int j) {
        boolean visited[][] = new boolean[N][M];
        boolean visited2[][] = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {i,j});
        int total = 0;

        while(!queue.isEmpty()) {
            int[] out = queue.poll();
            int x = out[0];
            int y = out[1];

            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    total += 1;
                }
                if(map[nx][ny] == 0 && !visited2[nx][ny]) {
                    visited2[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }


        // visited 한 값 0으로 바꾸기
        for(int x=0; x<N; x++)
            for(int y=0; y<M; y++)
                if(visited[x][y]) map[x][y] = 0;

        // 지운 값
        time += 1;
        before += total;

        if(one == before) { // 없앤 개수 합이 처음 1의 개수면 끝냄
            sb.append(time).append('\n').append(total);
            return;
        }

        round(0,0);
    }

}
