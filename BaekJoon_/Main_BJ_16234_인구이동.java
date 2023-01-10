import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;
import java.util.StringTokenizer;

public class Main_BJ_16234_인구이동 {
    static int N, L, R; // 맵 크기, 최소인구, 최대인구
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move();
        System.out.println(answer);

    }
    static int answer = 0;
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    /*
    * 1. 인접 차이 확인해서 visited 배열에 표시
    * 2. 인구 이동 시작
    *   2-1. ArrayList에 넣으면서 bfs 돌기
    * */
    private static void move() {
        // 1. 인접 차이 확인하기
        boolean visited[][] = new boolean[N][N];
        boolean check = false;

        Queue<int[]> queue = new ArrayDeque<>(); // x,y,바꿀 수
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]) continue;

                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{i,j});

                int cnt = 0;
                int people = 0;
                ArrayList<int[]> list = new ArrayList<>();
                while(!q.isEmpty()) {
                    int out[] = q.poll();
                    int x = out[0];
                    int y = out[1];

                    if(visited[x][y]) continue;
                    visited[x][y] = true;
                    cnt += 1;
                    people += map[x][y];
                    list.add(new int[]{x,y});

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

                        int left = map[x][y];
                        int right = map[nx][ny];

                        if (Math.abs(left - right) >= L && Math.abs(left - right) <= R) {
                            q.offer(new int[]{nx,ny});
                        }
                    }
                }
                int temp = people/cnt;
                for(int l=0; l<list.size(); l++){
                    int[] out = list.get(l);
                    queue.offer(new int[]{out[0], out[1], temp});
                }
                if(list.size() > 1) check=true;
            }
        }
        while(!queue.isEmpty()){
            int out[] = queue.poll();
            int x = out[0];
            int y = out[1];
            int temp = out[2];

            map[x][y] = temp;
        }
        if(!check) return;
        answer += 1;
        move();

    }
}
