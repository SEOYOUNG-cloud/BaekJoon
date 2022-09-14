import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        ArrayList<Integer> list = new ArrayList<>();
        // ArrayList<int[]> map = new ArrayList<>(); // 차번호, 입차시간, 출차시간, 총 주차시간
        int[][] map = new int[10000][3];
        boolean[] visited = new boolean[10000];
        for(int i=0; i<10000; i++)
            map[i][0] = -1;
        
        for(int i=0; i<records.length; i++){
            String[] record = records[i].split(" ");
            int number = Integer.parseInt(record[1]); // 차번호
            
            String[] time = record[0].split(":");
            int min = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            
            if(record[2].equals("IN")){
                map[number][0] = min;
                visited[number] = true;
            } else{ // 출차하는 차
                // 출차시간 - 입차시간 한거 map[i][2]에 더하자
                map[number][2] += min - map[number][0];
                map[number][0] = -1; // 입차 초기화
            }
        }
        int no_out = 23 * 60 + 59; // 23:59일 때 분
        
        for(int i=0; i<10000; i++){
            if(!visited[i] || map[i][0] == -1) continue; // 들어오지 않은 번호거나 출차해서 계산 안해도 되면 continue

            map[i][2] += no_out - map[i][0];

        }
        
        // 이제 map[][2] = 주차한 시간임
        
        for(int i=0; i<10000; i++){
            if(!visited[i]) continue;
            if((map[i][2] - fees[0]) <= 0) list.add(fees[1]); // 기본 시간보다 적으면 기본 요금
            else{ // 기본시간 초과
                list.add(fees[1] + (int)Math.ceil(((double)map[i][2] - (double)fees[0]) / (double)fees[2]) * fees[3]);
            }
        }
       for(int i=0; i<10000; i++){
            if(!visited[i]) continue;
           System.out.println(map[i][2]);
       }
        
        int idx = 0;
        int answer[] = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[idx++] = list.get(i);
        }
        return answer;
    }
}