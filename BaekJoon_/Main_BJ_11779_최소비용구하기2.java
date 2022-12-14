package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_11779_최소비용구하기2 {
    static class Node{
        int idx, cost;

        public Node(int idx, int cost) {
            super();
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // V
        int m = Integer.parseInt(br.readLine()); // E
        StringTokenizer st;
        
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for(int i=0; i<n+1; i++)
            graph.add(new ArrayList<>());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph.get(from).add(new Node(to, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        ///////
        int[] dist = new int[n+1];
        for(int i=0; i<=n; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[start] = 0;
        
        // 바로 이전 정점을 담을 배열 생성!
        int[] pre = new int[n+1];
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(now.idx == end) {
                System.out.println(dist[end]);
                break;
            }
            
            if(now.cost > dist[now.idx]) continue;
            
            for(int i=0; i<graph.get(now.idx).size(); i++) {
                Node next = graph.get(now.idx).get(i);
                
                if(dist[next.idx] > now.cost + next.cost) {
                    dist[next.idx] = now.cost + next.cost;
                    pre[next.idx] = now.idx;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(true) {
        	if(pre[end] == 0) break;
        	list.add(end);
        	
        	end = pre[end];
        	
        }
        list.add(start);
        
        System.out.println(list.size());
        for(int i=list.size()-1; i>=0; i--) {
        	System.out.print(list.get(i) + " ");
        }
    }
}
