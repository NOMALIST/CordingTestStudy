package step.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_06_17298 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		int[] ans = new int[n];
		
		for(int i=0; i<n; i++) {
			ans[i] = Integer.parseInt(input[i]);
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<n; i++) {
			if(stack.isEmpty()) {
				stack.push(i);
			} else {
				while(!stack.isEmpty() && ans[stack.peek()] < ans[i]) {
					ans[stack.pop()] = ans[i];
				}
				stack.push(i);
			}
		}
		
		while(!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			sb.append(ans[i] + " ");
		}
		
		System.out.println(sb);
		br.close();
	}
}
