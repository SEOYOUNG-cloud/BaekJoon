package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기_박서영 { // BaekJoon 1244번
	static int sw;
	static int map[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sw = Integer.parseInt(br.readLine()); // 스위치 개수
		map = new int[sw]; // 스위치 상태
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < sw; i++)
			map[i] = Integer.parseInt(st.nextToken()); // 스위치 상태 저장
		
		int tc = Integer.parseInt(br.readLine()); // 학생 수
		
		for(int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken()); // 성별
			int num = Integer.parseInt(st.nextToken()); // 받은 수, 스위치 인덱스가 0부터 이므로 인덱스 사용하면 -1 해줘야함
			
			if(sex == 1)
				man(num); // 남자는 자기가 받은 수의 배수를 계산해야 하기 때문에 받은 수를 보냈음
			else 
				woman(num-1); // 여자는 map의 인덱스만 사용하므로 인덱스를 보냈음
		}

		for(int i = 0; i < map.length; i++) {
			if( i != 0 && i % 20 == 0) // 한줄에 20개씩 출력 ㅠㅠ
				System.out.println();
			System.out.print(map[i] + " ");
		}	

	}
	
	public static int switch_light(int light) {
		if(light == 1)
			return 0;
		else
			return 1;
	}
	
	public static void man(int num) {
		int i = 1;
		while(true) {
			int change_num = num * i;
			if(change_num-1 >= sw) // num이 스위치 개수보다 크면 멈춤
				break;
			
			map[change_num-1] = switch_light(map[change_num-1]); // 안크니까 스위치 바꿈
			i++; // 배수
		}
	}
	
	public static void woman(int num) {
		map[num] = switch_light(map[num]);
		int i = 1;
		while(true) {
			if(num-i < 0 || num+i >= sw || (map[num-i] != map[num+i]))
				break;
			
			map[num-i] = switch_light(map[num-i]);
			map[num+i] = switch_light(map[num+i]);
			i++;
			
		}
	}

}
