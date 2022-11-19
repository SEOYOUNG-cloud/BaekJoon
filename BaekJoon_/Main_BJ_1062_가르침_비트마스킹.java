package BaekJoon;

import java.util.*;
import java.io.*;

// 1.must have: antic
// -> K >= 5, else: return 0

public class Main_BJ_1062_가르침_비트마스킹 {

	static int N, K;
	static String in[];
	static int flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		in = new String[N];
		for (int i = 0; i < N; i++) {
			String r = br.readLine();
			r = r.substring(4, r.length() - 4);
			in[i] = r;
		}
		flag = 0;
		flag = (flag | (1 << ('a' - 'a')));
		flag = (flag | (1 << ('n' - 'a')));
		flag = (flag | (1 << ('t' - 'a')));
		flag = (flag | (1 << ('i' - 'a')));
		flag = (flag | (1 << ('c' - 'a')));

		comb(0, 0, flag);
		System.out.println(answer);

	}

	static int answer = 0;

	private static void comb(int cnt, int start, int flag) {
		if (cnt == K - 5) {
			answer = Math.max(answer, conf(flag));
			return;
		}

		for (int i = start; i < 26; i++) {
			if ((flag & (1 << i)) != 0) // 해당 자리가 1인지 확인 
				continue;
			comb(cnt + 1, i + 1, flag | (1 << i)); // 해당 자리에 1 넣고 돌리기 
		}
	}

	private static int conf(int f) {
		int cnt = 0;

		A: for (int i = 0; i < N; i++) {
			for (int j = 0; j < in[i].length(); j++) {
				// 하나씩 훑으면서 들어있는지 확인
				if ((f & (1 << (in[i].charAt(j)-'a'))) == 0) {
					continue A;
				}
			}
			cnt++;
		}

		return cnt;
	}

}
