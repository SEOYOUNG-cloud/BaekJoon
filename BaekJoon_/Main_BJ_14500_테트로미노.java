package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14500_테트로미노 {
	static int N, M;
    static int[][] map;
    static int answer = 0;
    static boolean visited[][];
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        
        // 입력 끝 //
        int count = 0;
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++)
        	for(int j=0; j<M; j++) {
        		visited[i][j] = true;
        		dfs(i,j,0,map[i][j]);
        		visited[i][j] = false;
        		
        		if(j+2 < M && i+1 < N) {
        			count = 0;
        			
        			count += map[i][j];
        			count += map[i][j+1];
        			count += map[i][j+2];
        			count += map[i+1][j+1];
        			
        			answer = Math.max(count, answer);
        		}
        		if(i+2 < N && j+1 < M) {
        			count = 0;
        			
        			count += map[i][j];
        			count += map[i+1][j];
        			count += map[i+2][j];
        			count += map[i+1][j+1];
        			
        			answer = Math.max(count, answer);
        		}
        		if(i-1 >= 0 && j+1 < M && i+1 < N) {
        			count = 0;
        			
        			count += map[i-1][j+1];
        			count += map[i][j];
        			count += map[i][j+1];
        			count += map[i+1][j+1];
        			
        			answer = Math.max(count, answer);
        		}
        		if(i-1 >= 0 && j+2 < M) {
        			count = 0;
        			
        			count += map[i][j];
        			count += map[i-1][j+1];
        			count += map[i][j+1];
        			count += map[i][j+2];
        			
        			answer = Math.max(count, answer);
        		}
        	}
        
        System.out.println(answer);
    }
    
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    
    private static void dfs(int x, int y, int cnt, int total) {
        if(cnt == 3) {
            answer = Math.max(answer, total);
            return;
        }
        
        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(nx, ny, cnt+1, total + map[nx][ny]);
            visited[nx][ny] = false;
            
        }
        
    }

}