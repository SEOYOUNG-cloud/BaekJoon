package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2941 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt=0;
		int i=0;
		for(; i<str.length(); i++) {
			switch (str.charAt(i)) {
			case 'c':
				if(i+1 < str.length() && (str.charAt(i+1) == '=' || str.charAt(i+1) == '-')) {
					i+=1;
				}
				cnt+=1;
				break;
			case 'd':
				if(i+1 < str.length() && str.charAt(i+1) == '-') {
					i+=1;
				} else if(i+2 < str.length() && str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') {
					i+=2;
				}
				cnt+=1;
				break;
			case 'l':
				if(i+1 < str.length() && str.charAt(i+1) == 'j')
					i+=1;
				cnt+=1;
				break;
			case 'n':
				if(i+1 < str.length() && str.charAt(i+1) == 'j')
					i+=1;
				cnt+=1;
				break;
			case 's':
				if(i+1 < str.length() && str.charAt(i+1) == '=')
					i+=1;
				cnt+=1;
				break;
			case 'z':
				if(i+1 < str.length() && str.charAt(i+1) == '=')
					i+=1;
				cnt+=1;
				break;

			default:
				cnt+=1;
				break;
			}
		}
		
		System.out.println(cnt);

	}

}
