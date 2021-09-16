package step.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_02_10773 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int sum = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=1; i<=n; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a == 0) {
				sum -= stack.pop();
			} else {
				sum += a;
				stack.push(a);
			}
		}
		
		System.out.println(sum);
		br.close();
	}
}
