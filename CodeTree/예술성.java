import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_CodeTree_예술성 {
    
    static int N;
    static int[][] map;
    static int[][] groupMap;
    static int[] order;
    static ArrayList<int[]>[] groupList;
    static int answer = 0;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        
//        for(int i=0; i<N; i++)
//            System.out.println(Arrays.toString(map[i]));
        
        ////// 입력 끝  ///////
        
        for(int tc=0; tc<4; tc++) {
        // 1. 그룹 나누기 -> BFS + 새로운 배열 생성
        groupMap = new int[N][N];
        MakeGroup(groupMap);
        
        
//        for(int i=0; i<N; i++)
//            System.out.println(Arrays.toString(groupMap[i]));
//        System.out.println();
        
        
//        for(int i=0; i<N; i++)
//        System.out.println(Arrays.toString(groupMap[i]));
//        System.out.println(cnt);
        
        // 2. 조화로움 구하기
        // 2-1) 만들어놓은 groupMap에서 각 그룹 수를 배열에 넣을거임
        groupList = new ArrayList[cnt+1];
        for(int i=0; i<=cnt; i++)
            groupList[i] = new ArrayList<>();
//        for(int i=0; i<N; i++)
//            System.out.println(Arrays.toString(groupMap[i]));
        
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                groupList[groupMap[i][j]].add(new int[] {i,j});
        
//        for(int i=1; i<=cnt; i++) {
//            for(int j=0; j<groupList[i].size(); j++)
//            System.out.print(groupList[i].get(j)[0] + "," + groupList[i].get(j)[1] + "  ");
//            System.out.println();
//        }
        // 2-2) 조합
        order = new int[2]; // 조합
        combination(0,1);
        
        // 3) 배열 돌리기
//        clone = new int[N][N];
        // 3-1) 십자가는 왼쪽으로 90도
        
        
        int middle = N/2;
        int arr1[] = new int[N];
        int arr2[] = new int[N];
        for(int i=0; i<N; i++) {
            arr1[i] = map[i][middle];
            arr2[i] = map[middle][(N-1)-i];
        }
        for(int i=0; i<N; i++) {
            map[middle][i] = arr1[i];
            map[i][middle] = arr2[i];
        }
        
        
        
//        for(int i=0; i<N; i++)
//        System.out.println(Arrays.toString(map[i]));
        
        // 3-2) 십자 제외 정사각형은 오른쪽으로 90도
        
        int line = N/2;
        rotate(0,0,line);
        rotate(0,line+1, line);
        rotate(line+1, 0, line);
        rotate(line+1, line+1, line);
        		
        
//        for(int i=0; i<N; i++)
//            System.out.println(Arrays.toString(map[i]));
//        System.out.println();
        }
        System.out.println(answer);

    }
    
//    static int clone[][];
    private static void rotate(int y, int x, int size) {
    	int temp[][] = new int[size][size];
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                temp[i][j] = map[y+size-1-j][x+i];
            }
        }

        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                if(temp[i][j]==0) continue;
                map[y+i][x+j] = temp[i][j];
            }
        }
		
	}

	private static void combination(int count, int start) {
        if(count == 2) {
//            System.out.println(Arrays.toString(order));
            // 2-3) 맞닿는지 확인
            if(confAttach(order, groupMap)) {
//                System.out.println(Arrays.toString(order));
                // 2-4) 맞닿았을 경우 조화로움 구하기
                
                // 1) 칸의 수
                int kan1 = groupList[order[0]].size();
                int kan2 = groupList[order[1]].size();
                
                // 2) 그룹을 이루고 있는 숫자 값
                int num1 = map[groupList[order[0]].get(0)[0]][groupList[order[0]].get(0)[1]];
                int num2 = map[groupList[order[1]].get(0)[0]][groupList[order[1]].get(0)[1]];
                
                // 3) 맞닿아 있는 변의 수    
                int side = confAttachSide(order, groupMap, 0);
                
//                if(order[0] == 2 && order[1] == 4) {
//                System.out.println(confAttachSide(order, groupMap, 0));
//                }
                
//                System.out.println(order[0] + " " + order[1] + "일 때");
//                System.out.println("칸의 수: " + kan1 + ", " + kan2);
//                System.out.println("그룹을 이루는 숫자: " + num1 + ", " + num2);
//                System.out.println("맞닿은 변 수: " + side);
//                System.out.println((kan1 + kan2) * num1 * num2 * side);
//                System.out.println();
                
                answer += ((kan1 + kan2) * num1 * num2 * side);
                
                
                
            }
            return;
        }
        
        for(int i=start; i<=cnt; i++) {
            order[count] = i;
            combination(count + 1, i+1);
        }
        
    }
    
    // 맞닿아 있는 변의 수 구하기
    private static int confAttachSide(int[] order, int[][] group, int side) {
        int group1 = order[0];
        int group2 = order[1];
        
        for(int i=0; i<groupList[group1].size(); i++) {
            int x = groupList[group1].get(i)[0];
            int y = groupList[group1].get(i)[1];
            
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(groupMap[nx][ny] == group2) {
                    side += 1;
                }
            }
        }
        
        return side;
        
    }

    // 두 그룹이 맞닿는지 확인
    private static boolean confAttach(int[] order, int[][] group) {
        int group1 = order[0];
        int group2 = order[1];
        
        for(int i=0; i<groupList[group1].size(); i++) {
            int x = groupList[group1].get(i)[0];
            int y = groupList[group1].get(i)[1];
            
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(groupMap[nx][ny] == group2) {
                    return true;
                }
            }
        }
        
        return false;
        
    }

    // 그룹 만들기
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int cnt;
    
    private static void MakeGroup(int[][] group) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0,0}); // 처음에 0,0 부터 시작
        visited[0][0] = true;
        
        cnt=1;
        while(!queue.isEmpty()) {
            int[] out = queue.poll();
            int x = out[0];
            int y = out[1];
            
            group[x][y] = cnt;
            
            for(int d=0; d<4; d++) {
            	
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[x][y] != map[nx][ny]) continue;
                    visited[nx][ny] = true;
                    group[nx][ny] = cnt;
                    queue.add(new int[] {nx,ny});
            }
            
            if(queue.isEmpty()) {
                A: for(int i=0; i<N; i++)
                    for(int j=0; j<N; j++) {
                        if(!visited[i][j]) {
                        	visited[i][j] = true;
                            queue.add(new int[] {i,j});
                            cnt += 1;
                            break A;
                        }
                    }
            }
        }

        
    }
    
}