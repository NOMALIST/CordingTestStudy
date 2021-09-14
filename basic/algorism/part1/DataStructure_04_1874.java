package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class DataStructure_04_1874 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		boolean res = true;
		int pushIndex = 1;
		for(int i=1; i<=n; i++) {
			int a = Integer.parseInt(br.readLine());
			
			if(a > pushIndex) {
				while(a > pushIndex) {
					stack.push(pushIndex++);
					sb.append("+\n");
				}
				sb.append("+\n-\n");
				pushIndex++;
			} else if(a == pushIndex){
				sb.append("+\n-\n");
				pushIndex++;
			} else {
				if(stack.peek() == a) {
					stack.pop();
					sb.append("-\n");
				} else {
					sb = new StringBuilder();
					sb.append("NO");
					break;
				}
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
