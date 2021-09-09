package step_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 힘정렬
 * 백준 채점 기준
 * time : 1036 ms
 * memory : 131344 KB
 */
public class Sort_2_2751_Heap {

	public static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		
		int a = Integer.parseInt(br.readLine());
		
		arr[1] = a;
		
		for(int i=2; i<=n; i++) {
			a = Integer.parseInt(br.readLine());
			addHeap(i, a);
		}
		
		for(int i=n; i>=2; i--) {
			int temp = arr[1];
			arr[1] = arr[i];
			arr[i] = temp;
			
			reHeap(i-1);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			sb.append(arr[i] + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static void addHeap(int index, int value) {
		arr[index] = value;
		
		int now = index;
		int parent = findParent(now);
		
		while(arr[parent] < arr[now] && parent >= 1) {
			int temp = arr[parent];
			arr[parent] = arr[now];
			arr[now] = temp;
			
			now = parent;
			parent = findParent(now);
		}
	}
	
	public static int findParent(int index) {
		
		return index/2;
	}
	
	public static int findChild(int index, int endIndex) {
		int bigChild = -1;
		
		if(index*2 + 1 <= endIndex) {
			if(arr[index*2] > arr[index*2 + 1]) {
				bigChild = index*2;
			} else {
				bigChild = index*2 + 1;
			}
		} else {
			if(endIndex == index*2) {
				bigChild = index*2;
			}
		}
		
		return bigChild;
	}
	
	public static void reHeap(int endIndex) {
		
		int now = 1;
		int bigChild = findChild(now, endIndex);
		while(bigChild != -1 && arr[now] < arr[bigChild]) {
			int temp = arr[now];
			arr[now] = arr[bigChild];
			arr[bigChild] = temp;
			
			now = bigChild;
			bigChild = findChild(now, endIndex);
		}
	}
}
