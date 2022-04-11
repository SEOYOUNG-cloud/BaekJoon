package BeakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Baek1987 {
	public static String map[][];
	public static HashSet<String> hash = new HashSet<>();
	public static int R = 0, C = 0, answer = 0;
	public static int dx[] = {1, -1, 0, 0};
	public static int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new String[R][C];
		
		for(int i = 0; i < R; i++) {
			String in = br.readLine();
			for(int j = 0; j < C; j++)
				map[i][j] = String.valueOf(in.charAt(j));
		}
		
//		map�� char �������� ����� ���ϰ� �迭�� ���� ���� �ִ�.
//		for(int i = 0; i < R; i++)
//            map[i] = br.readLine().toCharArray();
			
		hash.add(map[0][0]);
		dfs(0,0,1);
		System.out.println(answer);
		
		
	}
	
	public static void dfs(int x, int y, int count) {

		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx <= -1 || nx >= R || ny <= -1 || ny >= C) continue;

			if(hash.contains(map[nx][ny])) { // ���ĺ� �����ϸ� max ã��
				answer = Math.max(answer, count);
			} else { // ���� ���ϸ�
				hash.add(map[nx][ny]);
				dfs(nx, ny, count + 1);
				hash.remove(map[nx][ny]); // dfs �� �ϰ� �Ųٷ� ������ �� remove��
			}
			
		}
		
	}

}
