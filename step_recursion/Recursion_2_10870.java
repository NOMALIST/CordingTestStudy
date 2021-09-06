package step_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursion_2_10870 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int ans = fibonachi(n);
		
		System.out.println(ans);
		br.close();
		
	}
	
	public static int fibonachi(int n) {
		
		if(n <= 1) {
			return n;
		} else {
			return fibonachi(n-1) + fibonachi(n-2);
		}
	}
}
