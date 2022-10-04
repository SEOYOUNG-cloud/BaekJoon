import java.util.*;
class Solution {
    /* DFS 백트래킹 */
    /*
    1. 점수 10점부터 어피치를 이길 수 있도록 점수 분배
    2. 분배 후 우승했다면 점수 저장
    3. 백트래킹으로 다른 점수를 이기는 점수로 탐색
    ... 반복
    4. 같은 점수라면 list에 저장하기
    5. list를 탐색하면서 2개 이상일 시 낮은 점수가 많은 점수 선택
    */
    static int score = 0;
    static int[] answer = new int[11];
    public int[] solution(int n, int[] info) {
        
        int[] lion = new int[11];
        dfs(info, lion, 0,n,0);
        
        if(Arrays.equals(answer,new int[]{0,0,0,0,0,0,0,0,0,0,0})) return new int[]{-1};
        return answer;
    }
    
    // 중복조합
    private static void dfs(int[] apch, int[] lion, int cnt, int n, int start){
        if(cnt == n){
            
            cal_score(apch, lion);
            
            return;
        }
        
        for(int i=start; i<=10; i++){
            lion[i] += 1;
            dfs(apch, lion, cnt+1, n, i);
            lion[i] -= 1;
        }
        
    }
    // 점수 계산하기
    private static void cal_score(int[] apch, int[] lion){
        int ap = 0;
        int li = 0;
        for(int i=0; i<=10; i++){
            if(apch[i] !=0 || lion[i] != 0){ // 둘 다 0이면 점수x
                if(apch[i] >= lion[i]) ap += (10-i);
                else 
                    li += (10-i);
            }
        }
        if(li-ap <= 0) return;
        
        if(li - ap > score){ // 라이언 점수가 원래 score보다 크면 answer 갱신
            answer = lion.clone();
            score = li - ap;
        } else if(li - ap == score){ // 라이언 점수가 score와 같다면 낮은 점수가 많은걸로 갱신
            for(int i=10; i>=0; i--){
                if(answer[i] != lion[i]){
                    if(answer[i] < lion[i]){
                        answer = lion.clone();
                        break;
                    }
                    break;
                }
            }
        }
    }
}