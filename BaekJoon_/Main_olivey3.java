package test;

import java.util.*;
import java.io.*;

public class oliveyoung1 {

	public static void main(String[] args) throws Exception {
		String number = "100";
		int length = number.length();
		
		ArrayList<Integer> list = new ArrayList<>();
		int idx = 0;
		int answer = 0;
		while(idx < length) {
			answer += 1;
			char next = number.charAt(idx); // 다음에 나와야하는 숫자
			if(next != '0') { // 0이 아니라면
				list.add(next - '0');
				list.add(next - '0'+1);
			} else{
				list.add(0);
			}
			//
//			System.out.println(idx);
//			System.out.println(list);
			
			if(list.size() > length) {
				answer += 1;
				break;
			}
			
			if(next != '0' && list.get(list.size()-1) == number.charAt(list.size()-1)-'0') {
				idx += 2;
			} else if(next == '0'){
				idx += 1;
			} else {
				answer += 1;
				list.remove(list.size()-1);
				idx += 1;
			}
		}
		
		System.out.println(answer);

	}

}
