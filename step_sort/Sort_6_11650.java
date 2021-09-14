package step_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_6_11650 {
	
	public static int[][] arrSort, arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1][2];
		arrSort = new int[n+1][2];
		
		String[] str;
		for(int i=1; i<=n; i++) {
			str = br.readLine().split(" ");
			
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
		}
		
		mergeSort(1, n);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			sb.append(arr[i][0] + " " + arr[i][1] + "\n");
		}
		
		System.out.println(sb);
		br.close();
		
		
		
	}
	
	public static void mergeSort(int start, int end) {
		int mid = (start + end)/2;
		
		if(start == end) {
			return;
		}
		
		mergeSort(start, mid);
		mergeSort(mid+1, end);
		
		int i = start;
		int j = mid+1;
		int position = start;
		
		while(i <= mid || j <= end) {
			if(i > mid) {
				arrSort[position][0] = arr[j][0];
				arrSort[position][1] = arr[j][1];
				position++;
				j++;
				continue;
			}
			
			if(j > end) {
				arrSort[position][0] = arr[i][0];
				arrSort[position][1] = arr[i][1];
				position++;
				i++;
				continue;
			}
			
			if(arr[i][0] < arr[j][0]) {
				arrSort[position][0] = arr[i][0];
				arrSort[position][1] = arr[i][1];
				i++;
			} else if(arr[i][0] > arr[j][0]) {
				arrSort[position][0] = arr[j][0];
				arrSort[position][1] = arr[j][1];
				j++;
			} else {
				if(arr[i][1] < arr[j][1]) {
					arrSort[position][0] = arr[i][0];
					arrSort[position][1] = arr[i][1];
					i++;
				} else {
					arrSort[position][0] = arr[j][0];
					arrSort[position][1] = arr[j][1];
					j++;					
				}
			}
			
			position++;
		}
		
		for(i=start; i<=end; i++) {
			arr[i][0] = arrSort[i][0];
			arr[i][1] = arrSort[i][1];
		}
	}

}
