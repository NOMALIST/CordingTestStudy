package step_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursion_1_10872 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int ans = func(n);
		
		System.out.println(ans);
	}
	
	public static int func(int a) {
		
		if(a <= 1) return 1;
		else return a*func(a-1);
	}
}
