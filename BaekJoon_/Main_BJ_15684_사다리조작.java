package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_15684_사다리조작 {
    
    static int N,M, H;
    static int map[][];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로줄
        M = Integer.parseInt(st.nextToken()); // 가로선
        H = Integer.parseInt(st.nextToken()); // 가로선을 놓을 수 있는 위치 개수
        
        map = new int[H][N];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            map[a-1][b-1] = 1; // 오른쪽으로
            map[a-1][b] = 2; // 왼쪽으로
        }
//        for(int i=0; i<H; i++)
//            System.out.println(Arrays.toString(map[i]));

//        System.out.println(check());
        for(int i=0; i<=3; i++) {
        	dfs(0, i, 0);
        }
        System.out.println("-1");
        
    }
    private static void dfs(int cnt, int total, int i) {
    	if(cnt == total) {
    		if(check()) {
    			System.out.println(cnt);
    			System.exit(0);
    		}
    		return;
    	}
    	
    	for(int x=i; x<H; x++) {
    		for(int y=0; y<N-1; y++) {
	    		if(map[x][y] == 0 && map[x][y+1] == 0) { // 사다리가 놓여있지 않으면
	    			map[x][y] = 1;
	    			map[x][y+1] = 2;
	    			dfs(cnt+1, total,x);
	    			map[x][y] = 0; 
	    			map[x][y+1] = 0;
	    		}
    		}
    	}
    }
    // i -> i인지 체크
    private static boolean check() {
    	for(int i=0; i<N; i++) {
    		int x = 0; // 가로줄
    		int y = i; // 세로줄 시작점
    		for(int j=0; j<H; j++) { 
    			if(map[x][y] == 1) y+=1;
    			else if(map[x][y] == 2) y -= 1;
    			x += 1;
    		}
    		
    		if(y != i) {
//    			System.out.println(i+"번째에서 ㄴㄴ" + " " + y);
    			return false;
    		}
    	}
    	return true;
    }
}