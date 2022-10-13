import java.util.*;
import java.io.*;

public class Main_CodeTree_술래잡기 {
    
    static class XYD{
        int x,y,d;

        public XYD(int x, int y, int d) {
            super();
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public String toString() {
            return "XYD [x=" + x + ", y=" + y + ", d=" + d + "]";
        }
        
    }
    
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] dxy = {{0,0},{0,1}, {0,-1}, {-1,0}, {1,0}};
    static int[][] map;
    static int n,m,h,k;
    static XYD[] sul;
    static List<XYD> runner;
    static Set<Integer> tree;
    static int answer = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        runner = new ArrayList<>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken());
            
            
            if(d==1) { // 좌우일 때 
                if(y == n-1) { // 끝에 도달했으면
                    d = 2;
                }
            } else { // 상하일 때 
                if(x == n-1)
                    d = 3;
                else
                    d = 4;
                
            }
            //1: 오른쪽, 2: 왼쪽, 3: 상, 4: 하
            runner.add(new XYD(x, y, d));
        }
        
        tree = new HashSet<>();
        for(int i=0; i<h; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            
            int key = x*100+y;
            tree.add(key);
        }
        
        // 입력 끝 // 
        
        Sul(); // 턴마다 술래가 어디에 있을지 미리 계산해놓음 가운데 -> 0,0 -> 가운데 까지의 배열 만들기
        
        int sulX = n/2;
        int sulY = n/2;
        
        for(int turn=1; turn<=k; turn++) {
        
        // 도망자들 훑자 
        for(int i=0; i<runner.size(); i++) {
            int runnerX = runner.get(i).x; // 도망자 x
            int runnerY = runner.get(i).y; // 도망자 y
            int dis = distance(runnerX, runnerY, sulX, sulY); // dis: 술래와의 거리 
                   
            // 3 이하이면 
            if(dis <= 3) {
                // 움직이기 
                int newRunnerX = runnerX + dxy[runner.get(i).d][0];
                int newRunnerY = runnerY + dxy[runner.get(i).d][1];
                
                // 술래 자리면 안움직임 
                if(newRunnerX == sulX && newRunnerY == sulY) continue;
                
                // 아니면 그쪽으로 옮기고 (list 안은 아직 안옮김) 
                runnerX = newRunnerX;
                runnerY = newRunnerY;
                
                // 도망자  업데이트 
                // d
                int newD = runner.get(i).d;
                if(newD == 1 || newD == 2) { // 왼오 
                    if(runnerY == 0 || runnerY == n-1) {
                        if(newD == 1) newD = 2;
                        else newD = 1;
                    }
                } else { // 상 하 
                    if(runnerX == 0 || runnerX == n-1) {
                        if(newD == 3) newD = 4;
                        else newD = 3;
                    }
                    
                }
                
                runner.set(i, new XYD(runnerX, runnerY, newD));
                
            }
        } // 도망자 훑기 끝 
        
        // 술래 잡을곳 set에 넣어놓을거임
        HashSet<Integer> set = new HashSet<>();
        int index = turn%(n*n*2-2);
        int x = sul[index].x; // 술래의 x좌표 
        int y = sul[index].y; // 술래의 y좌표 
        int d = sul[index].d; // 술래의 현재 방향 
        
        int key = x*100+y;
        set.add(key);
        A: while(true) {
        	if(set.size() >= 3) break; // 3칸만 넣기 가능
                x += dx[d];
                y += dy[d];
                
                if(x < 0 || x >= n || y < 0 || y >= n) break A;
                
                key = x*100+y;
                set.add(key);

        }     
        // 자리 옮긴 도망자들 다시 훑으면서 점수 계산하고 kill 
        int r=0;
        int catched = 0;
        for(r=0; r<runner.size(); r++) {
            int runnerX = runner.get(r).x;
            int runnerY = runner.get(r).y;
            
            // 술래에게 잡힐 수 있는 자리에 있다면 
            int RunnerKey = runnerX*100+runnerY;

            if(set.contains(RunnerKey)) {
                if(!tree.contains(RunnerKey)) {

                    // 나무도 없는 곳이야 그러면                 
                    runner.remove(r); // 없애고 
                    catched += 1;
                    r -= 1;
                }
            }
        }
        
        
        
        // 점수 계산 
        answer += turn * catched;
        
        sulX = sul[index].x;
        sulY = sul[index].y;
         
    }     
        System.out.println(answer);
        
    }
    
    // 거리 재기 
    private static int distance(int x, int y, int x2, int y2) {
        return Math.abs(x-x2) + Math.abs(y-y2);
    }

    private static void Sul() {
        int d = 0;
        int x = n/2;
        int y = n/2;
        
        // d %= 4;
        int idx = 1;
        sul = new XYD[2*n*n-2];
        sul[0] = new XYD(x, y, d%4);
        
        int cnt;
        
        for(cnt=1; cnt<n; cnt++) {
            for(int i=0; i<2; i++) {
                for(int c=0; c<cnt; c++) {
                    x += dx[d%4];
                    y += dy[d%4];
                    
                    if(c == cnt-1) {}
                    else
                        sul[idx++] = new XYD(x, y, (d)%4);
                }
                d += 1;
                sul[idx++] = new XYD(x, y, (d)%4);
                
            }
        }
        
        // 마지막 줄
        for(int c=0; c<cnt-2; c++) {
            x+= dx[d%4];
            y += dy[d%4];
            sul[idx++] = new XYD(x, y, d%4);
            
        }
        
        // 0,0 에서 반대방향으로
        int order[] = {2,1,0,3};
        x=0; y=0;
        d = 0;
        for(int c=0; c<cnt-1; c++) {
        	
        	sul[idx++] = new XYD(x, y, order[d%4]);
            x+= dx[order[d%4]];
            y += dy[order[d%4]];
            
        }
        
        d=1;
        cnt-=1;
        for(;cnt>0; cnt--) {
        	for(int i=0; i<2; i++) {
        		for(int c=0; c<cnt; c++) {
	        		sul[idx++] = new XYD(x, y, order[d%4]);
	                x+= dx[order[d%4]];
	                y += dy[order[d%4]];
        		}
        		d+=1;
        	}
        	
        }

    }

}