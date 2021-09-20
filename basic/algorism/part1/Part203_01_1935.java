package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Part203_01_1935 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String STR = br.readLine();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Double> stack = new Stack<Double>();
		double a,b;
		for(int i=0; i<STR.length(); i++) {
			char c = STR.charAt(i);
			
			switch (c) {
			case '+':
				a = stack.pop();
				b = stack.pop();
				stack.push(b+a);
				break;
			case '-':
				a = stack.pop();
				b = stack.pop();
				stack.push(b-a);
				break;
			case '*':
				a = stack.pop();
				b = stack.pop();
				stack.push(b*a);
				break;
			case '/':
				a = stack.pop();
				b = stack.pop();
				stack.push(b/a);
				break;

			default:
				stack.push((double)arr[c-'A']);
			}
		}
		
		System.out.println(String.format("%.2f", stack.pop()));
		br.close();
	}
}
