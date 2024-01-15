package Baek;

import java.util.*;
import java.io.*;

public class Main_BJ_7576_토마토_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int map[][] = new int[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int input = Integer.parseInt(st.nextToken());
                // if find tomato, store that seat
                if(input == 1) {
                    queue.add(new int[] {i, j});
                }
                map[i][j] = input;
            }
        }

        // BFS
        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};
        int ans = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            ans += 1;

            while(size --> 0) {
                int[] xy = queue.poll();
                int x = xy[0];
                int y = xy[1];

                for(int d=0; d<4; d++) {
                    int nx = x+dx[d];
                    int ny = y+dy[d];

                    if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;

                    if(map[nx][ny] == 0) {
                        queue.add(new int[] {nx, ny});
                        map[nx][ny] = 1;
                    }
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(ans);
    }
}
