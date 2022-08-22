package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1759 {

	static int L,C;
	static char[] str, mix;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		str = new char[C];
		mix = new char[L];
		for(int i=0; i<C; i++)
			str[i] = st.nextToken().charAt(0);
		Arrays.sort(str);
		
		comb(0,0,0);
		System.out.println(sb);
		
		br.close();
	}
	private static void comb(int cnt, int start, int flag) {
		if(cnt == L) {
			calcul(mix);
			return;
		}
		for(int i=start; i<C; i++) {
			if((flag & 1<<i) != 0) continue;
			mix[cnt] = str[i];
			
			comb(cnt+1, i+1, (flag | 1<<i));
		}
	}
	private static void calcul(char[] mix) {
		int z = 0; // 자음
		int m = 0; // 모음 (a,e,i,o,u)
		
		for(int i=0; i<mix.length; i++) {
			if(mix[i] == 'a' || mix[i] == 'e' || mix[i] == 'i' || mix[i] == 'o' || mix[i] == 'u')
				m += 1;
			else z+=1;
		}
		
		if(z >= 2 && m >= 1)
			sb.append(mix).append('\n');
		
	}
	
}
