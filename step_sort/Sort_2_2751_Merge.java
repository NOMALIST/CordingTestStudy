package step_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 병합정렬 사용 함
 * 백준 채점 기준
 * time : 1164 ms
 * memory : 139656 KB
 */
public class Sort_2_2751_Merge {

	public static int[] arr, sortArr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		sortArr = new int[n+1];
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
		int mid = (start + end)/2;
		
		if(start == end) return;
		
		sort(start, mid);
		sort(mid+1, end);
		
		int i = start, j = mid + 1;
		int index = start;
		
		// 분할된 두 구역을 비교해서 병합
		while(i <= mid && j <= end) {
			if(arr[i] > arr[j]) {
				sortArr[index++] = arr[j++];
			} else {
				sortArr[index++] = arr[i++];
			}
		}
		
		// 병합 후 나머지 가 존재할 경우 처리
		while(i <= mid) {
			sortArr[index++] = arr[i++];
		}
		
		// 병합 후 나머지 가 존재할 경우 처리
		while(j <= end) {
			sortArr[index++] = arr[j++];
		}
		
		for(int k=start; k<=end; k++) {
			arr[k] = sortArr[k];
		}
	}
}
