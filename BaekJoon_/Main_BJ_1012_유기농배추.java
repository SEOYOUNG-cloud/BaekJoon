package Baek;

import java.util.*;
import java.io.*;

public class Main_BJ_1012_유기농배추 {
    private static int T;
    private static int M, N, K;
    private static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            map = new boolean[M][N];
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = true;
            }

            int ans = 0;
            int dx[] = {1, 0, -1, 0};
            int dy[] = {0, 1, 0, -1};
            // 1. scan map
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    // 2. if find the cabbage, search around the 4 direction
                    if (map[i][j]) {
                        // 3. put the earthworm
                        ans += 1;

                        // 4. search (use BFS)
                        Queue<int[]> queue = new ArrayDeque<int[]>();
                        queue.add(new int[]{i, j});
                        map[i][j] = false;

                        while (!queue.isEmpty()) {
                            int xy[] = queue.poll();
                            int x = xy[0];
                            int y = xy[1];

                            for (int d = 0; d < 4; d++) {
                                int nx = x + dx[d];
                                int ny = y + dy[d];

                                if (nx >= M || nx < 0 || ny >= N || ny < 0) continue;

                                if (map[nx][ny]) {
                                    queue.add(new int[]{nx, ny});
                                    map[nx][ny] = false;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
        }

    }
}