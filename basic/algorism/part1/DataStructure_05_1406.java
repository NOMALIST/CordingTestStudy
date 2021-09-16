package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class DataStructure_05_1406 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
		
		for(int i=0; i<str.length(); i++) {
			left.push(str.charAt(i));
		}
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String a = st.nextToken();
			switch (a) {
			case "L":
				if(!left.empty()) {
					right.push(left.pop());
				}
				break;
			case "D":
				if(!right.empty()) {
					left.push(right.pop());
				}
				break;
			case "B":
				if(!left.empty()) {
					left.pop();
				}
				break;
			case "P":
				char b = st.nextToken().charAt(0);
				left.push(b);
				break;
			default:
				break;
			}
		}
		
		while(!left.empty()) {
			right.push(left.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!right.empty()) {
			sb.append(right.pop());
		}
		
		System.out.println(sb);
		br.close();
		
	}
}
