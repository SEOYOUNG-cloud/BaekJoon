package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_BJ_7490_0만들기 {
    
    static int N;
    static char[] chr = {' ', '+', '-'};
    static char[] op;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=0; tc<T; tc++) {
            N = Integer.parseInt(br.readLine());
            op = new char[N-1];
            for(int i=0; i<N; i++) {
                
            }
            dfs(0);
            
            System.out.println();
        }

    }
    private static void dfs(int cnt) {
        if(cnt == N-1) {
            ArrayList<Integer> num = new ArrayList<>();
            ArrayList<Character> oper = new ArrayList<>();
            num.add(1);
            
            for(int i=0; i<N-1; i++) {
                //0:공, 1:+, 2:-
                if(op[i]==' ') {
                	int pre = num.get(num.size()-1);
                	num.remove(num.size()-1);
                	int now = pre*10 + (i+2);
                	num.add(now);
                }
                else if(op[i]=='+') {
                    oper.add('+');
                    num.add(i+2);
                }
                else {
                    oper.add('-');
                    num.add(i+2);
                }
            }
            int answer = num.get(0);
            for(int i=0; i<oper.size(); i++) {
            	if(oper.get(i) == '+')
            		answer += num.get(i+1);
            	else
            		answer -= num.get(i+1);
            }
            if(answer == 0) {
            	System.out.print("1");
            	for(int i=2; i<=N; i++) {
            		System.out.print(op[i-2] + ""+i);
            	}
            	System.out.println();
            }
            return;
        }
        for(int i=0; i<3; i++) {
            op[cnt] = chr[i];  
            dfs(cnt+1);
        }
    }

}
