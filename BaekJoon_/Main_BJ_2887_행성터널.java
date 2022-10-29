package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_2887_행성터널 {
    
    static int N;
    static int[][] map;

    
    static class Edge implements Comparable<Edge>{
        int from, to, weight;

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][4];
        for(int i=0; i<N; i++)
            map[i][0] = i;
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 입력 끝 //
//        System.out.println(Arrays.deepToString(map));
        pq = new PriorityQueue<>();
        
        // 1.x,y,z 좌표마다 정렬하고 인접한 애들끼리 
        Arrays.sort(map, (a,b) ->{
        	return Integer.compare(a[1], b[1]);
        });
        for(int i=0; i<N-1; i++) {
            // x 좌표별로 정렬
        	pq.add(new Edge(map[i][0],map[i+1][0], Math.abs(map[i][1]-map[i+1][1])));
        }
        
        Arrays.sort(map, (a,b) ->{
        	return Integer.compare(a[2], b[2]);
        });
        for(int i=0; i<N-1; i++) {
        	// y 좌표
            pq.add(new Edge(map[i][0],map[i+1][0], Math.abs(map[i][2]-map[i+1][2])));
        }
        
        Arrays.sort(map, (a,b) ->{
        	return Integer.compare(a[3], b[3]);
        });
        for(int i=0; i<N-1; i++) {
            // z 좌표 
            pq.add(new Edge(map[i][0],map[i+1][0], Math.abs(map[i][3]-map[i+1][3])));
        }
        
        // 2. MST
        make();
        
        int count = 0;
        int result = 0;
        while(true) {
        	Edge edge = pq.poll();
        	
        	if(union(edge.from, edge.to)) {
        		result += edge.weight;
        		if(++count == N-1) break;
        	}
        }
        
        System.out.println(result);
        
    }
    
    static int[] parents;
    static void make() {
    	parents = new int[N];
    	
    	for(int i=0; i<N; i++) {
    		parents[i] = i;
    	}
    }
    
    static int find(int a) {
    	if(parents[a] == a) {
    		return a;
    	}
    	return parents[a] = find(parents[a]);
    }
    
    static boolean union(int a, int b) {
    	int aRoot = find(a);
    	int bRoot = find(b);
    	
    	if(aRoot == bRoot) return false;
    	
    	if(aRoot < bRoot) {
    		parents[aRoot] = bRoot;
    	} else if(aRoot > bRoot) {
    		parents[bRoot] = aRoot;
    	}
    	
    	return true;
    }

}
