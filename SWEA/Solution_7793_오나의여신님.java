package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7793_오나의여신님 {
    
    static int N,M;
    static char[][] map;
    static int answer;
    static int S_x, S_y;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static ArrayList<int[]> demons;
    

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            answer = 0;
            
            map = new char[N][M];
            demons = new ArrayList<>();
            
            for(int i=0; i<N; i++) {
                String line = br.readLine();
                for(int j=0; j<M; j++) {
                    char in = line.charAt(j);
                    if(in == 'S') {
                        S_x = i;
                        S_y = j;
                    } else if(in == '*')
                        demons.add(new int[] {i,j});
                    
                    map[i][j] = in;
                }
            }
            
            
            //// 입력 끝 ////
            String answer = bfs();
            if(answer.equals("-1")) answer = "GAME OVER";
            
            sb.append("#").append(tc).append(" ").append(answer).append('\n');
            
        }
        System.out.println(sb.toString());

    }
    // 악마이동 -> 수연이동
    
    private static String bfs() {
        Queue<int[]> demon = new ArrayDeque<>();
        Queue<int[]> suyeon = new ArrayDeque<>();
        for(int i=0; i<demons.size(); i++)
        	demon.add(demons.get(i));
        suyeon.add(new int[] {S_x, S_y});
        
        int count = 0;
        while(!suyeon.isEmpty()) {
        	 int su_size = suyeon.size();
        	 int de_size = demon.size();
        	 
        	 count += 1;
        	 
        	 while(de_size --> 0) { // 악마 4방 확인하고 보내기
        		 int out[] = demon.poll();
        		 int x = out[0];
        		 int y = out[1];
        		 
        		 
        		 for(int d=0; d<4; d++) {
        			 int nx = x + dx[d];
        			 int ny = y + dy[d];
        			 
        			 if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        			 if(map[nx][ny] == '.' || map[nx][ny] == 'S') {
        				 map[nx][ny] = '*';
        				 demon.add(new int[] {nx,ny});
        			 }
        		 }
        	 }
        	 while(su_size --> 0) { // 수연이 4방 확인하고 보내기
        		 int out[] = suyeon.poll();
        		 int x = out[0];
        		 int y = out[1];
        		 
        		 for(int d=0; d<4; d++) {
        			 int nx = x + dx[d];
        			 int ny = y + dy[d];
        			 
        			 if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        			 if(map[nx][ny] == 'D') {
        				 return String.valueOf(count);
        			 }
        			 if(map[nx][ny] == '.') {
        				 map[nx][ny] = 'S';
        				 suyeon.add(new int[] {nx,ny});
        			 }
        		 }
        	 }
        } // 더이상 빼낼 자리가 없음
        
        return "-1";
        
    }

}
