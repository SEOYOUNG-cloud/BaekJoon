import java.util.*;
import java.io.*;

public class Main_BJ_2108_통계학 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        double totalAvg = 0; // 산술평균
        int middle = arr[N/2]; // 중앙값
        int often = 0; // 최빈값
        int range = arr[N-1] - arr[0]; // 범위

        Map<Integer, Integer> oftenMap = new HashMap<>();
        for(int i=0; i<N; i++){
            // 산술평균
            totalAvg += arr[i];
            if(!oftenMap.containsKey(arr[i])) oftenMap.put(arr[i], 0);
            oftenMap.put(arr[i], oftenMap.get(arr[i]) + 1);
        }
        int comp = Integer.MIN_VALUE;
        ArrayList<Integer> maxList = new ArrayList<>();
        for(int key : oftenMap.keySet()){
            int value = oftenMap.get(key);
            if(value > comp){
                maxList.clear();
                maxList.add(key);
                comp = value;
            } else if(value == comp){
                maxList.add(key);
            }
        }
        if(maxList.size() == 1) often = maxList.get(0);
        else{
            Collections.sort(maxList);
            often = maxList.get(1);
        }

        String totalAvgPrt = String.format("%.0f", totalAvg/N);
        if(totalAvgPrt.equals("-0")) totalAvgPrt = "0";

        System.out.println(totalAvgPrt);
        System.out.println(middle);
        System.out.println(often);
        System.out.println(range);
    }
}
