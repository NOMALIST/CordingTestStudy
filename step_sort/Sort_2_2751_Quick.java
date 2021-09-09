package step_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_2_2751_Quick {

	public static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		sort(1, n);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			sb.append(arr[i] + "\n");
		}
		
		System.out.println(sb);
		br.close();
		
	}
	
	public static void sort(int start, int end) {
		
		if(start >= end) return;
		
		int pivot = start;
		int lowIndex = start + 1;
		int highIndex = end;
		
		while(true) {
			while(lowIndex <= highIndex && arr[lowIndex] < arr[pivot]) {
				lowIndex++;
			}
			
			while(highIndex >= lowIndex && arr[highIndex] >= arr[pivot]) {
				highIndex--;
			}
			
			if(lowIndex > highIndex) {
				break;
			}
			
			int temp  = arr[highIndex];
			arr[highIndex] = arr[lowIndex];
			arr[lowIndex] = temp;
		}
		
		int temp = arr[pivot];
		arr[pivot] = arr[highIndex];
		arr[highIndex] = temp;
		
		sort(start, highIndex-1);
		sort(highIndex+1, end);
	}
}
