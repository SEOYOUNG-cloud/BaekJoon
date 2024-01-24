package programmers;

import java.util.*;
import java.io.*;

public class Solution_올바른괄호 {

    boolean solution(String s) {
        char[] array = s.toCharArray(); Stack

        int n = 0;
        for(char arr : array){
            n += arr == '(' ? 1 : -1;
            if(n < 0) return false;
        }

        if(n == 0) return true;
        else return false;
    }
}
