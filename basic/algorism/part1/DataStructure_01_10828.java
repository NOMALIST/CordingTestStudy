package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class DataStructure_01_10828 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st; 
		String order;
		int amount;
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			order = st.nextToken();
			
			if("push".equals(order)) {
				amount = Integer.parseInt(st.nextToken());
				stack.add(amount);
			} else if("pop".equals(order)) {
				if(stack.empty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.pop() + "\n");
				}
			} else if("size".equals(order)) {
				sb.append(stack.size() + "\n");
			} else if("empty".equals(order)) {
				if(stack.empty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			} else if("top".equals(order)) {
				if(stack.empty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.peek() + "\n");
				}
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
