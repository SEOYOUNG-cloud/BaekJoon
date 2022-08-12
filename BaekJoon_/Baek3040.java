package Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek3040 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input[] = new int[9];
		
		for(int i = 0; i < 9; i++)
			input[i] = Integer.parseInt(br.readLine());
		
		/////
		
		// 9개중에 7개 뽑아야하므로
		int isSelected[] = new int[9];
		for(int i = 0; i < 7; i++)
			isSelected[9-i-1] = 1;
		
		do {
//			System.out.println(Arrays.toString(isSelected));
			int total = 0, index=0;
			int num[] = new int[7];
			
			for(int i = 0; i < 9; i++) {
				if(isSelected[i] == 1) {
					total += input[i];
					num[index++] = input[i];
				}
			}

			if(total == 100) {
				for(int i = 0; i < 7; i++)
					System.out.println(num[i]);
				return;
			}

			
		} while(Next_Permutation(isSelected));
	}
	
	private static boolean Next_Permutation(int arr[]) {
		int i = 8;
		while(i > 0 && arr[i] <= arr[i-1]) i--;
		if(i==0) return false;
		
		int j = 8;
		while(arr[j] <= arr[i-1]) j--;
		swap(arr, j, i-1);
		
		int k = 8;
		while(i < k) {
			swap(arr, i, k);
			i++;
			k--;
		}
		
		return true;
		
	}

	private static void swap(int arr[], int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
