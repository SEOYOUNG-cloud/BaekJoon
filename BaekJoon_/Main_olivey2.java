package test;

import java.util.*;
import java.io.*;

public class oliveyoung2 {

	public static void main(String[] args) throws Exception {
		String[] kor = {"AAA", "BCD", "AAAAA", "ZY"};
		String[] usa = {"AB", "AA", "TTTT"};
		String[] incs = {"AB BCD AA AAA TTTT AAAAA", "BCD AAA", "AB AAA TTTT BCD", "AA AAAAA AB", "AAA AB BCD"};
		
		int korLength = kor.length;
		int usaLength = usa.length;
		int[][] arr = new int[korLength][usaLength];
		Map<String, Integer> korMap = new HashMap<>();
		Map<String, Integer> usaMap = new HashMap<>();
		
		for(int i=0, idx=0; i<korLength; i++) {
			korMap.put(kor[i], idx++);
		}
		for(int i=0, idx=0; i<usaLength; i++) {
			usaMap.put(usa[i], idx++);
		}
		
		//
		int answer = 0;
		for(int i=0; i<incs.length; i++) {
			String[] in = incs[i].split(" ");
			ArrayList<Integer> korList = new ArrayList<>();
			ArrayList<Integer> usaList = new ArrayList<>();
			
			for(int j=0; j<in.length; j++) {
				if(korMap.get(in[j]) != null) { // 한국어면
					korList.add(korMap.get(in[j]));
				} else {
					usaList.add(usaMap.get(in[j]));
				}
			}
			// 다넣었다
			for(int k=0; k<korList.size(); k++) { // 한국어 훑으면서
				for(int u=0; u<usaList.size(); u++) { // usa 훑어..
					arr[korList.get(k)][usaList.get(u)] += 1;
					answer = Math.max(arr[korList.get(k)][usaList.get(u)], answer);
				}
				
			}
		}
		
		System.out.println(answer);
	}

}
