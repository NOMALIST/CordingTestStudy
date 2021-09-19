package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Practice_02_10799 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int ans = 0;
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '(') {
				if(str.length()-1 >= i+1 && str.charAt(i+1) == ')') {
					ans += stack.size();
					i++;
				} else {
					stack.push(c);
				}
			} else {
				ans += 1;
				stack.pop();
			}
		}
		
		System.out.println(ans);
		br.close();
	}
}
