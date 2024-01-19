package programmers;

import java.util.*;
import java.io.*;

public class Solution_최솟값만들기 {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int len = A.length;

        for(int i=0; i<len; i++){
            answer += A[i] * B[len - i-1];
        }

        return answer;
    }
}
