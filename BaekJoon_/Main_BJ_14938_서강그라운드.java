import java.util.*;
import java.io.*;

public class Main_BJ_14938_서강그라운드 {

    static class Edge implements Comparable<Edge>{
        int V, weight;

        public Edge(int v, int weight) {
            V = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "V=" + V +
                    ", weight=" + weight +
                    '}';
        }
    }

    static int n,m,r;
    static int[] item;
    static ArrayList<Edge>[] road;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 지역의 개수 (1~100) = V
        m = Integer.parseInt(st.nextToken()); // 수색 범위 (1~15)
        r = Integer.parseInt(st.nextToken()); // 길의 개수(1~100) = E

        item = new int[n+1]; // 각 구역에 있는 아이템 수(1~30)
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
            item[i] = Integer.parseInt(st.nextToken());

        road = new ArrayList[n+1];
        for(int i=0; i<=n; i++)
            road[i] = new ArrayList<>();

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 지역번호 a
            int b = Integer.parseInt(st.nextToken()); // 지역번호 b
            int l = Integer.parseInt(st.nextToken()); // 길의 길이 l

            road[a].add(new Edge(b, l));
            road[b].add(new Edge(a, l));
        }
        

        /* 입력 끝! 다익스트라 구현 */
        for(int i=1; i<=n; i++){
            dijkstra(i);
        }
        System.out.println(answer);

    }

    static int answer = 0;
    private static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[n+1];
        pq.add(new Edge(start, 0));
        Arrays.fill(dist, 1000000);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge out = pq.poll();
            int nowV = out.V;
            int nowWeight = out.weight;

            if(dist[nowV] < nowWeight) continue;
            for(int i=0; i<road[nowV].size(); i++){
                int nextV = road[nowV].get(i).V;
                int nextWeight = road[nowV].get(i).weight;

                if(dist[nextV] > dist[nowV] + nextWeight){
                    dist[nextV] = dist[nowV] + nextWeight;
                    pq.add(new Edge(nextV, nextWeight));
                }

            }
        }

        /* 다익스트라 구현 끝 */
        int total = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] <= m) total += item[i];
        }

        answer = Math.max(answer, total);

    }
}
