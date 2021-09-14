package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class DataStructure_03_9012 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Character> stack;
		String str;
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			str = br.readLine();
			char a,b;
			stack = new Stack<Character>();
			boolean res = true;
			for(int j=0; j<str.length(); j++) {
				a = str.charAt(j);
				if(a == '(') {
					stack.push(a);
				} else {
					if(stack.empty()) {
						res = false;
						break;
					} else {
						b = stack.pop();
					}
					if(b != '(') {
						res = false;
						break;
					}
				}
			}
			
			if(stack.empty() && res) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
