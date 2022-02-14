package algorithm;

import java.util.*;

class Solution { // 순열, 소수찾기
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        permutation("", numbers);
        
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            int a = it.next();
            if(prime(a)) answer++;
        }
         
        
        return answer;
    }
    public void permutation(String prefix, String str){
        int n = str.length();
        if(!prefix.equals("")){
            set.add(Integer.valueOf(prefix));
        }
        for(int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
    }
    
    public boolean prime(int a){
        if(a==0 || a==1) {
    return false;
  }
  else {
    for(int i=2;i<=Math.sqrt(a);i++)
      if(a%i==0)   return false;
  }
  return true;
    }
}
