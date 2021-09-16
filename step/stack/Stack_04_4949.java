package step.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_04_4949 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		Stack<Character> stack;
		boolean result;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			str = br.readLine();
			stack = new Stack<Character>();
			result = true;
			if(".".equals(str)) {
				break;
			}
			
			for(int i=0; i<str.length(); i++) {
				switch (str.charAt(i)) {
				case '(':
					stack.push('(');
					break;
				case '[':
					stack.push('[');
					break;
				case ')':
					if(stack.isEmpty() || !stack.pop().equals('(')) {
						result = false;
					}
					break;
				case ']':
					if(stack.isEmpty() || !stack.pop().equals('[')) {
						result = false;
					}
					break;
				default:
					break;
				}
				
				if(!result) {
					break;
				}
			}
			
			if(result && stack.isEmpty()) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
