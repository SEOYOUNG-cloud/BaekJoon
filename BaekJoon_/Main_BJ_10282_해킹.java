import java.util.*;
import java.io.*;

public class Main_BJ_10282_해킹 {

    static class Node implements Comparable<Node>{
        int idx, weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테케 개수
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터의 개수 = V
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수 = E
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터의 번호 = start number

            // 관계를 담을 배열 생성
            ArrayList<Node>[] arr = new ArrayList[n+1];
            for(int i=1; i<=n; i++)
                arr[i] = new ArrayList<>();

            // 배열에 담기
            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken()); // s초 후 감염된다.

                arr[b].add(new Node(a, s)); // 단방향, b에 의존하는 a가 감염되는 것이므로 화살표 반대로
            }

            /* 입력 끝 */

            /* 다익스트라 구현 */
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(c, 0));
            int[] dist = new int[n+1];
            Arrays.fill(dist, 1000000001);
            dist[c] = 0;

            while(!pq.isEmpty()){
                Node out = pq.poll();
                int nowV = out.idx;
                int nowW = out.weight;

                if(dist[nowV] < nowW) continue;
                for(int i=0; i<arr[nowV].size(); i++){
                    int nextV = arr[nowV].get(i).idx;
                    int nextW = arr[nowV].get(i).weight;

                    if(dist[nextV] > dist[nowV] + nextW){
                        dist[nextV] = dist[nowV] + nextW;
                        pq.offer(new Node(nextV, nextW));
                    }

                }
            }

            int computer = 0;
            int time = 0;
            for(int i=1; i<=n; i++){
                if(dist[i] != 1000000001){
                    computer += 1;
                    time = Math.max(time, dist[i]);
                }
            }

            sb.append(computer).append(" ").append(time).append('\n');
        }

        System.out.println(sb.toString());
    }
}
