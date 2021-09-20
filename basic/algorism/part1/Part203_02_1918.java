package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Part203_02_1918 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '(') {
				stack.push(c);
				continue;
			}
			
			if(c == ')') {
				while(!stack.isEmpty()) {
					if(stack.peek() == '(') {
						stack.pop();
						break;
					} else {
						sb.append(stack.pop());
					}
				}
			} else if(c == '*' || c == '/') {
				while(!stack.isEmpty()) {
					if(stack.peek() == '(') {
						break;
					} else if(stack.peek() == '*' || stack.peek() == '/') {
						sb.append(stack.pop());
					} else break;
				}
				stack.push(c);
			} else if(c == '+' || c == '-') {
				while(!stack.isEmpty()) {
					if(stack.peek() == '(') {
						break;
					} else {
						sb.append(stack.pop());
					}
				}
				stack.push(c);
			} else {
				sb.append(c);
			}
		}
		
		while(!stack.isEmpty()) {
			if(stack.peek() == '(') {
				stack.pop();
				break;
			} else {
				sb.append(stack.pop());
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
