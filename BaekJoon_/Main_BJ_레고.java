package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_레고 {
	public static void main(String[] args) {
		String[] wall = new String[3];
		System.out.println(solution(wall));
	}
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static public int[][] solution(String[] wall) {
        Map<Integer, Node> list = new HashMap<>();

        int r=wall.length;
        String[] cSize = wall[0].split(" ");
        int c=0;
        for(int i=0; i<cSize.length; i++)
            c+=Integer.parseInt(cSize[i]);

        for(int i=0; i<wall.length; i++){
            String[] out = wall[i].split(" ");
            int yIdx = 0;
            for(int j=0, idx=0; j<out.length; j++){
                for(int k=0; k<Integer.parseInt(out[j]); k++){
                    int key = i*10000 + idx++;
                    list.put(key, new Node(i, yIdx));
                }
                yIdx++;
            }
        }

        ///////////입력 끝////////////
        // map 돌면서 근처 좌표 숫자세기
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        // 해당좌표가 i, yIdx거든..긍까 출력해야하는거
        // 현재좌표는 i, idx임
        Set<Integer> set = new HashSet<>();

        ArrayList<Integer> an = new ArrayList<>();
        int maxCnt = 0;

        for(int i=0; i<r; i++){
            String[] out = wall[i].split(" ");
            int yIdx = 0;
            for(int j=0, idx=0; j<out.length; j++){
                int key = i*10000 + j;
                for(int k=0; k<Integer.parseInt(out[j]); k++){
                    int x = i;
                    int y = idx++;

                    for(int d=0; d<4; d++){
                        int nx = x+dx[d];
                        int ny = y+dy[d];
                        if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;

                        int nextKey = nx*10000 + ny;
                        Node nextValue = list.get(nextKey);
                        int nextX = nextValue.x;
                        int nextY = nextValue.y;
                        int next = nextX*10000 + nextY;

                        if(next != key) set.add(next);
                    }
                }
                if(maxCnt < set.size()){
                    maxCnt = set.size();
                    an.clear();
                    an.add(key);
                } else if(maxCnt == set.size()){
                    an.add(key);
                }
                set.clear();
                yIdx++;
            }
        }
        int[][] answer = new int[an.size()][2];

        for(int i=0; i<an.size(); i++){
            int x = an.get(i)/10000;
            int y = an.get(i) - x*10000;

            answer[i][0] = x;
            answer[i][1] = y;
        }
       
    
        return answer;
	    
	}
}
