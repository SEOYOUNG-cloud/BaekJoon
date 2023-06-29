import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int n = park.length;
        int m = park[0].length();
        
        // 1. 시작 지점 찾기
        char[][] map = new char[n][m];
        int[] start = new int[2];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = park[i].charAt(j);
                if(map[i][j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        // 2. 길 가기!
        for(int i=0; i<routes.length; i++){
            String[] cmd = routes[i].split(" ");
            char dir = cmd[0].charAt(0);
            int cnt = Integer.parseInt(cmd[1]);
                        
            int x = start[0];
            int y = start[1];
            A: switch(dir){
                case 'N': // 북쪽으로 이동
                    for(int d=1; d<=cnt; d++){
                        int nx = x-d;
                        if(nx < 0 || map[nx][y] == 'X'){
                            break A;
                        }
                    }
                    start[0] -= cnt;
                    break;
                case 'S': // 남쪽으로 이동
                    for(int d=1; d<=cnt; d++){
                        int nx = x+d;
                        if(nx >= n || map[nx][y] == 'X'){
                            break A;
                        }
                    }
                    start[0] += cnt;
                    break;
                case 'E': // 동쪽으로 이동
                    for(int d=1; d<=cnt; d++){
                        int ny = y+d;
                        if(ny >= m || map[x][ny] == 'X'){
                            break A;
                        }
                    }
                    start[1] += cnt;
                    break;
                case 'W': // 서쪽으로 이동
                    for(int d=1; d<=cnt; d++){
                        int ny = y-d;
                        if(ny < 0 || map[x][ny] == 'X'){
                            break A;
                        }
                    }
                    start[1] -= cnt;
                    break;
                default:
                    break;
            }
            
        }
        
        return start;
    }
}