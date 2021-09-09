package step_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_1_2750_Selection {

public static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// Selection Sort
		for(int i=0; i<n-1; i++ ) {
			int leastIndex = i;
			for(int j=i+1; j<n; j++ ) {
				if(arr[leastIndex] > arr[j]) {
					leastIndex = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[leastIndex];
			arr[leastIndex] = temp;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(arr[i] + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
