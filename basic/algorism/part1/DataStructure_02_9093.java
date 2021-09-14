package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class DataStructure_02_9093 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String str;
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		for(int k=1; k<=n; k++) {
			str = br.readLine();
			
			for(int i=0; i<str.length(); i++) {
				stack.push(str.charAt(i));
			}
			
			for(int i=0; i<str.length(); i++) {
				sb.append(stack.pop());
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
		
	}
}
