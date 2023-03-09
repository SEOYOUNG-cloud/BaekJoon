package BaekJoon;
import java.util.*;
import java.io.*;

public class Main_BJ_4195_친구네트워크 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            int n = Integer.parseInt(br.readLine());
            int idx = 0;
            fNumber = new HashMap<>();
            make(n);

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();
                int f1Num = -1, f2Num = -1;

                if (fNumber.containsKey(f1))
                    f1Num = fNumber.get(f1);
                else{
                    f1Num = idx;
                    fNumber.put(f1, idx++);
                }
                if (fNumber.containsKey(f2))
                    f2Num = fNumber.get(f2);
                else{
                    f2Num = idx;
                    fNumber.put(f2, idx++);
                }

                /* 설정 끝 */
                
                sb.append(union(f1Num, f2Num)).append('\n');
                
            }

        }
        System.out.println(sb.toString());


    }
    static int friend[];
    static int friendCnt[];
    static Map<String, Integer> fNumber;
    private static void make(int n){
        friend = new int[n*2+1];
        for(int i=0; i<n*2+1; i++){
            friend[i] = i;
        }
        friendCnt = new int[n*2+1];
        Arrays.fill(friendCnt, 1);
    }

    private static int union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

//        if(rootX == rootY) return false;
        if(rootX != rootY) {
	        friend[rootY] = rootX;
	        friendCnt[rootX]+=friendCnt[rootY];
	        friendCnt[rootY] = 1;
        }
        return friendCnt[rootX];
    }

    private static int find(int x){ // 부모 찾기
        if(friend[x] == x) return x;

        return friend[x] = find(friend[x]);
    }
}