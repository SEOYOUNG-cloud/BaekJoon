package BaekJoon;
 
import java.util.*;
import java.io.*;

// 1.must have: antic
// -> K >= 5, else: return 0


public class Main_BJ_1062_가르침 {
	
	static String str[] = {"b","d","e","f","g","h","j","k","l","m","o","p","q","r","s","u","v","w","x","y","z"};
	static int N,K;
	static String in[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		in = new String[N];
		for(int i=0;i <N; i++) {
			String r = br.readLine();
			r = r.substring(4, r.length()-4);
			in[i] = r;
		}
		set.add("a");
		set.add("n");
		set.add("t");
		set.add("i");
		set.add("c");
		
		comb(0,0);
		System.out.println(answer);

	}
	static int answer=0;
	static Set<String> set = new HashSet<>();
	private static void comb(int cnt, int start) {
		if(cnt == K-5) {
			answer = Math.max(answer, conf());
			return;
		}
		
		for(int i=start; i<21; i++) {
			set.add(str[i]);
			comb(cnt+1, i+1);
			set.remove(str[i]);
		}
	}
	
	private static int conf() {
		int cnt = 0;
		
		A: for(int i=0; i<N; i++) {
			char out[] = in[i].toCharArray();
			
			for(int j=0; j<out.length; j++) {
				// 하나씩 훑으면서 들어있는지 확인 
				if(!set.contains(String.valueOf(out[j]))){
					continue A;
				}
			}
			cnt ++;
		}
		
		return cnt;
	}

}
