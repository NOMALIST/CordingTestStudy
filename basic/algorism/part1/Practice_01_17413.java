package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Practice_01_17413 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '<' || c == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				
				sb.append(c);
				
				if(c == '<') {
					while(c != '>') {
						c = str.charAt(++i);
						sb.append(c);
					}
				}
			} else {
				stack.push(c);
			}
			
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
		br.close();
	}
}
