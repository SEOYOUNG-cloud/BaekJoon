package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2636_치즈_박서영 {
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

        int total = 0;
        while(true) {
            delete = new boolean[N][M];
            before = 0;
            dfs(0,0,new boolean[N][M]);

            // 지운 값
            time += 1;

            // 방금 dfs 돌린거에서 1을 지운 개수 = before
            // 1을 지운 개수 합 = total
            // visited 한 값 0으로 바꾸기
            for(int i=0; i<N; i++)
                for(int j=0; j<M; j++)
                    if(delete[i][j]) map[i][j] = 0;


            total += before;
            if(one == total) { // 없앤 개수 합이 처음 1의 개수면 끝냄
                sb.append(time).append('\n').append(before);
                break;
            }

        }

        System.out.println(sb.toString());
    }
    static int total;
    static boolean delete[][] = new boolean[N][M];

    private static void dfs(int x, int y, boolean[][] visited) {
        // map에서 0인 부분 visited 배열에 true 표시
        visited[x][y] = true;

        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(map[nx][ny] == 1 && !delete[nx][ny]) {
                delete[nx][ny] = true;
                before += 1;
            }
            if(map[nx][ny] == 0 && !visited[nx][ny]) {
                delete[nx][ny] = true;
                dfs(nx, ny, visited);
            }
        }

    }


}