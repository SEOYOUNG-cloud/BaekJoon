package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class night{
	int x, y;
	public night(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {return this.x;}
	public int getY() {return this.y;}
}

public class Baek7562 {
	public static int T, I;
	public static int now[] = new int[2];
	public static int fin[] = new int[2];
	public static int ans[];
	public static int count[][];
	public static int dx[] = {1, 1, -1, -1, 2, 2, -2, -2};
	public static int dy[] = {2, -2, 2, -2, 1, -1, 1, -1};
	public static Queue<night> queue = new LinkedList<night>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		ans = new int[T];
		
		for(int i = 0; i < T; i++) {	
			I = Integer.parseInt(br.readLine());
			
			count = new int[I][I];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			now[0] = Integer.parseInt(st.nextToken());
			now[1] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			fin[0] = Integer.parseInt(st.nextToken());
			fin[1] = Integer.parseInt(st.nextToken());
			
			count[now[0]][now[1]] = 1;	
			
			if((now[0] == fin[0]) & (now[1] == fin[1])) ans[i] = 0;
			else {
				
				ans[i] = night_bfs(now[0], now[1]);
			}
			
			queue.clear();
		}
		
		for(int i = 0; i < T; i++)
			System.out.println(ans[i]);
	}
	
	public static int night_bfs(int x, int y) {
		queue.add(new night(x, y));
		
		while(!queue.isEmpty()) {
			night t = queue.remove();
			int tx = t.getX();
			int ty = t.getY();
			
			for(int i = 0; i < 8; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				if(nx <= -1 || nx >= I || ny <= -1 || ny >= I) continue;
				
				if((nx == fin[0]) & (ny == fin[1])) return count[tx][ty];
				if(count[nx][ny] == 0) {
					queue.add(new night(nx, ny));
					count[nx][ny] = count[tx][ty] + 1;
				}
			}
		}
		
		return -1;
	}

}
