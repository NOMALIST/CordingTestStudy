package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Practice_04_17299 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] st = br.readLine().split(" ");
		int[] arr = new int[n];
		int[] count = new int[1000001];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;  i<n; i++) {
			arr[i] = Integer.parseInt(st[i]);
			count[arr[i]]++;
		}
		
		int[] ans = new int[n];
		stack.push(0);
		for(int i=1; i<n; i++) {
			if(count[arr[stack.peek()]] < count[arr[i]]) {
				while(!stack.isEmpty()) {
					if(count[arr[stack.peek()]] < count[arr[i]]) {
						ans[stack.pop()] = arr[i];
					} else {
						break;
					}
				}
			} 
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int a : ans) {
			sb.append(a + " ");
		}
		
		System.out.println(sb);
		br.close();
	}
}
