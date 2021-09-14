package step_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_8_1181 {

	public static String[] arr, sortArr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new String[n];
		sortArr = new String[n];
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		
		mergeSort(0, n-1);
		
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0] + "\n");
		
		for(int i=1; i<n; i++) {
			if(!arr[i-1].equals(arr[i])) {
				sb.append(arr[i] + "\n");				
			}
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
		mergeSort(mid + 1, end);
		
		int i = start;
		int j = mid + 1;
		int position = start;
		while(position <= end) {
			if(i > mid) {
				sortArr[position++] = arr[j++];
				continue;
			}
			
			if(j > end) {
				sortArr[position++] = arr[i++];
				continue;
			}
			
			boolean a = compareString(arr[i], arr[j]); 
			if(a) {
				sortArr[position++] = arr[i++];
			} else {
				sortArr[position++] = arr[j++];
			} 
		}
		
		for(i=start; i<=end; i++) {
			arr[i] = sortArr[i];
		}
	}
	
	// a가 짧으면 true 아니면 false
	// 길이가 같고 a가 사전적으로 앞에오면 true 아니면 false
	// 단어가 같으면 true
	public static boolean compareString(String a, String b) {
		
		boolean result = true;
		if(a.length() < b.length()) {
			result = true;
		} else if(a.length() > b.length()){
			result = false;
		} else {
			
			for(int i=0; i<a.length(); i++) {
				if(a.charAt(i) < b.charAt(i)) {
					result = true;
					break;
				} else if(a.charAt(i) > b.charAt(i)) {
					result = false;
					break;
				}
			}
			
		}
		
		return result;
	}
}
