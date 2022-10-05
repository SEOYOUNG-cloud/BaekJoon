import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int x, y, cnt, key;

        public Node() {
            super();
        }


        public Node(int x, int y, int cnt, int key) {
            super();
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Node [x=" + x + ", y=" + y + ", cnt=" + cnt + ", key=" + key + "]";
        }
    }

    static int N, M;
    static char map[][];
    static int o_x, o_y;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];


        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                char in = line.charAt(j);
                map[i][j] = in;
                if(in == '0') {
                    o_x = i;
                    o_y = j;
                }
            }
        }
        // 입력 끝 //
        boolean[][][] visited = new boolean[N][M][64];

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(o_x, o_y, 0, 0));

        int answer = 0;
        while(!queue.isEmpty()) {
            Node out = queue.poll();
            int x = out.x;
            int y = out.y;
            int cnt = out.cnt;
            int key = out.key;

            if(map[x][y] == '1') {
                answer = cnt;
                break;
            }

            for(int d=0; d<4; d++) {
                int nx = x+dx[d];
                int ny = y+dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '#' || visited[nx][ny][key]) continue;
                visited[nx][ny][key] = true;
                if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f')
                    queue.add(new Node(nx, ny, cnt+1, (key | (1<<map[nx][ny]-97))));
                else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
                    if((key & (1<<map[nx][ny]-65)) != 0)
                        queue.add(new Node(nx, ny, cnt+1, key));
                    else
                        continue;
                }

                queue.add(new Node(nx, ny, cnt+1, key));
            }
        }

        if(answer == 0) answer = -1;
        System.out.println(answer);

    }

}
