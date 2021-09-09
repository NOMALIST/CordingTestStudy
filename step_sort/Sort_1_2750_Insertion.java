package step_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_1_2750_Insertion {

	public static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// Insertion Sort
		for(int i=1; i<n; i++) {
			int key = arr[i];
			int j;
			for(j=i-1; j>=0 && arr[j] > key; j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = key;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(arr[i] + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
