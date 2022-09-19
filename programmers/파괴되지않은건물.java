import java.util.*;
class Solution {
    
    public int solution(int[][] board, int[][] skill) { 
        int answer = 0;
        int n = board.length; // 가로 길이
        int m = board[0].length; // 세로 길이
        int map[][] = new int[n+1][m+1]; // 누적합 할 배열 생성
        
        // 누적합을 위해 map에 표시
        for(int i=0; i<skill.length; i++){
            int d = skill[i][5] * (skill[i][0] == 1 ? -1 : 1);
            map[skill[i][1]][skill[i][2]] += d;
            map[skill[i][3]+1][skill[i][4]+1] += d;
            map[skill[i][1]][skill[i][4]+1] += d * (-1);
            map[skill[i][3]+1][skill[i][2]] += d * (-1);
        }
        
        // 세로합
        for(int i=0; i<m; i++)
            for(int j=1; j<n; j++)
                map[j][i] += map[j-1][i];
        
        // 가로 합
        for(int i=0; i<n; i++)
            for(int j=1; j<m; j++)
                map[i][j] += map[i][j-1];
        
        // map + board 값이 양수이면 +1
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(map[i][j] + board[i][j] > 0) answer += 1;
        
        return answer;
    }
}