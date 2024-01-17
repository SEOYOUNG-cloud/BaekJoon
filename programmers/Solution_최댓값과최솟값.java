package programmers;

import java.io.*;
import java.util.*;

public class Solution_최댓값과최솟값 {

public String solution(String s) {
        int array[] = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);

        StringBuilder answer = new StringBuilder();
        answer.append(array[0]).append(' ').append(array[array.length - 1]);

        return answer.toString();
    }
}
