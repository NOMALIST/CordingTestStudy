package step_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursion_4_11729 {

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		sb.append((int)Math.pow(2, n)-1 + "\n");
		
		move(n, 1, 2, 3);
		
		System.out.println(sb);
	}
	
	public static void move(int n, int from, int by, int to) {
		
		if(n == 1) {
			sb.append(from + " " + to + "\n");
			return;
		}
		
		move(n-1, from, to, by);
		sb.append(from + " " + to + "\n");
		move(n-1, by, from, to);
	}
}
