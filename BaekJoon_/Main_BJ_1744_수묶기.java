package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_1744_수묶기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> positiveNum = new ArrayList<>();
		ArrayList<Integer> negativeNum = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int in = Integer.parseInt(br.readLine());
			if(in > 0) {
				positiveNum.add(in);
			} else {
				negativeNum.add(in);
			}
		}
		
		/* 입력 끝 */
		Collections.sort(positiveNum, Collections.reverseOrder());
		Collections.sort(negativeNum);
		
		int pos = 0;
		int posSize = positiveNum.size();
		for(int i=0; i<posSize-1; i+=2) {
			int pre = positiveNum.get(i);
			int suf = positiveNum.get(i+1);
			if(pre == 1 || suf == 1) {
				pos += pre;
				i-=1;
				continue;
			}
			pos += pre * suf;
		}
		if(posSize != 0 && (posSize % 2 != 0 || positiveNum.get(posSize-1) == 1)) pos += positiveNum.get(posSize-1);
		
		int neg = 0;
		for(int i=0; i<negativeNum.size()-1; i+=2) {
			neg += negativeNum.get(i) * negativeNum.get(i+1);
		}
		if(negativeNum.size() != 0 && negativeNum.size() % 2 != 0) neg += negativeNum.get(negativeNum.size()-1);
		
		System.out.println(pos + neg);
		
	}

}
