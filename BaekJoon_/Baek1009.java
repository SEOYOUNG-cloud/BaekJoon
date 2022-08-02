package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek1009 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int ans = 1;
            while(b --> 0)
                ans = ans * a % 10;
            
            if(ans == 0) ans=10;
            bw.write(ans + "\n");            
        }
        bw.flush();
        bw.close();
        
    }
    
}
